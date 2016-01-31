
/**
 * Created by SPARK on 2016-01-26.
 */

import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Color;

public class Breakout extends JPanel {


    public int width, height;
    public static int FPS = 35;
    public Paddle player;
    private Ball ball;
    private int balls = 3;
    public int BrickLines = 1;
    public boolean isRunning = false, isPaused = false;

    private Color[] rowColors = new Color[]{Color.RED, Color.ORANGE.darker(), Color.ORANGE, Color.YELLOW.darker(), Color.GREEN.darker(), Color.BLUE.darker(), Color.MAGENTA.darker(), Color.magenta.darker().darker()}; // gray red yellow blue pink green
    public ArrayList<Brick> bricks;

    public long lastUpdate;

    private GameThread gameThread;

    public Breakout (int width, int height) {
        this.width = width;
        this.height = height;

        reset();

        this.setFocusable(true);

        this.addMouseMotionListener (new MouseMotionAdapter() {
            public void mouseMoved (MouseEvent e) {
                player.position.x = e.getX() - getWidth()/2;
                repaint();
            }
        });

        this.addKeyListener(new KeyAdapter() {
            public void keyPressed (KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE && !isRunning) {
                    System.out.println("Pressed SPACE BAR");
                    run();
                }
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.out.println("Pressed ESC");
                    togglePause();
                }
                if (e.getKeyCode() == KeyEvent.VK_Q) {
                    System.out.println("Pressed Q");
                    quit();
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    System.out.println("Increase Ball Size by 5");
                    if (Ball.radius < 55) Ball.radius += 5;
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    System.out.println("Decrease Ball Size by 5");
                    if (Ball.radius > 5) Ball.radius -= 5;
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    System.out.println("Increase Paddle Size by 20");
                    if (Paddle.width < 1280) Paddle.width += 20;
                }
                if (e.getKeyCode() == KeyEvent.VK_F) {
                    System.out.println("Deacrease Paddle Size by 20");
                    if (Paddle.width > 50) Paddle.width -= 20;
                }

                if (e.getKeyCode() == KeyEvent.VK_G) {
                    System.out.println("Increase Ball Speed by 5");
                    if (Ball.input_speed < 100) Ball.input_speed += 5;
                }
                if (e.getKeyCode() == KeyEvent.VK_H) {
                    System.out.println("Deacrease Ball Speed by 5");
                    if (Ball.input_speed > 6) Ball.input_speed -= 5;
                }

                if (e.getKeyCode() == KeyEvent.VK_1) {
                    System.out.println("Enter Level 1");
                    BrickLines = 1;
                    createBricks(BrickLines,10);
                    next();
                }
                if (e.getKeyCode() == KeyEvent.VK_2) {
                    System.out.println("Enter Level 2");
                    BrickLines = 2;
                    createBricks(BrickLines,10);
                    next();
                }
                if (e.getKeyCode() == KeyEvent.VK_3) {
                    System.out.println("Enter Level 3");
                    BrickLines = 3;
                    createBricks(BrickLines,10);
                    next();
                }
                if (e.getKeyCode() == KeyEvent.VK_4) {
                    System.out.println("Enter Level 4");
                    BrickLines = 4;
                    createBricks(BrickLines,10);
                    next();
                }
                if (e.getKeyCode() == KeyEvent.VK_5) {
                    System.out.println("Enter Level 5");
                    BrickLines = 5;
                    createBricks(BrickLines,10);
                    next();
                }
                if (e.getKeyCode() == KeyEvent.VK_6) {
                    System.out.println("Enter Level 6");
                    BrickLines = 6;
                    createBricks(BrickLines,10);
                    next();
                }
                if (e.getKeyCode() == KeyEvent.VK_7) {
                    System.out.println("Enter Level 7");
                    BrickLines = 7;
                    createBricks(BrickLines,10);
                    next();
                }
                if (e.getKeyCode() == KeyEvent.VK_8) {
                    System.out.println("Enter Level 8");
                    BrickLines = 8;
                    createBricks(BrickLines,10);
                    next();
                }
                if (e.getKeyCode() == KeyEvent.VK_9) {
                    System.out.println("Enter Level 9");
                    BrickLines = 9;
                    createBricks(BrickLines,10);
                    next();
                }
                if (e.getKeyCode() == KeyEvent.VK_0) {
                    System.out.println("Enter Level 10");
                    BrickLines = 10;
                    next();
                }
            }
        });
    }

    public void reset() {
        player = new Paddle(this);
        ball = new Ball(this);
        balls = 3;
        GameThread.score = 0;
        Paddle.width = 100;
        Ball.radius = 10;
        createBricks(BrickLines,10); // if (1,1) -> no bricks appear and quit(); (6,10) looks fine)
    }
    public void next() {
        createBricks(BrickLines,10);
        togglePause();
        ball.position = new Point(0,50);
        if (ball.movement.y < 0) ball.movement.y *= -1;
    }

    public void run() {
        if (gameThread != null) if(gameThread.isAlive()) gameThread.interrupt();
        reset();
        gameThread = new GameThread(this);
        gameThread.start();
    }

    public void togglePause() {
        isPaused = !isPaused;

    }

    public void quit() {
        isRunning = false;

    }



    private void createBricks(int rows, int columns) {
        bricks = new ArrayList<Brick>();

        int gap = 10;
        float w = (((float)width-10)/columns)-10;
        float h = 30;
        for (int y=0; y<rows; y++) {
            for (int x=0; x<columns; x++) {
                Brick b = new Brick();
                b.mainColor = rowColors[y%rowColors.length]; // repeats color according to the given array.
                b.position.x = (int) (x*(w+gap)+gap)-width/2;
                b.position.y = (int) (y*(h+gap)+gap)-height/2;
                b.height = (int) h;
                b.width = (int) w;
                bricks.add(b);
            }
        }
    }

    public void OnBallLost() {
        balls--;
        if (balls <= 0) OnGameOver(false);
        else ball.position = new Point(0,50);
    }

    public void OnGameOver (boolean won) {
        quit();

    }


    public void tick() {
        double deltatime = (System.nanoTime()-lastUpdate)/1000000.0; // in milliseconds
        ball.tick(deltatime);
        if(bricks.isEmpty() && BrickLines == 10) OnGameOver(true);
        else if(bricks.isEmpty()) {
            BrickLines++;
            next();
        }
        repaint();
    }

    public void paint (Graphics g) {
        super.paint(g);

        g.translate((getWidth()-width)/2, (getHeight()-height)/2); // can have game always centered.
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height); // fill field with black.

        g.translate(width/2, height/2);

        player.render(g);
        ball.render(g);


        if (bricks != null) for (int i=0; i<bricks.size(); i++) bricks.get(i).render(g);


        g.setColor(Color.WHITE);
        g.setFont(new Font ("Arial", Font.BOLD, 20));
        String msg = "";
        if(!isRunning) msg = "Please insert a coin (Press Space Bar)";
        else if (isPaused) msg = "Game Paused";
        FontMetrics fm = g.getFontMetrics();
        g.drawString(msg, -fm.stringWidth(msg)/2, fm.getHeight()/2);

        // Display Score && FPS
        g.setColor(Color.WHITE);
        g.drawString("Score: " + GameThread.score, -width/2+10, -height/2+30);
        g.setColor(Color.CYAN);
        g.drawString("FPS: " + FPS, -width/2+10, -height/2+50);
        g.setColor(Color.LIGHT_GRAY);
        g.drawString("Ball Speed: " + Ball.input_speed, -width/2+10, -height/2+70);
        g.setColor(Color.GREEN);
        g.drawString("Ball Size: " + Ball.radius, -width/2+10, -height/2+90);
        g.setColor(Color.DARK_GRAY);
        g.drawString("Paddle Size: " + Paddle.width, -width/2+10, -height/2+110);

        if (balls == 3) g.setColor(Color.GREEN);
        if (balls == 2) g.setColor(Color.YELLOW);
        if (balls == 1) g.setColor(Color.RED);
        g.drawString("LIFE: " + balls, -width/2+10, height/2-20);
    }

}
