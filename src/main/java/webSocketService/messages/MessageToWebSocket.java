package webSocketService.messages;

    import frontend.WebSocketGameServlet;
    import messageSystem.Abonent;
    import messageSystem.Address;
    import messageSystem.Message;
    import webSocketService.WebSocketService;

public abstract class MessageToWebSocket extends Message {
    public MessageToWebSocket(Address from, Address to) {
        super(from, to);
    }

    @Override
    public void exec(Abonent abonent) {
        if (abonent instanceof WebSocketGameServlet) {
            exec((WebSocketService) abonent);
        }
    }

    protected abstract void exec(WebSocketService frontEnd);
}
