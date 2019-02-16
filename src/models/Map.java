package models;

import models.entities.mobs.Mob;
import models.levels.Level;
import models.levels.LevelNotFoundException;
import models.tiles.Tile;

public class Map {

    public final int WIDTH = 320;
    public final int HEIGHT = 320 / 4 * 3; // 240

    public Tile[] tiles;
    public Level level;

    public Player player;
    public Mob[] mobs;

    /**
     * Constructor:
     * - Assigns level to map using levelID
     * - Loads level (loadLevel())
     * - Creates a player and passes it the map reference
     *
     * @param levelID - ID corresponding to a level
     * @throws LevelNotFoundException
     */
    public Map(int levelID) throws LevelNotFoundException {

        //Add levelID's here
        switch (levelID) {
            case 0:
                level = Level.level0;
                break;
            default:
                throw new LevelNotFoundException();
        }

        player = new Player("Player 1", 160, 120);
        player.mapInit(this);

        loadLevel();

    }

    /**
     * Returns the tile corresponding to the x, y tile coordinate
     * (i.e. not pixel coordinates)
     *
     * @param x coordinate
     * @param y coordinate
     * @return Tile at (x,y)
     */
    public Tile getTile(int x, int y) {

        return tiles[x + y * (WIDTH / Tile.TILE_SIZE)];
        //return null;

    }

    /**
     * Loads tiles and mobs from assigned level.
     * Passes map reference to all mobs.
     */
    private void loadLevel() {
        this.tiles = level.tiles;
        this.mobs = level.mobs;

        for (int i = 0; i < mobs.length; i++) {
            mobs[i].mapInit(this);
        }

    }

}
