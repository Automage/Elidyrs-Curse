package models;

import models.levels.Level;
import models.tiles.Tile;

public class Map {

    public final int WIDTH = 320;
    public final int HEIGHT = 320 / 4 * 3; // 240
    public Tile[] tiles = {Tile.grass, Tile.dungeonTile};
    public Level level;

}
