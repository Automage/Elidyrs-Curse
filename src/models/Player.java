package models;

import models.entities.mobs.Mob;

public class Player extends Mob {

    private final String name;

    //Future framework
    private double experience;
    private int level; //level 3, 50, etc.

    /**
     * Constructor
     *
     * @param name - player name
     * @param x in pixels
     * @param y in pixels
     */

    public Player(String name, int x, int y) {
        //ADD SPRITES HERE
        super(x, y,
                Sprite.knightFront,
                Sprite.knightBack,
                Sprite.knightRight,
                Sprite.knightLeft);

        this.name = name;
    }

    /**
     * Player mob is controlled by the user, therefore the AI method
     * in the Mob class is overriden to do nothing.
     */
    @Override
    protected void AIUpdate() {
        return;
    }

}