package Model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class Ground {

    private World world;

    public Body createGround(World world) {
        BodyDef groundBodyDef = new BodyDef();
        groundBodyDef.type = BodyDef.BodyType.StaticBody;
        groundBodyDef.position.set(new Vector2(0.0f, 0.0f));
        Body bodyHej = world.createBody(groundBodyDef);
        PolygonShape groundBox = new PolygonShape();
        groundBox.setAsBox(16.01f, 2.0f);
        bodyHej.createFixture(groundBox, 0.5f);
        groundBox.dispose();
        return bodyHej;
    }

}
