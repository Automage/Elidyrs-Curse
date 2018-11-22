package models.levels;

import models.entities.mobs.Mob;
import models.tiles.Tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Level {

    protected int[] pixels;
    public final int levelID;

    //In-game
    public Tile[] tiles;
    public Mob[] mobs;

    //All Levels
    public static Level level0 = new Level0();


    public Level(String path, int widthTiles, int heightTiles, int id) { //width and height of level in tiles
        levelID = id;
        tiles = new Tile[widthTiles * heightTiles];
        pixels = new int[widthTiles * heightTiles];
        loadTiles(path);
    }

    protected void loadTiles(String path) {

        loadPixels(path);

        for (int i = 0; i < pixels.length; i++) {
            tiles[i] = Tile.colorToTile(pixels[i]);
        }

    }

    protected void loadPixels(String path) {
        try {
            BufferedImage image = ImageIO.read(Level.class.getResource(path));
            int w = image.getWidth();
            int h = image.getHeight();
            //Translates buffered image to pixel array
            image.getRGB(0, 0, w, h, pixels, 0, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
