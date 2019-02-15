package models.levels;

import models.entities.mobs.EnemyTest;
import models.entities.mobs.Mob;

public class Level0 extends Level{

    public Level0() {
        super("/levels/level0.png", 20, 15, 0); //equates to 320x240 resolution (16px tiles)
        //Initialize mobs ...
        this.mobs = new Mob[] {
                new EnemyTest(20,20),
                new EnemyTest(20,100)
        };
    }

}
