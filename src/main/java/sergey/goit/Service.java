package sergey.goit;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class Service {

    private static final String PATH_DIRECTORIY = "src/main/resources/images/";
    public void directoriaExists(String d) throws IOException {

        if (!Files.exists(Path.of(d))) {
            Files.createDirectories(Path.of(d));
        }
    }
}