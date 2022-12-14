/**
 * Message dung de giao tiep truyen du lieu giua cac tram phat xong
 */

public class Message {
    private String clientID; // client ID cua tram truyen du lieu
    private String message; // Du lieu can truyen


    public Message(String clientID, String message) {
        this.clientID = clientID;
        this.message = message;
    }

    public Message(String message) {
        this.message = message;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
