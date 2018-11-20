package models.tiles;

import models.Sprite;

public abstract class Tile {

    protected boolean isObstacle; //Whether or not entities can pass through
    //protected int numSprites; //Adds potential for animated tile sprites
    //protected Sprite[] tileSprites; //Adds potential for animated tile sprites
    //public int[][] pixels;
    public Sprite tileSprite;
    public String name;

    //All tiles

    public static Tile grass = new GrassTile();
    public static Tile dungeonTile = new DungeonTile();

//    public Tile(int size, boolean isObstacle, int numSprites, Sprite... sprites) {
//        this.SIZE = size;
//        this.isObstacle = isObstacle;
//        this.numSprites = numSprites;
//        this.tileSprites = sprites;
//        pixels = new int[numSprites][];
//        load();
//    }


    public Tile(String name, boolean isObstacle, Sprite tileSprite) {
        this.name = name;
        this.isObstacle = isObstacle;
        this.tileSprite = tileSprite;
    }

    public boolean isObstacle() {
        return isObstacle;
    }

    /*
    0xa,r,g,b
    ----------
    0xFF000000 - (0,0,0) - grass
    0xFF0000FF - (0,0,255) - dungeonTile
     */
    public static Tile colorToTile(int color) {
        switch (color) {
            case 0xFF0000FF:
                return Tile.dungeonTile;
            case 0xFF000000:
                return Tile.grass;
        }

        return null;
    }

}
