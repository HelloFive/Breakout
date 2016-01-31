CS 349 A1: Breakout
=========================================

How to use 'makefile':
        make        : this will compile the Breakout            : equal as "javac Main.java"
        make run    : this will compile and run the Breakout    : equal as "java Main"


OR if you want to run it manually in order to set FPS and SPEED, please follow the instructions below:
		javac Main.java
		java Main FPS SPEED
			(put integer 25~45 for FPS)
			(put integer 10~90 for SPEED)

=========================================


During you are playing this game, here are Keyboard Button tutorials.

SPACE BAR - Start Game
Q - Quit Game
ESC - Pause/Rejoin Game
A - Increase Ball Size
S - Decrease Ball Size
D - Increase Paddle Size
F - Decrease Paddle Size
G - Increase Ball Speed (Set this before Game Start)
H - Decrease Ball Speed (Set this before Game Start)
1 - Enter Level 1
2 - Enter Level 2
3 - Enter Level 3
4 - Enter Level 4
5 - Enter Level 5
6 - Enter Level 6
7 - Enter Level 7
8 - Enter Level 8
9 - Enter Level 9
0 - Enter Level 10 (Max Level)


=========================================

COMMENTS for grader.

There are Levels from 1 to 10.  In each level, one more lines of brick will appear.  You can cheat by skipping to each level by pressing it's level number. (ex. Press 5 to go to Level 5 / Press 0 to go to Level 10)
After switching your level, you need to re-join the game(Press ESC) since the game automatically pauses for you when you switch to different level by pressing buttons 1~0.

Information about Score, FPS, Speed of Ball, Size of Ball, Size of Ball are on the upper left corner.  Your number of balls left are displayed on bottom left corner.  It will change color like traffic lights based on how many balls you have left.

If you would like to see how game goes on to next level, without controlling a lot to not lose balls, you can simply increase size of the ball (Press A) and increase size of the paddle (Press D).
The paddle size will increase up to the the width of the window, so you won't need to control at all if you put your mouse at the middle of the screen.
In case you want this process to be quickly, make sure to increase speed of the ball(Press G) before you start the game.

If you would like to play this game with harder difficulty, you can decrease the size of ball and paddle.  Of course, there is a minimum size of the ball and paddle.
However, it was very hard for me to play this with the minimum size of ball and paddle with faster ball speed.  You can challenge on this!

Note on SPECIAL FEATURES in this game.
    - Controlling size of the Ball (Ball Power-up)
    - Controlling size of the Paddle (Paddle Power-up)
    - Multiple levels up to 10 can be cleared
    - Controlling speed of the Ball


Thanks for playing my Breakout Game.



