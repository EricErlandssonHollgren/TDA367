package View;

import Interfaces.IView;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Button;

public class ButtonView<button> implements IView {

    private Button button;
    private SpriteBatch batch;
    private Texture texturePath;

    public ButtonView(Button button) {
        this.button = button;
        this.batch = new SpriteBatch();
        this.texturePath = new Texture("badlogic.jpg");
    }

    @Override
    public void render() {
        batch.begin();
        batch.draw(img, 300, 0, (float) Math.ceil(img.getHeight()*0.2), (float) Math.ceil(img.getWidth()*0.25));
        batch.end();
    }

    @Override
    public void dispose() {

    }
}
