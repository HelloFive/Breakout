/**
 * Created by SPARK on 2016-01-26.
 */

import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.*;


public class Main {


    public static void main (String[] args) {

        SplashScreen.execute = new SplashScreen();

        //int firstArg;
        if (args.length > 0) {
            try {
                Breakout.FPS = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument" + args[0] + " should be an integer between 25 to 40.");
                System.exit(1);
            }
        }

        //int secondArg;
        if (args.length > 0) {
            try {
                Ball.input_speed = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.err.println("Argument" + args[1] + " should be an integer between 10 to 90.");
                System.exit(1);
            }
        }

    }
}
