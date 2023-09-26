package sergey.goit;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStatusChecker {

    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private int statusCode;

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusImage(int code) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://http.cat/" + code + ".jpg"))
                .GET()
                .build();

        try {
            HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            statusCode = response.statusCode();
            return "https://http.cat/" + code + ".jpg";
        } catch (IOException | InterruptedException e) {
            System.err.println("Error. " + code + " not found");
        }
        return "Page not Found";
    }
}