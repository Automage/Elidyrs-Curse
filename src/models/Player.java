package models;

import models.entities.mobs.Mob;

public class Player extends Mob {

    private final String name;

    //Future framework
    private double experience;
    private int level; //level 3, 50, etc.

    public Player(String name, Map map, int x, int y, Sprite... sprites) {
        super(map, x, y, 1,sprites);
        this.name = name;
    }

}
