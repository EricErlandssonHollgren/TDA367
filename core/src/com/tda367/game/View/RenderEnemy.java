package com.tda367.game.View;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.tda367.game.Model.Enemy.EnemyFactory;

public class RenderEnemy extends ApplicationAdapter {

    private SpriteBatch batch;
    private Texture img;

    public void create() {
        batch = new SpriteBatch();
        img = new Texture(Gdx.files.internal(EnemyFactory.createEnemy1().getSpritePath()));
    }

    public void render() {
        ScreenUtils.clear(Color.BLACK);
        batch.begin();
        batch.draw(img, 200,200);
        batch.end();
    }

    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
