package com.tda367.game.Model;

public class PointHandler extends MainHandler {
    private int points = 0;


    public void handleRequest(Request request){
        if (request.getDescription() == HandlerItemDefiners.POINTS) {
            addPoints(request.getValue());
        }
    }

    private void addPoints(int amount){
        points+=amount;
    }

    public int getPoints() {
        return (this.points);
        // add time passed
    }
}

/*

Måste sätta successor

public class Main
{
	public static void main(String[] args)
	{
		// Setup Chain of Responsibility
		Handler h1 = new ConcreteHandlerOne();
		Handler h2 = new ConcreteHandlerTwo();
		Handler h3 = new ConcreteHandlerThree();
		h1.setSuccessor(h2);
		h2.setSuccessor(h3);

		// Send requests to the chain
		h1.handleRequest(new Request("Negative Value ", -1));
		h1.handleRequest(new Request("Negative Value ",  0));
		h1.handleRequest(new Request("Negative Value ",  1));
		h1.handleRequest(new Request("Negative Value ",  2));
		h1.handleRequest(new Request("Negative Value ", -5));
	}
}

 */