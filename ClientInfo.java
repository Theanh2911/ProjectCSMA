/**
 * Thong tin cua tram phat xong can gui du lieu di
 * bao gom:
 *  - ID: id cua tram phat xong
 *  - name: Ten cua tram phat xong
 */
public class ClientInfo {
    private String id;
    private String name;

    /*
        Phuong thuc khoi tai gom 2 tham so id va name
     */
    public ClientInfo(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
