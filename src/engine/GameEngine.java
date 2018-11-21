package engine;

import engine.input.Keyboard;
import models.levels.LevelNotFoundException;
import view.Renderer;
import models.Map;

public class GameEngine {

    private Renderer renderer;
    private Keyboard keyboard;
    private Map map;

    public GameEngine() {

        try {
            map = new Map(0);
        } catch (LevelNotFoundException e) {
            e.printStackTrace();
        }

        keyboard = new Keyboard();
        renderer = new Renderer(map, keyboard);

    }

    public void update() {
        if (keyboard.keyIsDown[0]) {System.out.println("UP");}
        if (keyboard.keyIsDown[1]) {System.out.println("DOWN");}
        if (keyboard.keyIsDown[2]) {System.out.println("LEFT");}
        if (keyboard.keyIsDown[3]) {System.out.println("RIGHT");}
    }

    public void render() {
        renderer.render();
    }

    public void pushFPS(int fps) {
        renderer.setFPS(fps);
    }

}
