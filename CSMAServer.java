import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Set;

/**
 * CSMAServer: dai dien cho mot tram phat xong nhan du lieu
 */

public class CSMAServer {
    // danh sach cac tram phat xong can gui du lieu toi
    private Set<ICSMAClient> csmaClientObservers;

    // Check xem tram phat xong hien tai co dang ranh hay khong
    private boolean isFree = true;

    // Them mot tram phat xong can gui du lieu toi
    public void addObserver(ICSMAClient observer) {
        csmaClientObservers.add(observer);
    }

    // Xoa 1 tram phat xong khi gui du lieu hoan tat
    public void removeObserver(ICSMAClient observer) {
        csmaClientObservers.remove(observer);
    }

    /*
         Notify toi tat cac cac tram phat xong can gui du lieu
         - Input: message - Thong tin can gui
     */
    public void notify(String message) {
        for (ICSMAClient client : csmaClientObservers) {
            client.processMessage(message);
        }
    }

    /*
         Notify toi 1 tram phat xong cu the
         - @Param:
            message - Thong tin can gui
            clientID - id cua tram phat xong can gui
     */
    public void notify(String clientID, String message) {
        for (ICSMAClient client : csmaClientObservers) {
            if (((CSMAClient) client).getClientInfo().getId().equals(clientID)) {
                client.processMessage(message);
            }
        }
    }

    public Set<ICSMAClient> getCsmaClientObservers() {
        return csmaClientObservers;
    }

    public void setCsmaClientObservers(Set<ICSMAClient> csmaClientObservers) {
        this.csmaClientObservers = csmaClientObservers;
    }

    /*
         Xu ly message nhan duoc tu cac tram phat xong
         - @Param:
            message - Du lieu nhan duoc
     */
    public boolean process(Message message) {
        if (message.getMessage().equals("FREE_CHECK")) {
            // Neu message nhan duoc co dang FREE_CHECK
            // tuc la client dang check xem tram co free khong de thuc hien truyen du lieu
            return isFree();
        } else {
            // Nhan duoc message va xu ly message
            System.out.println(
                    String.format("Process message success from [%s] - message [%s]",
                            message.getClientID(),
                            message.getMessage()));
            return true;
        }
    }

    // set tram phat xong la dang thuc hien giao tiep boi 1 tram phat xong khac
    public void makeBusy() {
        setFree(false);
    }

    // set tram phat xong la dang ranh roi, co the truyen du lieu
    public void makeFree() {
        setFree(true);
    }

    private void setFree(boolean free) {
        synchronized (this) {
            isFree = free;
        }
    }

    public boolean isFree() {
        return isFree;
    }
}
