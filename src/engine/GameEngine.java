package engine;

import engine.input.Keyboard;
import models.Player;
import models.levels.LevelNotFoundException;
import view.Renderer;
import models.Map;

public class GameEngine {

    private Renderer renderer;
    private Keyboard keyboard;
    private Map map;
    private Player player;

    public GameEngine() {

        try {
            map = new Map(0);
        } catch (LevelNotFoundException e) {
            e.printStackTrace();
        }

        player = map.player;
        keyboard = new Keyboard();
        renderer = new Renderer(map, keyboard);

    }

    public void update() {
        //Player updates
        //Coordinate system starts at top-left - so y-axis is inverted
        //UP
        if (keyboard.keyIsDown[0]) {
            player.move(0, -player.getSpeed());
        }
        //DOWN
        if (keyboard.keyIsDown[1]) {
            player.move(0, player.getSpeed());
        }
        //LEFT
        if (keyboard.keyIsDown[2]) {
            player.move(-player.getSpeed(), 0);
        }
        //RIGHT
        if (keyboard.keyIsDown[3]) {
            player.move(player.getSpeed(), 0);
        }
        player.update();
        System.out.println("x: " + player.getX() + " y: " + player.getY());
    }

    public void render() {
        renderer.render();
    }

    public void pushFPS(int fps) {
        renderer.setFPS(fps);
    }

}
