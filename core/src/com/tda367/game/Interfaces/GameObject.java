package Interfaces;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import java.awt.*;

public abstract class GameObject {

    protected Pixmap pixmap;
    protected Color color;
    protected Vector2 pos, dim;
    protected boolean hit, remove;
    protected Sprite sprite;
    protected Texture texture;

    protected void createGraphics(){
        int width = 0;
        int height= 0;

        pixmap = new Pixmap(width, height, Pixmap.Format.RGB888);
        pixmap.setColor(color);
        pixmap.fill() ;
        pixmap.drawRectangle(0,0,width,height);
        texture = new Texture(pixmap);
        sprite = new Sprite();

    }

    protected GameObject(){
        pos = new Vector2();
        dim = new Vector2();
        hit = false;
        remove = false;
    }

    protected Rectangle rectangleArea(){
        return new Rectangle((int) pos.x, (int) pos.y, (int) dim.x, (int) dim.y);
    }

   public Vector2 getPos(){
        return pos;
   }
   public Vector2 getDim(){
        return dim;
   }

   public boolean isHit()
   {
       return hit;
   }
   public boolean isRemove(){
        return remove;
   }
}
