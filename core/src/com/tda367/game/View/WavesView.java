package View;

import Interfaces.IView;
import Model.AttackFactory;
import Model.Enemy;
import Model.Waves;

import java.util.List;

public class WavesView implements IView {

    Waves wave;
    EnemyView enemyView;

    public WavesView(){
        this.wave = new Waves();
        this.enemyView = new EnemyView();
    }
    @Override
    public void render() {
        wave.getEnemiesToRender();
        enemyView.render();
    }

    @Override
    public void dispose() {
        enemyView.dispose();
    }
}
