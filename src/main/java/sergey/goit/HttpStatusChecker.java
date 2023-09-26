package sergey.goit;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStatusChecker {

    private static final HttpClient CLIENT = HttpClient.newHttpClient();

    public String getStatusImage(int code) throws HttpStatusException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://http.cat/" + code + ".jpg"))
                .GET()
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        int statusCode = response.statusCode();

        if (statusCode == 200) {
            return "https://http.cat/" + code + ".jpg";
        } else {
            throw new HttpStatusException("Page not Found");
        }
    }
}