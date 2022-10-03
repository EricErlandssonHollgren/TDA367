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

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

}
