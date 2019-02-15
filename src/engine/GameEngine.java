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
        playerUpdate();

        //Mob updates

    }

    /**
     * Controls player controls, such as movement.
     *
     * Movement: Checks map bounds before movement
     */
    private void playerUpdate() {

        /*
        - Coordinate system starts at top-left - so y-axis is inverted
        - Map boundary logic is the second statement of the if-condition
        */
        //UP
        if (keyboard.keyIsDown[0] && (player.getY() > 0)) {
            player.move(0, -player.getSpeed());
        }
        //DOWN
        if (keyboard.keyIsDown[1] && (player.getY() + player.getSprite().SIZE < map.HEIGHT)) {
            player.move(0, player.getSpeed());
        }
        //LEFT
        if (keyboard.keyIsDown[2] && (player.getX() > 0)) {
            player.move(-player.getSpeed(), 0);
        }
        //RIGHT
        if (keyboard.keyIsDown[3] && (player.getX() + player.getSprite().SIZE < map.WIDTH)) {
            player.move(player.getSpeed(), 0);
        }
        player.update();

    }

    public void render() {
        renderer.render();
    }

    public void pushFPS(int fps) {
        renderer.setFPS(fps);
    }

}
