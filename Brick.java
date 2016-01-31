import javax.swing.*;

/**
 * Created by SPARK on 2016-01-21.
 */


import java.awt.*;
public class Brick {

    public Point position = new Point(0,0);
    public int width = 70;
    public int height= 30;
    public Color mainColor = Color.RED.darker();

    public Point bounceVector(Rectangle hitbox) {
        Point p = new Point(1,1);

        Rectangle hb_t = new Rectangle(position.x, position.y, width, height/30);
        Rectangle hb_b = new Rectangle(position.x, position.y+height-height/30, width, height/30);
        Rectangle hb_l = new Rectangle(position.x, position.y, width/100, height);
        Rectangle hb_r = new Rectangle(position.x+width-width/100, position.y, width/100, height);

        if (hb_t.intersects(hitbox) || hb_b.intersects(hitbox)) {
            p.y = -1;
            GameThread.score++;
        }
        if (hb_l.intersects(hitbox) || hb_r.intersects(hitbox)) {
            p.x = -1;
            GameThread.score++;
        }


        return p;
    }

    public void render(Graphics g) {
        g.setColor(mainColor);
        g.fillRect(position.x, position.y, width, height);

        for (int i=0; i< height/4; i++) {
            g.setColor(mainColor.darker());
            g.drawLine(position.x+i, position.y+height-i, position.x+width-1, position.y+height-i);
            g.drawLine(position.x+width-1-i, position.y+i, position.x+width-1-i, position.y+height);

            g.setColor(mainColor.brighter());
            g.drawLine(position.x, position.y+i, position.x+width-1-i, position.y+i);
            g.drawLine(position.x+i, position.y+height-i, position.x+i, position.y);

        }

        Rectangle hb_t = new Rectangle(position.x, position.y, width, height/30);
        Rectangle hb_b = new Rectangle(position.x, position.y+height-height/30, width, height/30);
        Rectangle hb_l = new Rectangle(position.x, position.y, width/100, height);
        Rectangle hb_r = new Rectangle(position.x+width-width/100, position.y, width/100, height);

        //g.setColor(new Color(0, 0, 255, 100));
        g.setColor(new Color(255, 255, 255, 255));
        g.fillRect(hb_t.x, hb_t.y, hb_t.width, hb_t.height);
        //g.setColor(new Color(0, 255, 0, 100));
        g.setColor(new Color(255, 255, 255, 255));
        g.fillRect(hb_b.x, hb_b.y, hb_b.width, hb_b.height);
        //g.setColor(new Color(255, 0, 255, 100));
        g.setColor(new Color(255, 255, 255, 255));
        g.fillRect(hb_l.x, hb_l.y, hb_l.width, hb_l.height);
        //g.setColor(new Color(255, 0, 0, 100));
        g.setColor(new Color(255, 255, 255, 255));
        g.fillRect(hb_r.x, hb_r.y, hb_r.width, hb_r.height);


    }


}
