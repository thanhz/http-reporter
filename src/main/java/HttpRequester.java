import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpRequester {

    public boolean verifyURL(String url) {
        String URL_REGEX = "https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)";
        Pattern URL_PATTERN = Pattern.compile(URL_REGEX);

        if (url == null) {
            return false;
        }

        Matcher matcher = URL_PATTERN.matcher(url);
        return matcher.matches();
    }

    public HttpRequest createRequest(String url) {
        return HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(url))
                .build();
    }

    public HttpHeader sendRequest(HttpRequest request) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        HttpHeaders headers = response.headers();

        String uri = response.uri().toString();
        int status = response.statusCode();
        String contentLength = headers.firstValue("content-length").orElse("EMPTY");
        String date = headers.firstValue("date").orElse("EMPTY");

        return new HttpHeader(uri, status, contentLength, date);
    }
}
