package models.entities;

import models.Map;
import models.Sprite;

public abstract class Entity {

    protected int x, y; //TOP-LEFT of sprite

    // Sprites for left, right, walking, running, attacking, etc.
    // sprites[]:(0,1,2,3) should be reserved for (down, up, right, left)
    protected Sprite[] sprites;
    protected Sprite currentSprite;

    // Determines whether other Entities can pass through and whether it can
    // pass other Entities. Obstacle tiles too.
    protected boolean isPassable;
    protected Map map;

    /**
     * Constructor - Initializes x, y coordinates and assigns sprites.
     *
     * @param x - x pixel coordinates
     * @param y - y pixel coordinates
     * @param sprites - all entity sprites
     */
    public Entity(int x, int y, Sprite... sprites) {
        this.x = x;
        this.y = y;
        this.sprites = sprites;
    }

    /**
     * Assigns map reference to Entity
     *
     * @param map - map reference
     */
    public void mapInit(Map map) {
        this.map = map;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * Returns the current displayed sprite of the entity
     *
     * @return current sprite of entity
     */
    public Sprite getSprite() {
        return currentSprite;
    }

    /**
     * Updates mob values and applies logic, called every update cycle.
     *
     * Should be overridden.
     */
    public abstract void update();

    /**
     * Applies collision logic, should be called every update cycle.
     *
     * @param xMod - Change in x pixel coordinate
     * @param yMod - Change in y pixel coordinate
     * @return Whether or not entity has collided with an obstacle.
     */
    protected abstract boolean collision(int xMod, int yMod);


}
