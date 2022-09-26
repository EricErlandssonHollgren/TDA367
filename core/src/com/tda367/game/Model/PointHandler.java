package Model;

public class PointHandler extends MainHandler {
    private int points = 0;

    // Checks if the request is meant for this handler.
    // If it´s the correct handler it will add the Points.
    // If it isn't the correct handler it will give it to the next handler.
    public void handleRequest(Request request){
        if (request.getDescription() == HandlerItemDefiners.POINTS) {
            addPoints(request.getValue());
        }
        else if (m_successor != null)
        {
            m_successor.handleRequest(request);
        }
    }

    // adds the bonus points
    private void addPoints(int amount){
        System.out.println(amount);
        points+=amount;
    }

    // Returns the
    public int getPoints() {
        return (this.points);
        // add time passed
    }
}