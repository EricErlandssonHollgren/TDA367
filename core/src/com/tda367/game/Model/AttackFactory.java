package Model;

import Interfaces.IEnemyAttack;

public class AttackFactory {

    public static IEnemyAttack createFireFlame(float x, float y){
        FireAttack fire = new FireAttack(x,y);
        return fire;
    }
}
