import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        CSMAServer csmaServer = new CSMAServer();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so luong tram phat: ");
        int numberNode = scanner.nextInt();

        // thread de xu ly nhieu client
        ExecutorService executorService = Executors.newFixedThreadPool(numberNode);

        // start multi client
        for (int i = 0; i < numberNode; i++) {
            final CSMAClient client = new CSMAClient(new ClientInfo("Client " + (i + 1), "Client " + (i + 1)));
            executorService.submit(() -> {

                new ApplicationForm(csmaServer, client).setVisible(true);

            });
        }
        executorService.shutdown();
    }
}
