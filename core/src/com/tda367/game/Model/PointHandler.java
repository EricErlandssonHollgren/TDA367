package Model;

public class PointHandler extends MainHandler {
    private static int points = 200;
    private GameTimer gameTimer;

    public PointHandler() {
        gameTimer = GameTimer.GetInstance();
    }

    /**
     * Checks if the request is meant for this handler. If it's correct the handler will add the points.
     * If it isn't the correct handler it will give it to the next handler-
     * @param request
     */
    public void handleRequest(Request request){
        if (request.getDescription() == HandlerItemDefiners.POINTS) {
            addPoints(request.getValue());
        }
        else if (m_successor != null)
        {
            m_successor.handleRequest(request);
        }
    }

    /**
     * Adds the bonus points
     * @param amount the amount of points to be added
     */
    public static void addPoints(int amount){
        points+=amount;
    }

    /**
     * Getter for returning the current set of points
     * @return the current number of points
     */
    public static int getPoints() {
        return points + (int) gameTimer.GetTime() ;
    }
}