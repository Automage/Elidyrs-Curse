package models.entities;

import models.Map;
import models.Sprite;

public abstract class Entity {

    protected int x, y; //TOP-LEFT of sprite
    protected Sprite[] sprites; //Sprites for left, right, walking, running, attacking, etc.
    protected Sprite currentSprite;
    protected boolean isPassable; //Determines whether other Entities can pass through and whether it can pass other Entities
    protected Map map;

    public Entity(Map map, int x, int y) {
        this.map = map;
        this.x = x;
        this.y = y;
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

    public Sprite getSprite() {
        return currentSprite;
    }

    public abstract void update();


}
