package sergey.goit;

import java.io.IOException;
import java.util.Scanner;

public class HttpImageStatusCli {

    public void  askStatus() throws HttpStatusException, IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter HTTP code");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("close")) {
                break;
            }
            if (input.matches("\\d+")) {
                int code = Integer.parseInt(input);
                new HttpStatusImageDownloader().downloadStatusImage(code);
                System.out.println("Image download");
            } else {
                System.out.println("Please enter digit numer");
            }
        }
    }
}
