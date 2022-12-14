import javax.swing.*;
import java.util.Date;

/**
 * CSMAClient: dai dien cho mot tram phat xong can truyen du lieu di
 */

public class CSMAClient implements ICSMAClient {
    // Thong tin cua tram phat xong
    private ClientInfo clientInfo;

    // Phuong thuc khoi tao
    public CSMAClient(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }


    // Check xem tram dich co dang ranh roi ko
    @Override
    public boolean getSignalFree(CSMAServer csmaServer) {
        return csmaServer.process(new Message(clientInfo.getId(), "FREE_CHECK"));
    }

    // Thuc hien truyen du lieu toi tram phat xong dich
    @Override
    public void sendMessage(CSMAServer csmaServer, Message message) {
        csmaServer.makeBusy(); // set tram dich la dang thuc hien gui du lieu
        System.out.println("Processing message...");
        Timer timer = new Timer(5000, e -> {
            // delay 5 giay
            csmaServer.process(message);
            csmaServer.makeFree(); // set tram dich ranh roi
        });
        timer.start();
        timer.setRepeats(false);
    }

    @Override
    public void processMessage(String message) {

    }

    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }
}
