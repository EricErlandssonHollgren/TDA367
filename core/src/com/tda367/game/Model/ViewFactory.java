package Model;

import Interfaces.IEnemy;
import Interfaces.IView;
import View.EnemyView;

public class ViewFactory {
    public static IView createEnemyView(IEnemy e){
        return new EnemyView(e);
    }
}