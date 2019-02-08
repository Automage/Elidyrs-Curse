package models.entities.mobs;

import models.Sprite;

public class EnemyTest extends Mob {
    public EnemyTest(int x, int y) {
        super(x, y,
                Sprite.grass,
                Sprite.grass,
                Sprite.grass,
                Sprite.grass);
    }
}
