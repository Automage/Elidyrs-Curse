package models.levels;

import models.tiles.Tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class Level {

    protected Tile[] tiles;
    protected int[] pixels;

    protected void loadTiles(String path) {

        loadPixels(path);
        //Determine tiles based on pixels


    }

    protected void loadPixels(String path) {
        try {
            BufferedImage image = ImageIO.read(Level.class.getResource(path));
            int w = image.getWidth();
            int h = image.getHeight();
            //Translates buffered image to pixel array
            image.getRGB(0,0, w, h, pixels, 0, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
