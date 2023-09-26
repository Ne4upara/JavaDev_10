package sergey.goit;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class Service {

    public void directoriaExists(String d)  {

        if (!Files.exists(Path.of(d))) {
            try {
                Files.createDirectories(Path.of(d));
            } catch (IOException e) {
                System.err.println("Not Created Directotya");
            }
        }
    }
}