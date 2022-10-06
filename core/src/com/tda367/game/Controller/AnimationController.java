package Controller;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationController {

    TextureRegion[] animationFrames;
    Animation animation;

    void playerRunAnimationLeft() {
        animationFrames = new TextureRegion[6];
        animationFrames[0] = new TextureRegion(new Texture("adventurer-run-00.png"));
        animationFrames[1] = new TextureRegion(new Texture("adventurer-run-01.png"));
        animationFrames[2] = new TextureRegion(new Texture("adventurer-run-02.png"));
        animationFrames[3] = new TextureRegion(new Texture("adventurer-run-03.png"));
        animationFrames[4] = new TextureRegion(new Texture("adventurer-run-04.png"));
        animationFrames[5] = new TextureRegion(new Texture("adventurer-run-05.png"));
    }

    void playerRunAnimationRight() {
        animationFrames = new TextureRegion[6];
        animationFrames[0] = new TextureRegion(new Texture("adventurer-run-00.png"));
        animationFrames[1] = new TextureRegion(new Texture("adventurer-run-01.png"));
        animationFrames[2] = new TextureRegion(new Texture("adventurer-run-02.png"));
        animationFrames[3] = new TextureRegion(new Texture("adventurer-run-03.png"));
        animationFrames[4] = new TextureRegion(new Texture("adventurer-run-04.png"));
        animationFrames[5] = new TextureRegion(new Texture("adventurer-run-05.png"));

        Texture t = new Texture("adventurer-run-00.png");

    }

}
