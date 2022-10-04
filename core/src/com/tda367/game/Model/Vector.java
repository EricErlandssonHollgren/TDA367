package Model;

public class Vector {


    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    private float x;

    private float y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    public void setLocation(float x, float y) {
        this.x = x;
        this.y = y;
    }
}
