package engine;

import models.levels.LevelNotFoundException;
import view.Renderer;
import models.Map;

public class GameEngine {

    private Renderer renderer;
    private Map map;

    public GameEngine() {

        try {
            map = new Map(0);
        } catch (LevelNotFoundException e) {
            e.printStackTrace();
        }

        renderer = new Renderer(map);

    }

    public void update() {

    }

    public void render() {
        renderer.render();
    }

}
