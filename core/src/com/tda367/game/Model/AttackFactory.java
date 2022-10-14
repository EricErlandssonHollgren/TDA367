package Model;

import Interfaces.IProjectile;

public class AttackFactory {

    public static IProjectile createFireFlame(){
        return new FireAttack(630,100);
    }
}
