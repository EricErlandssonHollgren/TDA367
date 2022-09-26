package Interfaces;

import Model.Turret.Turret;

/**
 * A class with this interface should be able to build turrets
 */
public interface IBuild<T extends Turret>{
        /**
         * buildTurret should build the turret
         * @param Turret The turret that gets built
         */
        void buildTurret(T Turret);

        /**
         * sellTurret should sell a Turret that has been built
         */
        void sellTurret(T Turret);
    }
