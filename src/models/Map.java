package models;

import models.levels.Level;
import models.tiles.Tile;

public class Map {

    public final int WIDTH = 300;
    public final int HEIGHT = 300 / 4 * 3; // 225
    public Tile[] tiles = {Tile.dungeonTile, Tile.dungeonTile};
    public Level level;


}
