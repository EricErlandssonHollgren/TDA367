package Model;

import Interfaces.IObject;

public class Block implements IObject {
    private float x;
    private float y;
    private float width;
    private float height;

    /**
     * When creating a block it should have four parameters which
     * defines it.
     * @param x represents the block's x-coordinate
     * @param y represents the block's y-coordinate
     * @param height represents the height of the block
     * @param width represents the width of the block
     */
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
   @Override
    public float getX(){
        return x;
    }
    /**
     * Gets the y-coordinate of the object of int
     * @return the y-coordinate of a block
     */
   @Override
    public float getY(){
        return y;
    }
    /**
     * Gets the height of the object of int
     * @return the height of a block
     */
  @Override
    public float getHeight(){
        return height;
    }
    /**
     * Gets the width of the object of int
     * @return the width of a block
     */
    @Override
    public float getWidth(){
        return width;
    }

}
