package game;

import Controller.KeyListener;
import Interfaces.IView;
import Model.Enemy.Enemies.Enemy1;
import Model.Player;
import View.PlayerView;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import View.EnemyView;

import java.util.ArrayList;
import java.util.List;

public class App extends ApplicationAdapter {
	List<IView> views;
	SpriteBatch batch;
	Player player;
	PlayerView view;
	KeyListener keyListener;
	@Override
	public void create () {
		views = new ArrayList<>();
		batch = new SpriteBatch();
		player = new Player(40f, 50f);
		keyListener = new KeyListener();
		view = new PlayerView();
		keyListener.addSubscribers(player);
		player.positionSubscriber(view);
		views.add(new EnemyView(new Enemy1()));
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 0);
		batch.begin();
		view.draw(batch);
		keyListener.UpdatePlayerPosition();
		batch.end();
		for (int i = 0; i <= views.size()-1; i++) {
			views.get(i).render();
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		for (int i = 0; i <= views.size()-1; i++) {
			views.get(i).dispose();
		}
	}
}
