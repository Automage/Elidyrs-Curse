package engine;

import view.Renderer;
import models.Map;

public class GameEngine {

    private Renderer renderer;
    private Map map;

    public GameEngine() {
        map = new Map();
        renderer = new Renderer(map);

    }

    public void update() {

    }

    public void render() {
        renderer.render();
    }

}
