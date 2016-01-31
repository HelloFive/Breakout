/**
 * Created by SPARK on 2016-01-28.
 */
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SplashScreen extends JWindow {

    private static JProgressBar progressBar = new JProgressBar();
    public static SplashScreen execute;
    private static int count;
    private static Timer timer1;

    public SplashScreen() {

        Container container = getContentPane();
        container.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new javax.swing.border.EtchedBorder());
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(10, 10, 348, 450);
        panel.setLayout(null);
        container.add(panel);

        JLabel label = new JLabel("Welcome to Breakout!");
        label.setFont(new Font("Verdana", Font.BOLD, 14));
        label.setBounds(85, 25, 280, 30);
        panel.add(label);

        JLabel label2 = new JLabel("Button Introduction");
        label2.setFont(new Font("Verdana", Font.BOLD, 14));
        label2.setBounds(85, 45, 280, 30);
        panel.add(label2);

        JLabel label3 = new JLabel("Q : Quit Game");
        label3.setFont(new Font("Verdana", Font.BOLD, 14));
        label3.setBounds(75, 75, 280, 30);
        panel.add(label3);

        JLabel label4 = new JLabel("ESC : Pause Game");
        label4.setFont(new Font("Verdana", Font.BOLD, 14));
        label4.setBounds(75, 95, 280, 30);
        panel.add(label4);

        JLabel label5 = new JLabel("SPACE BAR : Start Game");
        label5.setFont(new Font("Verdana", Font.BOLD, 14));
        label5.setBounds(75, 115, 280, 30);
        panel.add(label5);

        JLabel label6 = new JLabel("A : Increase Ball Size");
        label6.setFont(new Font("Verdana", Font.BOLD, 14));
        label6.setBounds(75, 135, 280, 30);
        panel.add(label6);

        JLabel label7 = new JLabel("S : Decrease Ball Size");
        label7.setFont(new Font("Verdana", Font.BOLD, 14));
        label7.setBounds(75, 155, 280, 30);
        panel.add(label7);

        JLabel label8 = new JLabel("D : Increase Paddle Width");
        label8.setFont(new Font("Verdana", Font.BOLD, 14));
        label8.setBounds(75, 175, 280, 30);
        panel.add(label8);

        JLabel label9 = new JLabel("F : Decrease Paddle Width");
        label9.setFont(new Font("Verdana", Font.BOLD, 14));
        label9.setBounds(75, 195, 280, 30);
        panel.add(label9);

        JLabel label13 = new JLabel("G : Increase Ball Speed");
        label13.setFont(new Font("Verdana", Font.BOLD, 14));
        label13.setBounds(75, 215, 280, 30);
        panel.add(label13);

        JLabel label14 = new JLabel("H : Decrease Ball Speed");
        label14.setFont(new Font("Verdana", Font.BOLD, 14));
        label14.setBounds(75, 235, 280, 30);
        panel.add(label14);

        JLabel label15 = new JLabel("(Set Speed of Ball before Game Starts)");
        label15.setFont(new Font("Verdana", Font.BOLD, 10));
        label15.setBounds(75, 250, 280, 30);
        panel.add(label15);

        JLabel label10 = new JLabel("1~9: Set Level 1~9");
        label10.setFont(new Font("Verdana", Font.BOLD, 14));
        label10.setBounds(75, 285, 280, 30);
        panel.add(label10);

        JLabel label11 = new JLabel("0: Set to Max Level");
        label11.setFont(new Font("Verdana", Font.BOLD, 14));
        label11.setBounds(75, 305, 280, 30);
        panel.add(label11);

        JLabel label12 = new JLabel("(Press ESC to re-start with selected level)");
        label12.setFont(new Font("Verdana", Font.BOLD, 10));
        label12.setBounds(75, 325, 280, 30);
        panel.add(label12);

        JLabel label20 = new JLabel("Built by Sang Min Park, 20339192");
        label20.setFont(new Font("Verdana", Font.BOLD, 10));
        label20.setBounds(75, 400, 280, 30);
        panel.add(label20);

        progressBar.setMaximum(100);
        progressBar.setBounds(55, 480, 250, 15);
        container.add(progressBar);
        loadProgressBar();
        setSize(370, 515);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadProgressBar() {
        ActionListener al = new ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                count++;

                progressBar.setValue(count);

                if (count%10 == 0) System.out.println(count);

                if (count == 10) {

                    createFrame();

                    execute.setVisible(false); //swapped this around with timer1.stop()

                    timer1.stop();
                }

            }

            private void createFrame() throws HeadlessException {
                //////////////////////////////////////////////////////////////////////
                JFrame frame = new JFrame("Breakout");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(1280, 740);
                frame.setMinimumSize(new Dimension(1280, 740));
                frame.setLayout(new BorderLayout());
                frame.setLocationRelativeTo(null);

                Breakout game = new Breakout(1280, 720);
                frame.add(game, BorderLayout.CENTER);


                frame.setVisible(true);
                //////////////////////////////////////////////////////////////////////

            }
        };
        timer1 = new Timer(100, al);
        timer1.start();
    }
};
