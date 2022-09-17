package game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.utils.ScreenUtils;
import View.RenderEnemy;

public class App extends ApplicationAdapter {

	RenderEnemy enemy1 = new RenderEnemy();
	
	@Override
	public void create () {
		enemy1.create();
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		enemy1.render(800,0);
	}
	
	@Override
	public void dispose () {
		enemy1.dispose();
	}
}
