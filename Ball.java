
/**
 * Created by SPARK on 2016-01-26.
 */

import java.awt.*;

public class Ball {

    private Breakout game;
    public static int radius = 10;
    Point position = new Point(0,100);
    Point movement = new Point(1,1); // < x , y >
    public static int input_speed = 50;
    float speed = 0.3f * input_speed/100 * 2;


    public Ball (Breakout game) {
        this.game = game;
    }



    public void tick(double deltatime) {
        position.translate((int) (movement.x*(speed*deltatime)), (int) (movement.y*(speed*deltatime)));

        // Basic Collision Calculation Setup
        if (Math.abs(position.x) >= Math.abs(game.width/2)) {
            movement.x = -movement.x;
            GameThread.score++;
        }
        if (position.y <= -game.height/2) {
            movement.y = -movement.y;
            GameThread.score++;
        }
        if (position.y >= game.height/2) game.OnBallLost();

        Rectangle hitbox = new Rectangle(position.x-radius, position.y-radius, radius*2, radius*2);
        Point pv = game.player.bounceVector(hitbox);
        movement.x *= pv.x;
        movement.y *= pv.y;

        for (int i=0; i < game.bricks.size(); i++) {
            Brick b = game.bricks.get(i);
            pv = b.bounceVector(hitbox);
            movement.x *= pv.x;
            movement.y *= pv.y;

            if (pv.x < 0 || pv.y < 0) {
                game.bricks.remove(b);
            }
        }
    }


    public void render (Graphics g) {
        g.setColor(Color.WHITE.darker());
        g.fillOval(position.x-radius, position.y-radius, radius*2, radius*2);
        g.setColor(Color.GRAY);
        g.fillOval(position.x-radius+radius*2*1/4/2, position.y-radius+radius*2*1/4/2, radius*2*3/4, radius*2*3/4);
        g.setColor(Color.DARK_GRAY);
        g.fillOval(position.x-radius+radius*2*2/4/2, position.y-radius+radius*2*2/4/2, radius*2*2/4, radius*2*2/4);
        g.setColor(Color.DARK_GRAY.darker());
        g.fillOval(position.x-radius+radius*2*3/4/2, position.y-radius+radius*2*3/4/2, radius*2*1/4, radius*2*1/4);

    }
}
