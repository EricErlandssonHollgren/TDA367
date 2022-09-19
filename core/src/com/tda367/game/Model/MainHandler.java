package com.tda367.game.Model;

public abstract class MainHandler {
    protected MainHandler m_successor;

    public void setSuccessor(MainHandler successor)
    {
        m_successor = successor;
    }

    public abstract void handleRequest(Request request);

}
/*
MainHandler h1 = new Goldhandler();
    MainHandler h2 = new PointHandler();
		h1.setSuccessor(h2);

                // Send requests to the chain
                h1.handleRequest(new Request(HandlerItemDefiners.POINTS, 100));


 */