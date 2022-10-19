package Model;

import Interfaces.IEnemyAttack;

public class AttackFactory {

    public static IEnemyAttack createFireFlame(){
        FireAttack fireAttack = new FireAttack();
        EntityHolder.getInstance().addFireAttack(fireAttack);
        return fireAttack;
    }
}
