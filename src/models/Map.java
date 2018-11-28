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

    public Map(int levelID) throws LevelNotFoundException {

        //Add levelID's here
        switch (levelID) {
            case 0:
                level = Level.level0;
                break;
            default:
                throw new LevelNotFoundException();
        }

        player = new Player("Player 1", this,160, 120, Sprite.knightFront, Sprite.knightBack, Sprite.knightRight, Sprite.knightLeft);

        loadLevel();

    }

    public Tile getTile(int x, int y) {

        //return tiles[x + y * WIDTH];
        return null;

    }

    private void loadLevel() {
        this.tiles = level.tiles;
        this.mobs = level.mobs;
    }

}
