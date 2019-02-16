package models.entities.mobs;

import models.Sprite;
import models.entities.Entity;
import models.tiles.Tile;

public abstract class Mob extends Entity {

    //sprites[]:(0,1,2,3) should be reserved for (down, up, right, left)

    //dir = direction: (1,2,3,4) --> (down, up, right, left)
    protected int dir;
    protected int speed;

    public Mob(int x, int y, Sprite... sprites) {
        super(x, y, sprites);
        this.speed = 1;
        isPassable = false;
        dir = 1; //Faces forward (down)
        currentSprite = sprites[1]; //Forward sprite
    }

    /**
     * Moves mob by calculating the distance moved during one update,
     * given the mob's speed and change in x and y.
     *
     * @param xMod delta x
     * @param yMod delta y
     */
    public void move(int xMod, int yMod) {
        if (yMod > 0) dir = 1;
        if (yMod < 0) dir = 2;
        if (xMod > 0) dir = 3;
        if (xMod < 0) dir = 4;

        if (!collision(xMod, yMod)) {
            this.x += xMod;
            this.y += yMod;
        }
    }

    /**
     * Updates mob characteristics
     * <p>
     * Should be called every update. Any unique mob characteristics that
     * require updating should be done here by overriding this method
     * (and calling super.update() for regular directional sprite updates).
     * </p>
     */
    @Override
    public void update() {
        switch (dir) {
            case 1: //Down
                currentSprite = sprites[0];
                break;
            case 2: //Up
                currentSprite = sprites[1];
                break;
            case 3: //Right
                currentSprite = sprites[2];
                break;
            case 4: //Left
                currentSprite = sprites[3];
                break;
        }

        AIUpdate();

    }

    /**
     * Detects collision by checking if the front 2 vertices of the sprite
     * in the movement direction will hit an obstacle after adding xMod and
     * yMod respectively.
     * <p>
     * Checks collision with obstacle tiles and other mobs.
     *
     * @param xMod Change in x direction
     * @param yMod Change in y direction
     * @return Whether or not player will collide with an obstacle
     */
    @Override
    protected boolean collision(int xMod, int yMod) {
        /*
         * 0---1
         * |   |
         * 3---2
         */

        //Array of each corner pixel coordinates (which is an array of {x,y})
        int[][] spriteVertices = {
                {this.x, this.y},
                {this.x + currentSprite.SIZE, this.y},
                {this.x + currentSprite.SIZE, this.y + currentSprite.SIZE},
                {this.x, this.y + currentSprite.SIZE}
        };

        int[][] selectVertices = null; // 2 corners of sprite facing forward

        switch (dir) {
            case 1:
                selectVertices = new int[][]{spriteVertices[2], spriteVertices[3]};
                break;
            case 2:
                selectVertices = new int[][]{spriteVertices[0], spriteVertices[1]};
                break;
            case 3:
                selectVertices = new int[][]{spriteVertices[1], spriteVertices[2]};
                break;
            case 4:
                selectVertices = new int[][]{spriteVertices[0], spriteVertices[3]};
                break;
        }

        Tile tempTile;

        for (int[] vertex : selectVertices) {

            // Obstacle tile collision
            tempTile = map.getTile((vertex[0] + xMod) / Tile.TILE_SIZE,
                                    (vertex[1] + yMod) / Tile.TILE_SIZE);

            if (tempTile.isObstacle()) {
                return true;
            }

            // Mob collision
            for (Mob mob : map.mobs) {

                int mobX = mob.getX();
                int mobY = mob.getY();

                // Checks whether updated sprite will be within
                // another mob's sprite
                if (((vertex[0] + xMod) >= mobX) &&
                    ((vertex[0] + xMod) <= mobX + mob.currentSprite.SIZE) &&
                    ((vertex[1] + yMod) >= mobY) &&
                    ((vertex[1] + yMod) <= mobY + mob.currentSprite.SIZE)) {

                    return true;

                }

            }

            //Player Collision
            int playerX = map.player.getX();
            int playerY = map.player.getY();
            int playerSpriteSize = map.player.currentSprite.SIZE;
            if (((vertex[0] + xMod) >= playerX) &&
                    ((vertex[0] + xMod) <= playerX + playerSpriteSize) &&
                    ((vertex[1] + yMod) >= playerY) &&
                    ((vertex[1] + yMod) <= playerY + playerSpriteSize)) {

                return true;

            }

        }

        return false;

    }

    /**
     * Function implements the intelligence for the generic Mob.
     * Method should be overridden for special/enemy-type specific
     * behaviour.
     */
    protected void AIUpdate() {

        move(1, 0);

    }

    /**
     * Returns player's speed
     *
     * @return player speed
     */
    public int getSpeed() {
        return speed;
    }
}