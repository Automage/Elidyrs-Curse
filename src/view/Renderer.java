package view;

import models.Map;

import javax.swing.*;
import java.awt.*;
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
    private int[] pixels;

    public Renderer(Map map) {

        this.map = map;

        image = new BufferedImage(map.WIDTH, map.HEIGHT, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();

        canvas = new Canvas();
        canvas.setSize(SCALE * map.WIDTH, SCALE * map.HEIGHT);

        window = new JFrame("Elidyr's Curse");
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.add(canvas);
        window.pack();

        window.setVisible(true);

    }

    public void render() {

        //Create Triple Buffering
        BufferStrategy bs = canvas.getBufferStrategy();
        if (bs == null) {
            canvas.createBufferStrategy(3);
            return;
        }

        //RENDERING
//        renderBackground();
//        renderPlayer();
//        renderEntities();

        //Get graphics from bufferStrategy
        g = bs.getDrawGraphics();

        //Drawing to screen
        g.setColor(Color.black);
        g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight()); //Clear screen
        g.drawImage(image, 0,0,canvas.getWidth(),canvas.getHeight(), null); //Stretches map to scaled screen

        //Releases system resources for next call
        g.dispose();
        bs.show(); //Shows and releases current buffer image (?)

    }


    private void renderEntities() {
    }

    private void renderPlayer() {
    }

    private void renderBackground() {
    }

}
