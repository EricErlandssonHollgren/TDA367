package Model;

import Interfaces.IEnemyAttack;

public class AttackFactory {

    public static IEnemyAttack createFireFlame(){
        return new FireAttack(630,100);
    }
}
