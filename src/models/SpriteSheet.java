package models;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpriteSheet {

    public final int SIZE;
    private String path;
    public int[] pixels;

    public static SpriteSheet generalSheet = new SpriteSheet("/textures/generalSheet.png", 256); //A general sheet for all tiles for now

    public SpriteSheet(String path, int size) {
        this.path = path;
        this.SIZE = size;
        pixels = new int[SIZE*SIZE];
        load();
    }

    private void load() {

        try {
            //BufferedImage image = ImageIO.read(new ImageReader(new File(path)));
            BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
            int w = image.getWidth();
            int h = image.getHeight();
            //Translates buffered image to pixel array
            image.getRGB(0,0, w, h, pixels, 0, w);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
