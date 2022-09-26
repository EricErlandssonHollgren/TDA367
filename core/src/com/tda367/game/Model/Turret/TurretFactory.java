package Model.Turret;

import Model.Turret.Turrets.advTurret;
import Model.Turret.Turrets.basicTurret;

public class TurretFactory {
    public static Turret createBasicTurret(){
        return new basicTurret(10,50);
    }
    public static Turret createAdvTurret(){
        return new advTurret(50,80);
    }
}
