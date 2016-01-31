
/**
 * Created by SPARK on 2016-01-26.
 */
public class GameThread extends Thread {

    private Breakout game;
    public GameThread(Breakout game) {
        this.game = game;
    }
    public static int score = 0;

    public void run() { // make sure game gets updated.
        // Initiate
        System.out.println("Initiated.");

        game.isRunning = true;
        game.isPaused = false;
        game.lastUpdate = System.nanoTime();

        // Game Loop
        while (game.isRunning) {
            try {
                //System.out.println("loop");
                if (game.isPaused) {
                    game.lastUpdate = System.nanoTime();
                    Thread.sleep(1);
                } else {
                    game.tick();
                    game.lastUpdate = System.nanoTime();
                    Thread.sleep( (long) (1000/game.FPS));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Exit
        System.out.println("Exited the Game Loop");
    }

}
