package invadem;

import invadem.LevelBuilder.*;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class App extends PApplet {

    private Level level;

    private int shootTime = 5000;

    private int highScore = 10000;

    private PImage gameOver;
    private boolean gameOverFlag;

    private PImage nextLevel;
    private boolean nextLevelFlag;

    private boolean controlsFlag, pauseFlag, quitFlag;

    private int timer = 0;

    private int levelCount = 1;

    public App() {}

    public void setup() {
        // Define frame rate
        frameRate(60);

        int currentScore = 0;
        if (levelCount != 1) {
            currentScore = level.getCurrentScore();
            shootTime = 5000;
        }

        LevelDirector director = new LevelDirector(new ConcreteLevelBuilder(), this, shootTime, currentScore, highScore);
        level = director.construct();

        gameOver = loadImage("gameover.png");
        gameOverFlag = false;

        nextLevel = loadImage("nextlevel.png");
        nextLevelFlag = false;

        PFont font = createFont("PressStart2P-Regular.ttf", 10);
        textFont(font);

        controlsFlag = true;
        pauseFlag = quitFlag = false;
    }

    public void settings() {

        // Create window
        size(640, 480);
    }

    public void draw() {

        // Create black background
        background(0);

        // If game is over, display game over image and start initial level
        if (gameOverFlag) {
            image(gameOver, 267, 220);
            restart();
        }

        // If next level is achieved, display next level image and start next level
        if (nextLevelFlag && !gameOverFlag) {
            image(nextLevel, 267, 220);
            restart();
        }
        timer += 1;

        // If user hits c, show them the controls of the game
        if (controlsFlag && !pauseFlag && !quitFlag) {
            text("INVADEM: LEVEL " + levelCount, 250, 140);
            text("LEFT KEY - MOVE TANK LEFT", 205, 200);
            text("RIGHT KEY - MOVE TANK RIGHT", 200, 220);
            text("SPACEBAR - FIRE PROJECTILE", 200, 240);
            text("P - PAUSE GAME", 255, 260);
            text("Q - QUIT GAME", 255, 280);
            text("C - DISPLAY CONTROLS", 232, 300);
            text("G - GO TO GAME", 255, 320);
        }

        // If game is paused, print game is pause to screen
        if (pauseFlag) {
            text("GAME IS PAUSED, PRESS P TO CONTINUE", 145, 235);
        }

        // If user hits q, ask if they want to quit the game
        if (quitFlag) {
            text("QUIT GAME? (Y/N)", 245, 235);
        }

        if (gameOverFlag || nextLevelFlag || controlsFlag || pauseFlag || quitFlag) {
            return;
        }

        level.tick();

        if (level.invadersReachBarrier() || level.getTank().getCount() == 3) {
            gameOver();
        }

        if (!level.invadersExist()) {
            nextLevel();
        }

    }

    public void keyPressed() {
        if (key == CODED) {

            // If LEFT key is pressed, move tank left, until it reaches its range
            if (keyCode == LEFT && !gameOverFlag && !nextLevelFlag) {
                if (level.getTank().getX() >= 180) {
                    level.getTank().moveLeft();
                }
            }

            // If RIGHT key is pressed, move tank right, until it reaches its range
            if (keyCode == RIGHT && !gameOverFlag && !nextLevelFlag) {
                if (level.getTank().getX() <= 460) {
                    level.getTank().moveRight();
                }
            }
        }

        // If SPACEBAR is pressed, prepare to fire projectile
        if (key == ' ' && !gameOverFlag && !nextLevelFlag && !controlsFlag) {
            int xTankProjectile = level.getTank().getX() + 11;
            int yTankProjectile = level.getTank().getY();
            level.getTank().getProjectiles().add(new Projectile(loadImage("projectile.png"), xTankProjectile, yTankProjectile, false));
        }

        // If c is pressed, display game controls
        if (key == 'c' && !gameOverFlag && !nextLevelFlag && !controlsFlag) {
            controlsFlag = true;
        }

        // If g is pressed, remove controls screen and go to game
        if (key == 'g' && controlsFlag && !gameOverFlag && !nextLevelFlag) {
            controlsFlag = false;
        }

        // IF p is pressed, pause/unpause the game
        if (key == 'p' && !gameOverFlag && !nextLevelFlag && !quitFlag) {
            pauseFlag = !pauseFlag;
        }

        // If q is pressed, ask the user if they want to quit the game
        if (key == 'q' && !quitFlag && !gameOverFlag && !nextLevelFlag & !pauseFlag) {
            quitFlag = true;
        }

        // If y is pressed when the user is asked if they want to quit the game, exit the game
        if (key == 'y' && quitFlag && !gameOverFlag && !nextLevelFlag & !pauseFlag) {
            exit();
        }

        // If n is whilst user is asked to quit game, game will resume
        if (key == 'n' && quitFlag && !gameOverFlag && !nextLevelFlag && !pauseFlag) {
            quitFlag = false;
        }
    }

    private void startLevel() {
        level.getTank().destroy();
        destroyAllInvaders();
        destroyAllBarriers();
        removeTankProjectiles();
        removeInvaderProjectiles();
    }

    // Remove invaders, barriers, tank and projectiles from screen and end the game.
    private void gameOver() {
        startLevel();
        levelCount = 0;
        shootTime = 5000;
        if (level.getCurrentScore() > highScore) {
            highScore = level.getCurrentScore();
        }
        timer = 0;
        gameOverFlag = true;
    }

    // Remove invaders, barriers, tank and projectiles from screen and move to the next level.
    public void nextLevel() {
        startLevel();
        levelCount++;
        if (shootTime != 1000) {
            shootTime -= 1000;
        }
        timer = 0;
        nextLevelFlag = true;
    }

    // Load the first/next level
    private void restart() {
        if (timer == 180) {
            setup();
        }
    }

    // Remove all tank projectiles from the screen and empty the tank projectiles list
    private void removeTankProjectiles() {
        for (Projectile projectile : level.getTank().getProjectiles()) {
            projectile.destroy();
        }
        level.getTank().getProjectiles().clear();
    }

    // Remove all invader projectiles from the screen and empty all invader projectile lists
    private void removeInvaderProjectiles() {
        for (Projectile projectile : level.getInvaderProjectiles()) {
            projectile.destroy();
        }
        level.getInvaderProjectiles().clear();
    }

    // Remove all invaders from the screen and empty all invader lists
    private void destroyAllInvaders() {
        for (Invader invader : level.getInvaders()) {
            invader.destroy();
        }
        level.getInvaders().clear();
    }

    // Remove all barriers from the screen and empty the barriers list
    private void destroyAllBarriers() {
        for (Barrier barrier : level.getBarriers()) {
            barrier.destroy();
        }
        level.getBarriers().clear();
    }

    public static void main(String[] args) {
        PApplet.main("invadem.App");
    }
}