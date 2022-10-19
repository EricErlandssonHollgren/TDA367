package View;

import Interfaces.IView;
import Model.AttackFactory;
import Model.Enemy;
import Model.Entity;
import Model.Waves;

import java.util.List;

public class WavesView implements IView {

    Waves wave;
    EnemyView enemyView;
    FireView fireview;

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
