package Model;
public class Block {
    private int x;
    private int y;
    private int width;
    private int height;

    public Block(int x, int y, int height, int width){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Gets the x-coordinate of the object of int
     * @return the x-coordinate of a block
     */
    public int getX(){
        return x;
    }
    /**
     * Gets the y-coordinate of the object of int
     * @return the y-coordinate of a block
     */
    public int getY(){
        return y;
    }
    /**
     * Gets the height of the object of int
     * @return the height of a block
     */
    public int getHeight(){
        return height;
    }
    /**
     * Gets the width of the object of int
     * @return the width of a block
     */
    public int getWidth(){
        return width;
    }

}
