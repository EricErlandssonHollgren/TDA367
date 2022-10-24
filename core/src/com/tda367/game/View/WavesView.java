package View;

import Interfaces.IView;
import Model.Waves;

public class WavesView implements IView {

    private Waves wave;
    private EnemyView enemyView;
    private FireView fireview;

    /**
     * Constructor for waves view
     * @param wave reference to the wave object
     */
    public WavesView(Waves wave){
        this.enemyView = new EnemyView();
        this.fireview = new FireView();
        this.wave = wave;
    }
    @Override
        public void render() {
        wave.getEnemiesToRender();
        enemyView.render();
        fireview.render();
    }

    @Override
    public void dispose() {
        enemyView.dispose();
    }
}
