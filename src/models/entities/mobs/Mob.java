package models.entities.mobs;

import models.Sprite;
import models.entities.Entity;
import models.tiles.Tile;

public abstract class Mob extends Entity {

    //sprites[]:(0,1,2,3) should be reserved for (down, up, right, left)

    protected int dir; //dir = direction: (1,2,3,4) --> (down, up, right, left)
    protected int speed;

    public Mob(int x, int y, Sprite... sprites) {
        super(x, y, sprites);
        this.speed = 1;
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
        if (yMod > 0) dir = 1;
        if (yMod < 0) dir = 2;
        if (xMod > 0) dir = 3;
        if (xMod < 0) dir = 4;

        if (!collision(xMod, yMod)) {
            this.x += xMod;
            this.y += yMod;
        }
    }

    protected boolean collision(int xMod, int yMod) {

        Tile tempTile;

        if (dir == 1) { //Forward movement
            tempTile = map.getTile((this.x + xMod) / Tile.TILE_SIZE,
                    ((this.y + yMod) / Tile.TILE_SIZE) + 1);
        } else if (dir == 3) { //Right movement
            tempTile = map.getTile(((this.x + xMod) / Tile.TILE_SIZE) + 1,
                    (this.y + yMod) / Tile.TILE_SIZE);
        } else { // Left and Back movement
            tempTile = map.getTile((this.x + xMod) / Tile.TILE_SIZE,
                    (this.y + yMod) / Tile.TILE_SIZE);
        }

        System.out.println("Dir: " + dir);

        if (tempTile.isObstacle()) {
            return true;
        }

        return false;

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

    }

    public int getSpeed() {
        return speed;
    }
}
