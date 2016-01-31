
import java.awt.*;

/**
 * Created by SPARK on 2016-01-26.
 */
public class Paddle {

    private Breakout game;
    int height = 10;
    public static int width = 100;
    Point position = new Point(0,0);

    public Paddle (Breakout game) {
        this.game = game;
        position = new Point (0, game.height/2-height-20);
    }

    public Point bounceVector(Rectangle hitbox) {
        Point p = new Point(1,1);

        Rectangle hb_t = new Rectangle(position.x-width/2, position.y-height/2, width, height/3);
        Rectangle hb_l = new Rectangle(position.x-width/2, position.y-height/2+height/3, width/100, height-height/3);
        Rectangle hb_r = new Rectangle(position.x+width/2-width/100, position.y-height/2+height/3, width/100, height-height/3);


        if (hb_t.intersects(hitbox) || hb_l.intersects(hitbox) || hb_r.intersects(hitbox)) {
            p.y = -1;
            GameThread.score++;
            System.out.println("Current Score = " + GameThread.score);
            if (hb_l.intersects(hitbox) || hb_r.intersects(hitbox)) {
                if (p.y < 0) p.x = -1;
            }
        }


        return p;
    }

    public void render (Graphics g) {
        g.setColor(Color.lightGray);
        g.fillRect(position.x-width/2, position.y-height/2, width, height);

        Rectangle hb_t = new Rectangle(position.x-width/2, position.y-height/2, width, height/3);
        Rectangle hb_l = new Rectangle(position.x-width/2, position.y-height/2+height/3, width/100, height-height/3);
        Rectangle hb_r = new Rectangle(position.x+width/2-width/100, position.y-height/2+height/3, width/100, height-height/3);


        g.setColor(new Color(0, 0, 255, 100));
        g.fillRect(hb_t.x, hb_t.y, hb_t.width, hb_t.height);
        g.setColor(new Color(0, 255, 0, 100));
        g.fillRect(hb_l.x, hb_l.y, hb_l.width, hb_l.height);
        g.setColor(new Color(255, 0, 0, 100));
        g.fillRect(hb_r.x, hb_r.y, hb_r.width, hb_r.height);


    }
}
