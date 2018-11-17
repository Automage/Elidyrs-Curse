import engine.GameEngine;

public class Game implements Runnable{

    private GameEngine engine = new GameEngine();
    private boolean running = true;

    public static void main(String[] args) {
        Game game = new Game();
        Thread gameThread = new Thread(game);
        gameThread.start();
    }

    @Override
    public void run() {

        long lastTime = System.nanoTime();
        long now = 0;
        final double nsPerFrame = 1_000_000_000.0 / 60.0; // #nanoseconds per ideal fps (60) (basically used to calculate delta)
        double delta = 0; //Number of updates needed calculated from time taken since last render
        int frames = 0;
        int updates = 0;
        long timer = System.currentTimeMillis(); //for fps/ups counter

        while (running) {

            now = System.nanoTime();
            delta += (now - lastTime) / nsPerFrame;
            lastTime = now;

            //Calls update enough times so game is not behind rendering
            while (delta >= 1) {
                engine.update();
                updates++;
                delta--; //One update done
            }

            engine.render();
            frames++;

            //FPS + UPS counter
            //Executes every second
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("UPS: " + updates + ", FPS: " + frames);
                updates = frames = 0;
            }

        }

    }
}
