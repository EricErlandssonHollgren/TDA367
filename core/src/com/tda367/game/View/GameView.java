package View;

import Controller.PlayerController;
import Controller.ProjectileController;
import Controller.TowerController;
import Interfaces.*;
import Model.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.tda367.game.App;

import java.util.List;
import java.util.Map;


public class GameView extends ScreenAdapter implements IGameOverSubscriber {
    private final App game;
    private SpriteBatch batch;
    private GameTimer timer;
    private ViewHolder views;
    private Player player;
    private RoundHandler roundHandler;
    private MainHandler goldHandler;
    private MainHandler pointsHandler;
    private Tower tower;
    private Waves wave;
    private HealthBar healthBar;
    private WorldBoundaries worldBoundaries;
    private CollisionDetection collisionDetection;
    private EntityHolder entityHolder;
    private TowerController towerController;
    private PlayerController playerController;
    private ProjectileController projectileController;
    private static GameView gameView;

    public GameView(App game) {
        this.game = game;
    }

    public void show () {
        //Objects

        player = new Player(120,100, 50, 37, 125);
        healthBar = new HealthBar(player.getPosX(), player.getPosY(), player.getHealth(), player.getWidth(), player.getHeight());
        worldBoundaries = new WorldBoundaries();
        timer = GameTimer.GetInstance();
        wave = new Waves();

        //Handlers
        goldHandler = new Goldhandler();
        pointsHandler = new PointHandler();
        goldHandler.setSuccessor(pointsHandler);

        //Instantiates Tower, (needs to be done after instantiating Goldhandler).
        tower = new Tower((Goldhandler) goldHandler);

        entityHolder = EntityHolder.getInstance();
        collisionDetection = CollisionDetection.getInstance();

        //Controllers
        towerController = new TowerController();
        towerController.addSubscribers(tower);
        playerController = new PlayerController();
        playerController.addSubscribers(player);
        towerController = new TowerController();
        towerController.addSubscribers(tower);
        projectileController = new ProjectileController(entityHolder,collisionDetection,timer);

        //Create views and objects
        IView worldBoundariesView = new WorldBoundariesView(worldBoundaries);
        IView wavesView = new WavesView(wave);
        IView playerView = new PlayerView();
        IView towerView = new TowerView(tower);
        IView buttonView = new ButtonView(towerController, tower);
        IView healthBarView = new HealthBarView(player.healthBar);
        IView statsView = new StatsView();
        IView background = new BackgroundView();
        IView projectileView = new ProjectileView(projectileController);
        IView messageView = new MessageView();


        player.positionSubscriber((IEntitySubscriber) playerView);
        tower.messageSubscriber((IMessageSubscriber) messageView);
        tower.gameOverSubscriber((IGameOverSubscriber) this);

        //Add views to list and they will be rendered. Views must implement IView
        views = new ViewHolder();
        views.addView(background);
        views.addView(worldBoundariesView);
        views.addView(statsView);
        views.addView(playerView);
        views.addView(towerView);
        views.addView(buttonView);
        views.addView(wavesView);
        views.addView(statsView);
        views.addView(healthBarView);
        views.addView(projectileView);
        views.addView(messageView);

    }


    @Override
    public void render(float delta) {
        timer.UpdateTime(Gdx.graphics.getDeltaTime());

        collisionDetection.CheckCollisionPlayerAndEnemy(player);
        collisionDetection.CheckCollisionPlayerNextStep(player);
        collisionDetection.CheckCollisionEnemyAndHitBox(player);
        collisionDetection.CheckCollisionTowerAndEnemy(tower);
        collisionDetection.CheckCollisionTowerAndFireAttack(tower);

        List<IProjectile> projectileGround = collisionDetection.checkCollisionProjectileGround();
        Map<Entity,IProjectile> projectileEnemy = collisionDetection.checkCollisionProjectileAndEnemy();
        playerController.UpdatePlayerMovement();
        projectileController.updateProjectiles(projectileEnemy,projectileGround);
        playerController.UpdatePlayerState();
        ScreenUtils.clear(0, 0, 0, 0);
        views.render();
    }

    @Override
    public void dispose() {
        views.dispose();
    }

    @Override
    public void updateScreen() {
        System.out.println("here2");
        game.setScreen((Screen) new GameOverView(game));
    }
}
