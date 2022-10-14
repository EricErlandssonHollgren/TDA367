package View;

import Interfaces.IView;
import Model.Enemy.Enemies.Enemy1;
import Model.Enemy.Enemy;
import Model.Enemy.EnemyFactory;
import Model.FireAttack;
import Model.Waves;

public class AttackView implements IView {

    Waves wave = new Waves();
    FireView fireView = new FireView();

    @Override
    public void render() {
        for (Enemy enemy: wave.getEnemiesToRender()) {
                fireView.render();
        }
    }

    @Override
    public void dispose() {
        fireView.dispose();
    }
}
