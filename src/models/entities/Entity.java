package models.entities;

import models.Sprite;

public abstract class Entity {

    protected int x, y;
    protected Sprite[] sprites; //Sprites for left, right, walking, running, attacking, etc.
    protected boolean isPassable; //Determines whether other Entities can pass through and whether it can pass other Entities

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
