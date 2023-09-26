package sergey.goit;

import java.util.Scanner;

public class HttpImageStatusCli {

    public void askStatus() {
        HttpStatusChecker checker = new HttpStatusChecker();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter HTTP code");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("close")) {
                break;
            }
            if (input.matches("\\d+")) {
                int code = Integer.parseInt(input);

                checker.getStatusImage(code);
                if (checker.getStatusCode() == 404) {
                    System.out.println("There is not image for HTTP status " + code);
                } else {
                    new HttpStatusImageDownloader().downloadStatusImage(code);
                    System.out.println("Image download");
                }
            } else {
                System.out.println("Please enter digit numer");
            }
        }
    }
}
