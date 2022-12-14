public interface ICSMAClient {
    public boolean getSignalFree(CSMAServer csmaServer);

    public void sendMessage(CSMAServer csmaServer, Message message);

    public void processMessage(String message);
}
