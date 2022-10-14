package View;

import Controller.PlayerKeyListener;
import Interfaces.IView;
import Model.*;
import Model.Enemy.EnemyFactory;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.tda367.game.App;


public class GameView extends ScreenAdapter  {
    private final App game;
    private SpriteBatch batch;
    private GameTimer timer;
    private ViewHolder views;
    private Player player;
    private RoundHandler roundHandler;
    private MainHandler goldHandler;
    private MainHandler pointsHandler;
    private Tower tower;
    private HealthBar healthBar;
    private WorldBoundaries worldBoundaries;
    private CollisionDetection collisionDetection;
    private EntityHolder entityHolder;
    private PlayerKeyListener playerKeyListener;
    private MainMenuView mainMenuView;

    public GameView(App game) {
        this.game = game;
        System.out.println("gameview");
    }

    public void show () {
        //Handlers

		player = new Player(120,100, 50, 37);
		healthBar = new HealthBar(player.getPosX(), player.getPosY(), player.getHealth(), player.getWidth(), player.getHeight());
		tower = new Tower();
		worldBoundaries = new WorldBoundaries();
		timer = GameTimer.GetInstance();
		//setup chain of responsibility?
		goldHandler = new Goldhandler();
		pointsHandler = new PointHandler();
		goldHandler.setSuccessor(pointsHandler);

		roundHandler = RoundHandler.GetInstance(timer);
		entityHolder = EntityHolder.getInstance();
		collisionDetection = CollisionDetection.getInstance();
		views = new ViewHolder(-0.5f,player, tower, EnemyFactory.createEnemy1(),worldBoundaries, healthBar);

		//Controllers
		playerKeyListener = new PlayerKeyListener();
		playerKeyListener.addSubscribers(player);
    }


    @Override
    public void render(float delta) {
        timer.UpdateTime(Gdx.graphics.getDeltaTime());
        collisionDetection.CheckCollisionPlayerAndEnemy(player);
        collisionDetection.CheckCollisionPlayerAndEnemy(player);
        collisionDetection.CheckCollisionPlayerNextStep(player);
        playerKeyListener.UpdatePlayerMovement();
        ScreenUtils.clear(0, 0, 0, 0);
        views.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
        views.dispose();
    }
}