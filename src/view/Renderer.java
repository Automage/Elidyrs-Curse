package view;

import models.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Renderer {

    private final int SCALE = 3;

    private Map map;
    private JFrame window;
    private Canvas canvas;
    private Graphics g;
    private BufferedImage image;
    private int[] pixels; //All screen pixels

    private int fps;
    private boolean running;

    public Renderer(Map map, KeyAdapter keyboard) {

        this.map = map;

        //image is the image that is the writable image that is added to canvas
        image = new BufferedImage(map.WIDTH, map.HEIGHT, BufferedImage.TYPE_INT_RGB);
        //Converts image to a writable pixel array
        pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

        canvas = new Canvas();
        canvas.setSize(SCALE * map.WIDTH, SCALE * map.HEIGHT);
        canvas.addKeyListener(keyboard);

        window = new JFrame("Elidyr's Curse");
        window.setResizable(false);

        //Window closes, but does not immediately terminate program
        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        /*
        Rather than terminating the program, closing the window sets the
        running status to false (which the game loop reads and terminates)
         */
        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                running = false;
            }
        });

        window.add(canvas);
        window.pack();

        window.setVisible(true);
        canvas.requestFocus();

        running = true;

    }

    public void setFPS(int fps) {
        this.fps = fps;
    }

    /**
     * Returns running status.
     *
     * @return Running status
     */
    public boolean getRunning() {
        return running;
    }

    /**
     * Function in charge of rendering everything on screen.
     * Screen is a BufferedImage image that is overwritten with sprites.
     * <ol>
     * <li>Renders the background, which is stored in map.tiles </li>
     * <li>Renders Player </li>
     * <li>Renders Mobs</li>
     * <li>Renders other Entities</li>
     * </ol>
     * Assumes all sprites are squares.
     */
    public void render() {

        //Create Triple Buffering
        BufferStrategy bs = canvas.getBufferStrategy();
        if (bs == null) {
            canvas.createBufferStrategy(3);
            return;
        }

        //RENDERING
        renderBackground();
        renderPlayer();
        renderMobs();
//        renderEntities();

        //Get graphics from bufferStrategy
        g = bs.getDrawGraphics();

        //Drawing to screen
        g.setColor(Color.black);
        g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight()); //Clear screen
        g.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null); //Stretches map to scaled screen

        //Update fps on title
        window.setTitle("Elidyr's Curse | " + fps + " fps");

        //Releases system resources for next call
        g.dispose();
        bs.show(); //Shows and releases current buffer image (?)

    }


    private void renderEntities() {
    }

    /**
     * Renders Mobs.
     *
     * Loads mob sprites in map.mobs[], and renders everything
     * but 0xFFFF00FF (pink).
     *
     * Assumes sprites are square.
     */
    private void renderMobs() {

        for (int i = 0; i < map.mobs.length; i++) {

            int mobSpriteSize = map.mobs[i].getSprite().SIZE;
            int mobSpritePixels[] = map.mobs[i].getSprite().pixels;

            for (int y = 0; y < mobSpriteSize; y++) {
                for (int x = 0; x < mobSpriteSize; x++) {

                    int currentPixel = mobSpritePixels[x + y * mobSpriteSize];

                    if (currentPixel != 0xFFFF00FF) { //PINK (0xFFFF00FF) should not be rendered
                        pixels[(x + map.mobs[i].getX()) + (y + map.mobs[i].getY()) * map.WIDTH] = currentPixel;
                    }

                }
            }

        }

    }

    /**
     * Renders player.
     *
     * Loads player sprite, and renders everything but 0xFFFF00FF (pink).
     *
     * Assumes sprites are square.
     */
    private void renderPlayer() {

        int playerSpriteSize = map.player.getSprite().SIZE;
        int playerSpritePixels[] = map.player.getSprite().pixels;

        for (int y = 0; y < playerSpriteSize; y++) {
            for (int x = 0; x < playerSpriteSize; x++) {

                int currentPixel = playerSpritePixels[x + y * playerSpriteSize];

                if (currentPixel != 0xFFFF00FF) { //PINK (0xFFFF00FF) should not be rendered
                    pixels[(x + map.player.getX()) + (y + map.player.getY()) * map.WIDTH] = currentPixel;
                }

            }
        }

    }

    /**
     * Renders background.
     *
     * Loads tiles from map.tiles.
     *
     * Assumes tiles are square.
     */
    private void renderBackground() {
        //Calls map's tile list, renders in order
        int tileSize;
        int x = 0, y = 0;
        //Iterate through each tile
        for (int t = 0; t < map.tiles.length; t++) {
            tileSize = map.tiles[t].tileSprite.SIZE;
            for (int j = 0; j < tileSize; j++) {
                for (int i = 0; i < tileSize; i++) {
                    pixels[(i + x) + (j + y) * map.WIDTH] = map.tiles[t].tileSprite.pixels[i + j * tileSize];
                }
            }
            if (x + tileSize >= map.WIDTH) {
                x = 0;
                y += tileSize;
            } else {
                x += tileSize;
            }

        }

    }

}
