package Model;


import Interfaces.IObject;

public class AttackFactory {

    public static IObject createFireFlame(float x, float y){
        return new FireAttack(x,y);
    }
}
