package models.entities.mobs;

import models.Sprite;
import models.entities.Entity;

public abstract class Mob extends Entity {

    //sprites[]:(0,1,2,3) should be reserved for (forward, back, right, left)

    protected int dir; //dir = direction: (1,2,3,4) --> (forward, back, right, left)
    protected int speed;

    public Mob(int x, int y, int speed, Sprite... sprites) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.sprites = sprites;
        isPassable = false;
        dir = 1; //Faces forward
        currentSprite = sprites[1]; //Forward sprite
    }

    /**
     * Moves mob by calculating the distance moved during one update, given the mob's speed and change in x and y.
     *
     * @param xMod delta x
     * @param yMod delta y
     */
    public void move(int xMod, int yMod) {
        if (yMod > 0) dir = 2;
        if (yMod < 0) dir = 1;
        if (xMod > 0) dir = 3;
        if (xMod < 0) dir = 4;
        this.x += xMod;
        this.y += yMod;
    }


    /**
     * Updates mob characteristics
     * <p>
     * Should be called every update. Any unique mob characteristics that require updating should be done here by
     * overriding this method (and calling super.update() for regular directional sprite updates).
     * </p>
     */
    @Override
    public void update() {

        switch (dir) {
            case 1:
                currentSprite = sprites[0];
                break;
            case 2:
                currentSprite = sprites[1];
                break;
            case 3:
                currentSprite = sprites[2];
                break;
            case 4:
                currentSprite = sprites[3];
                break;
        }

    }

    public int getSpeed() {
        return speed;
    }
}
