package Model;

import Interfaces.IEnemyAttack;

public class AttackFactory {

    public static IEnemyAttack createFireFlame(float x, float y){
        FireAttack fireAttack = new FireAttack(x,y);
        EntityHolder.getInstance().addFireAttack(fireAttack);
        return fireAttack;
    }
}
