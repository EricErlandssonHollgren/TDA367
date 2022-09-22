package game;

<<<<<<<<< Temporary merge branch 1
import Controller.KeyListener;
import Interfaces.IView;
import Model.Enemy.Enemies.Enemy1;
import Model.Enemy.Enemy;
import Model.Player;
import View.PlayerView;
=========
import Interfaces.IView;
>>>>>>>>> Temporary merge branch 2
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import View.EnemyView;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class App extends ApplicationAdapter {
<<<<<<<<< Temporary merge branch 1
=========

>>>>>>>>> Temporary merge branch 2
	List<IView> views;
	SpriteBatch batch;
	KeyListener keyListener;

	Enemy enemy = new Enemy1();
	@Override
	public void create () {
<<<<<<<<< Temporary merge branch 1
=========

>>>>>>>>> Temporary merge branch 2
		views = new ArrayList<>();
		batch = new SpriteBatch();
		Player player = new Player(40f, 50f);
		keyListener = new KeyListener();
		PlayerView playerView = new PlayerView();



		keyListener.addSubscribers(player);
<<<<<<<<< Temporary merge branch 1
		player.positionSubscriber(view);
		views.add(new EnemyView(enemy));
=========
		player.positionSubscriber(playerView);
		views.add(playerView);
>>>>>>>>> Temporary merge branch 2
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 0);
		batch.begin();
		keyListener.UpdatePlayerMovement();
		for (int i = 0; i <=views.size()-1; i++) {
			views.get(i).render();

		}
		batch.end();
		for (int i = 0; i <= views.size()-1; i++) {
			views.get(i).render();
		}
	}
	
	@Override
	public void dispose () {
<<<<<<<<< Temporary merge branch 1
		batch.dispose();
=========
>>>>>>>>> Temporary merge branch 2
		for (int i = 0; i <= views.size()-1; i++) {
			views.get(i).dispose();
		}
	}
}
