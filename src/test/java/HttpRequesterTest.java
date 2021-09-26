import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HttpRequesterTest {

    @Test
    public void verifyURLShouldReturnTrueWhenGivenValidURL(){
        HttpRequester httpRequester = new HttpRequester();
        boolean test1 = httpRequester.verifyURL("http://bbc.com");
        boolean test2 = httpRequester.verifyURL("https://bbc.com");
        boolean test3 = httpRequester.verifyURL("https://www.bbc.com");

        assertTrue(test1);
        assertTrue(test2);
        assertTrue(test3);
    }

    @Test
    public void verifyURLShouldReturnFalseWhenGivenInvalidURL(){
        HttpRequester httpRequester = new HttpRequester();
        boolean test1 = httpRequester.verifyURL("");
        boolean test2 = httpRequester.verifyURL("bbc.com");
        boolean test3 = httpRequester.verifyURL("htp://bbc.com");

        assertFalse(test1);
        assertFalse(test2);
        assertFalse(test3);
    }
}