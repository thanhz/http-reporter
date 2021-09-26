import java.io.IOException;

import java.net.http.HttpRequest;
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
                .build();
    }

    public HttpHeader sendRequest(HttpRequest request) throws IOException, InterruptedException {
        return new HttpHeader("/",404,"0","1/1/1");
    }
}
