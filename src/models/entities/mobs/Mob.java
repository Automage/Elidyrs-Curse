package models.entities.mobs;

import models.Sprite;
import models.entities.Entity;

public abstract class Mob extends Entity {

    protected int dir; //dir = direction: (0,1,2,3) --> (+y,+x,-y,-x)
    protected double speed;

    public Mob(int x, int y, double speed, Sprite... sprites) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.sprites = sprites;
        isPassable = false;
        dir = 2; //Faces to -y
    }

}
