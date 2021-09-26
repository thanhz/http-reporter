import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;
import java.net.http.HttpRequest;

import static org.junit.jupiter.api.Assertions.*;

class HttpRequesterTest {

    static HttpRequester httpRequester;
    private MockWebServer mockWebServer;

    @BeforeAll
    public static void init() {
        httpRequester = new HttpRequester();
    }

    @Test
    public void verifyURLShouldReturnTrueWhenGivenValidURL() {
        HttpRequester httpRequester = new HttpRequester();
        boolean test1 = httpRequester.verifyURL("http://bbc.com");
        boolean test2 = httpRequester.verifyURL("https://bbc.com");
        boolean test3 = httpRequester.verifyURL("https://www.bbc.com");

        assertTrue(test1);
        assertTrue(test2);
        assertTrue(test3);
    }

    @Test
    public void verifyURLShouldReturnFalseWhenGivenInvalidURL() {
        boolean test1 = httpRequester.verifyURL("");
        boolean test2 = httpRequester.verifyURL("bbc.com");
        boolean test3 = httpRequester.verifyURL("htp://bbc.com");

        assertFalse(test1);
        assertFalse(test2);
        assertFalse(test3);
    }

    @Test
    public void sendRequestShouldCorrectlyMapRequestAttributesToHttpHeaderObject() throws IOException, InterruptedException {
        mockWebServer = new MockWebServer();
        HttpRequest request = httpRequester.createRequest(mockWebServer.url("/test").toString());
        mockWebServer.enqueue(new MockResponse()
                //.addHeader("Content-Type", "application/json; charset=utf-8")
                .addHeader("Content-Length", "0")
                .addHeader("date", "26/09/2021")
                .setResponseCode(200));

        HttpHeader httpHeader = httpRequester.sendRequest(request);
        System.out.println(httpHeader.toString());

        assertTrue(httpHeader.getUri().contains("/test"));
        assertEquals(200 ,httpHeader.getStatus());
        assertEquals("0" ,httpHeader.getContentLength());
        assertEquals("26/09/2021" ,httpHeader.getDate());

    }
}