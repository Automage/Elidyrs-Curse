package models;

public class Sprite {

    private SpriteSheet spriteSheet;
    private final int SIZE; //Allows for larger-than-tile sprites
    private int x, y; // x, y coordinates of sprite on sprite sheet
    public int[] pixels;

    //All Sprites
    public static Sprite grass = new Sprite(SpriteSheet.generalSheet, 16, 0, 0);

    public Sprite(SpriteSheet spriteSheet, int SIZE, int col, int row) {
        this.spriteSheet = spriteSheet;
        this.SIZE = SIZE;
        this.x = col * SIZE; //x coordinate of top-left corner of sprite
        this.y = row * SIZE; //y coordinate of top-left corner of sprite
        pixels = new int[SIZE * SIZE];
    }

    public void load() {

        //i = x iterator, j = y iterator
        for (int j = 0; j < SIZE; y++) {
            for (int i = 0; i < SIZE; x++) {
                pixels[i + j * SIZE] = spriteSheet.pixels[(i + x) + (j + y) * spriteSheet.SIZE];
            }
        }

    }
}
