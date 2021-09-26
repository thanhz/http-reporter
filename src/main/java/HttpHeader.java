public class HttpHeader {
    private String uri;
    private int status;
    private String contentLength;
    private String date;

    public HttpHeader(String uri, int status, String contentLength, String date) {
        this.uri = uri;
        this.status = status;
        this.contentLength = contentLength;
        this.date = date;
    }

    public String getUri() {
        return uri;
    }

    public int getStatus() {
        return status;
    }

    public String getContentLength() {
        return contentLength;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "{" + "\n" +
                "   Url: " + uri + "," + "\n" +
                "   Status_code: " + status + "," + "\n" +
                "   Content_Length: " + contentLength + "," + "\n" +
                "   Date: " + date + "\n" +
                "}";
    }
}
