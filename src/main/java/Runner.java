import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {

    static List<HttpRequest> urls = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HttpRequester httpRequester = new HttpRequester();
        setup(httpRequester);

        int choice = getOption();
        while (choice != 0) {
            switch (choice) {
                case 1:
                    for (HttpRequest requests : urls) {
                        System.out.println(requests.uri());
                    }
                    break;
                case 2:
                    System.out.println("Type in the URL you would like to add:");
                    scanner.nextLine();
                    String url = scanner.nextLine();
                    if (httpRequester.verifyURL(url)) {
                        urls.add(httpRequester.createRequest(url));
                    } else {
                        System.err.println("INVALID URL");
                    }
                    break;
                case 3:
                    for (HttpRequest requests : urls) {
                        try {
                            System.out.println(httpRequester.sendRequest(requests));
                        } catch (IOException | InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }
            choice = getOption();
        }

        System.out.println("\nThank-you");

    }

    private static void setup(HttpRequester httpRequester) {
        urls.add(httpRequester.createRequest("https://www.bbc.co.uk/iplayer"));
        urls.add(httpRequester.createRequest("http://www.oracle.com/technetwork/java/javase/downloads/index.html"));
        urls.add(httpRequester.createRequest("https://coinmarketcap.com/"));
    }

    private static int getOption() {
        System.out.println("What would you like to do ?");
        System.out.println("0. Quit");
        System.out.println("1. View Current url list");
        System.out.println("2. Add url to list");
        System.out.println("3. Generate url report");

        System.out.println("Enter your choice");
        return scanner.nextInt();
    }
}
