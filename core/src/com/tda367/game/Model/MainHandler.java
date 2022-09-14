package com.tda367.game.Model;

public abstract class MainHandler {
    protected MainHandler m_successor;
    public void setSuccessor(MainHandler successor)
    {
        m_successor = successor;
    }

    public abstract void handleRequest(Request request);

}
