package models;

public class Sprite {

    private SpriteSheet spriteSheet;
    public final int SIZE; //16x16 --> SIZE: 16
    private int x, y; // x, y coordinates of sprite on sprite sheet
    public int[] pixels;

    //All Sprites
    public static Sprite grass = new Sprite(SpriteSheet.generalSheet, 16, 0, 0);
    public static Sprite dungeonTile = new Sprite(SpriteSheet.generalSheet, 16, 1,0);
    public static Sprite dungeonWallTile = new Sprite(SpriteSheet.generalSheet, 16, 2,0);

    public static Sprite knightFront = new Sprite(SpriteSheet.generalSheet, 16, 0, 15);
    public static Sprite knightLeft = new Sprite(SpriteSheet.generalSheet, 16, 1, 15);
    public static Sprite knightBack = new Sprite(SpriteSheet.generalSheet, 16, 2, 15);
    public static Sprite knightRight = new Sprite(SpriteSheet.generalSheet, 16, 3, 15);


    public Sprite(SpriteSheet spriteSheet, int SIZE, int col, int row) {
        this.spriteSheet = spriteSheet;
        this.SIZE = SIZE;
        this.x = col * SIZE; //x coordinate of top-left corner of sprite
        this.y = row * SIZE; //y coordinate of top-left corner of sprite
        pixels = new int[SIZE * SIZE];
        load();
    }

    public void load() {

        //i = x iterator, j = y iterator
        for (int j = 0; j < SIZE; j++) {
            for (int i = 0; i < SIZE; i++) {
                pixels[i + j * SIZE] = spriteSheet.pixels[(i + x) + (j + y) * spriteSheet.SIZE];
            }
        }

    }
}
