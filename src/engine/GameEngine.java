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
        if (keyboard.keyIsDown[0]) {
            System.out.println("UP");
            player.move(0, player.getSpeed());
        }
        if (keyboard.keyIsDown[1]) {
            System.out.println("DOWN");
            player.move(0, -player.getSpeed());
        }
        if (keyboard.keyIsDown[2]) {
            System.out.println("LEFT");
            player.move(player.getSpeed(), 0);
        }
        if (keyboard.keyIsDown[3]) {
            System.out.println("RIGHT");
            player.move(-player.getSpeed(), 0);
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
