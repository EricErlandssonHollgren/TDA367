package Model;

public class Vector {


    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float x;

    public float y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    public void setLocation(double x, double y) {
        this.x = (float) x;
        this.y = (float) y;
    }
}
