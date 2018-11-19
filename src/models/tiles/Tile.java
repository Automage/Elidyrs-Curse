package models.tiles;

import models.Sprite;

public abstract class Tile {

    protected boolean isObstacle; //Whether or not entities can pass through
    //protected int numSprites; //Adds potential for animated tile sprites
    //protected Sprite[] tileSprites; //Adds potential for animated tile sprites
    //public int[][] pixels;
    public Sprite tileSprite;

    //All tiles

    public static Tile grass = new GrassTile();

//    public Tile(int size, boolean isObstacle, int numSprites, Sprite... sprites) {
//        this.SIZE = size;
//        this.isObstacle = isObstacle;
//        this.numSprites = numSprites;
//        this.tileSprites = sprites;
//        pixels = new int[numSprites][];
//        load();
//    }


    public Tile(boolean isObstacle, Sprite tileSprite) {
        this.isObstacle = isObstacle;
        this.tileSprite = tileSprite;
    }

    public boolean isObstacle() {
        return isObstacle;
    }

}
