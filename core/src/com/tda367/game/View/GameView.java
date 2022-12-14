package View;

import Controller.*;
import Interfaces.*;
import Model.*;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.List;
import java.util.Map;


public class GameView extends ScreenAdapter implements IGameOverSubscriber {
    private GameTimer timer;
    private ViewHolder views;
    private Player player;
    private MainHandler goldHandler;
    private MainHandler pointsHandler;
    private Tower tower;
    private Waves wave;
    private WorldBoundaries worldBoundaries;
    private CollisionDetection collisionDetection;
    private EntityHolder entityHolder;
    private TowerController towerController;
    private PlayerController playerController;
    private PausController pausController;
    private PlayerSpawnController playerSpawnController;
    private ProjectileHandler projectileHandler;
    private MessageSender messageSender;
    private GameOverInstantiator gameOverInstantiator;


    /**
     * Creates the game when first constructed.
     */
    public GameView() {
        createWorld();
    }


    private void createWorld( ){
        //Objects
        player = new Player(120,100, 50, 37, 125);
        worldBoundaries = new WorldBoundaries();
        timer = GameTimer.GetInstance();
        wave = new Waves();
        messageSender = MessageSender.GetInstance();
        gameOverInstantiator = GameOverInstantiator.GetInstance();

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
        playerController.addObserver(player);
        playerSpawnController = new PlayerSpawnController();
        towerController = new TowerController();
        towerController.addSubscribers(tower);
        projectileHandler = new ProjectileHandler(entityHolder);
        playerSpawnController = new PlayerSpawnController();
        playerSpawnController.addSubscribers((IReSpawnable) player);
        pausController = new PausController();


        //Create views and objects
        IView worldBoundariesView = new WorldBoundariesView(worldBoundaries);
        IView wavesView = new WavesView(wave);
        IView playerView = new PlayerView(player);
        IView towerView = new TowerView(tower);
        IView healthBarView = new HealthBarView(player.healthBar);
        IView statsView = new StatsView();
        IView background = new BackgroundView();
        IView projectileView = new ProjectileView(projectileHandler);
        IView messageView = new MessageView();
        IView pausView = new PausView();
        IView buttonView = new ButtonView(towerController, tower, playerSpawnController);

        messageSender.addSubscribers((IMessageSubscriber) messageView);
        gameOverInstantiator.addSubscribers(this);
        pausController.addSubscribers((IPaus) pausView);
        pausController.addSubscribers((IPaus) player);
        pausController.addSubscribers((IPaus) timer);
        pausController.addSubscribers((IPaus) wave);
        pausController.addSubscribers((IPaus) buttonView);

        //Add views to list and they will be rendered. Views must implement IView
        views = new ViewHolder();
        views.addView(background);
        views.addView(worldBoundariesView);
        views.addView(statsView);
        views.addView(playerView);
        views.addView(towerView);
        views.addView(wavesView);
        views.addView(statsView);
        views.addView(healthBarView);
        views.addView(projectileView);
        views.addView(messageView);
        views.addView(buttonView);
        views.addView(pausView);


    }

    /**
     * Renders the world and updates components.
     * @param delta
     */
    @Override
    public void render(float delta) {
        timer.UpdateTime(Gdx.graphics.getDeltaTime());

        collisionDetection.CheckCollisionPlayerAndEnemy(player);
        collisionDetection.CheckCollisionPlayerNextStep(player);
        collisionDetection.CheckCollisionEnemyAndHitBox(player);
        collisionDetection.CheckCollisionTowerAndEnemy(tower);
        collisionDetection.CheckCollisionTowerAndFireAttack(tower);
        collisionDetection.checkCollisionPlayerAndFireAttack(player);

        List<IProjectile> projectileGround = collisionDetection.checkCollisionProjectileGround();
        Map<Entity,IProjectile> projectileEnemy = collisionDetection.checkCollisionProjectileAndEnemy();
        playerController.UpdatePlayerMovement();
        pausController.updatePausMenu();
        projectileHandler.updateProjectiles(projectileEnemy,projectileGround);
        tower.fireTurrets();
        ScreenUtils.clear(0, 0, 0, 0);

        for (Entity entity : entityHolder.getEntities()) {
            pausController.addSubscribers((IPaus) entity);
        }
        for (IProjectile projectile : entityHolder.getProjectiles()) {
            pausController.addSubscribers((IPaus) projectile);
        }
        views.render();
    }


    @Override
    public void dispose() {
        views.dispose();
    }

    @Override
    public void updateScreen() {
        updateWorld();
        ((Game)Gdx.app.getApplicationListener()).setScreen((Screen) new GameOverView());
    }

    private void updateWorld() {
        wave = new Waves();
        EntityHolder.getInstance().clearAll();
        views.removeAllViews();
    }

}
