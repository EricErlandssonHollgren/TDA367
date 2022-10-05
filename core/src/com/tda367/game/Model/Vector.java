package Model;

public class Vector {


    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    private float x;

    private float y;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }


    public void setLocation(double x, double y) {
        this.x = (float) x;
        this.y = (float) y;
    }
}
