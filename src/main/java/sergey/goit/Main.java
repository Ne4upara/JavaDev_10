package sergey.goit;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws HttpStatusException, IOException, InterruptedException {

        HttpImageStatusCli httpImageStatusCli = new HttpImageStatusCli();
        httpImageStatusCli.askStatus();
    }
}