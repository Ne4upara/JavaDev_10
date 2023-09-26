package sergey.goit;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class HttpStatusImageDownloader {

    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private HttpResponse<InputStream> response;
    private static final String PATH_DIRECTORIY = "src/main/resources/images/";

    public void downloadStatusImage(int code) {
        String urlImage = new HttpStatusChecker().getStatusImage(code);
        if (!urlImage.equalsIgnoreCase("Page not Found")) {
            URI uriImage = URI.create(urlImage);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uriImage)
                    .GET()
                    .build();

            try {
                response = CLIENT.send(request, HttpResponse.BodyHandlers.ofInputStream());
            } catch (IOException | InterruptedException e) {
                System.err.println("Error 505");
            }

            Path imagePath = Path.of(PATH_DIRECTORIY + code + ".jpg");
            new Service().directoriaExists(PATH_DIRECTORIY);

            try (InputStream inputStream = response.body()) {
                Files.copy(inputStream, imagePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.err.println("File not download");
            }
        }
    }
}
