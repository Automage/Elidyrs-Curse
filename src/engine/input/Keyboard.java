package engine.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keyboard extends KeyAdapter{

    public boolean[] keyIsDown = new boolean[4]; //UP, DOWN, LEFT, RIGHT

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                keyIsDown[0] = true;
                break;
            case KeyEvent.VK_DOWN:
                keyIsDown[1] = true;
                break;
            case KeyEvent.VK_LEFT:
                keyIsDown[2] = true;
                break;
            case KeyEvent.VK_RIGHT:
                keyIsDown[3] = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                keyIsDown[0] = false;
                break;
            case KeyEvent.VK_DOWN:
                keyIsDown[1] = false;
                break;
            case KeyEvent.VK_LEFT:
                keyIsDown[2] = false;
                break;
            case KeyEvent.VK_RIGHT:
                keyIsDown[3] = false;
                break;
        }
    }
}
