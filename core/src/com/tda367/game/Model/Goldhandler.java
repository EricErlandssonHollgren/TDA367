package Model;

public class Goldhandler extends MainHandler {
    private static int gold = 100;

    // Checks if the request is meant for this handler.
    // If it´s the correct handler it will add the gold.
    // If isn't it will give it to the next handler.
    public void handleRequest(Request request){

        if (request.getDescription() == HandlerItemDefiners.GOLD) {
            addGold(request.getValue());
        }
        else if (m_successor != null)
        {
            m_successor.handleRequest(request);
        }
    }

    // Adds gold to the total
    public static void addGold(int amount){
        gold+=amount;
    }

    // Returns gold
    public int getGold() {return gold;}
}
