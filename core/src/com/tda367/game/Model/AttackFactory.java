package Model;

import Interfaces.IEnemyAttack;

public class AttackFactory {

    /**
     * Creates a fire attack and adds it to the list of fireAttacks in Entity Holder.
     * @param x the x-position for the fire attack
     * @param y the y-position for the fire attack
     * @return the fire attack at a set position
     */
    public static IEnemyAttack createFireFlame(float x, float y){
        FireAttack fireAttack = new FireAttack(x,y);
        EntityHolder.getInstance().addFireAttack(fireAttack);
        return fireAttack;
    }
}
