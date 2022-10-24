package Model;

public class Goldhandler extends MainHandler {
    private static int gold = 10000;

    /**
     * Checks if the request is meant for this handler. If it's the correct handler it will add the gold.
     * If it isn't it will give it to the next handler.
     * @param request
     */
    public void handleRequest(Request request){

        if (request.getDescription() == HandlerItemDefiners.GOLD) {
            addGold(request.getValue());
        }
        else if (m_successor != null)
        {
            m_successor.handleRequest(request);
        }
    }

    /**
     * Adds gold by a set amount
     * @param amount the amout of gold to be added
     */
    public static void addGold(int amount){
        gold+=amount;
    }

    /**
     * Getter for getting the current number of gold.
     * @return How much gold there is currently
     */
    public static int getGold() {return gold;}
}
