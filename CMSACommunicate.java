import java.io.Closeable;
import java.io.IOException;


/**
 * CMSACommunicate phuc vu viec giao tiep giua cac tram phat song
 * su dung giao thức csma
 *
 */

public class CMSACommunicate implements Closeable {
    private CSMAServer csmaServer;
    private CSMAClient csmaClient;

    /*
        Phuong thuc khoi tao 2 tham so
        - CSMAServer: Tram phat song dich
        - CSMAClient: Tram can gui du lieu toi tram dich
     */
    public CMSACommunicate(CSMAServer csmaServer, CSMAClient csmaClient) {
        this.csmaServer = csmaServer;
        this.csmaServer.addObserver(csmaClient);
        this.csmaClient = csmaClient;

        // dong ket noi khi tat ung dung
        Runtime.getRuntime().addShutdownHook(new Thread(() -> close()));
    }

    /*
        Dong ket noi giua 2 tram phat song khi gui du lieu xong
     */
    @Override
    public void close() {
        csmaServer.removeObserver(csmaClient);
    }
}
