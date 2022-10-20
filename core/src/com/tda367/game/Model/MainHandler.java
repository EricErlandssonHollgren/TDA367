package Model;

public abstract class MainHandler {
    /**
     * Successor in the chain of responsibility
     */
    protected MainHandler m_successor;

    /**
     * Sets the successor in the chain of responsibility
     * @param successor next handler in the chain
     */
    public void setSuccessor(MainHandler successor)
    {
        m_successor = successor;
    }

    /**
     * Handles a request
     * @param request request object
     */
    public abstract void handleRequest(Request request);

}
