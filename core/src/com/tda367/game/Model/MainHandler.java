package Model;

public abstract class MainHandler {
    // The next handler that the request will be sent to.
    protected MainHandler m_successor;

    // Sets the next successor.
    public void setSuccessor(MainHandler successor)
    {
        m_successor = successor;
    }


    public abstract void handleRequest(Request request);

}
