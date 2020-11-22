package invadem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class App extends PApplet {

    // Declare Tank object
    private Tank tank;

    // Declare ArrayLists to store invader projectile objects
    private List<Projectile> invaderProjectiles;

    // Declare ArrayList to store barrier objects
    private List<Barrier> barriers;

    // Declare ArrayLists to store invader objects
    private List<Invader> invaders;

    // Declare game over image
    private PImage gameOver;

    // Declare next level image
    private PImage nextLevel;

    // Declare count to control which projectile appears from the list of tank projectiles
    private int tankProjectileCount;

    // Declare count to control which projectile appears from the list of invader projectiles
    private int invaderProjectileCount;

    // Declare boolean to control gameOver
    private boolean gameOverFlag;

    // Declare boolean to control nextLevel
    private boolean nextLevelFlag;

    // Declare how many pixels the invaders can move
    private int countMoveDown;
    private int countMoveHorizontal;

    // Declare boolean to control which invader appears to screen
    private boolean movingDown;

    // Declare time to control when an invader shoots a projectile
    long startTime;

    // Initialise time indicating when an invader shoots a projectile
    long shootTime = 5000;

    // Declare integer indicating when initial/next level starts
    private int timer;

    // Initialise current score which increments as invaders are destroyed but is set back to zero if the computer wins
    private int currentScore = 0;

    // Initialise default high score
    private int highScore = 10000;

    // Declare boolean to control appearance of pause menu, quit menu and game controls
    private boolean controlsFlag, pauseFlag, quitFlag;

    // Initialise level count
    private int levelCount = 1;

    public App() {

        // Initialise ArrayLists to store invader projectile objects
        invaderProjectiles = new ArrayList<>();

        // Initialise ArrayLists to store barrier objects
        barriers = new ArrayList<>();

        // Initialise ArrayLists to store invader objects
        invaders = new ArrayList<>();
    }

    public void setup() {

        // Define frame rate
        frameRate(60);

        startTime = System.currentTimeMillis();

        // Initialise tank
        tank = new Tank(loadImage("tank1.png"), 320, 455);

        // Build barriers
        barriers = BuildArrayLists.buildBarriers(this);

        // Build invaders
        invaders = BuildArrayLists.buildInvaders(this);

        // Initialise game over image
        gameOver = loadImage("gameover.png");

        // Initialise boolean to control gameOver
        gameOverFlag = false;

        // Initialise next level image
        nextLevel = loadImage("nextlevel.png");

        // Initialise boolean to control nextLevel
        nextLevelFlag = false;

        // Initialise count to control which projectile appears from the list of tank projectiles
        invaderProjectileCount = 0;

        // Initialise how many pixels the invaders can move
        countMoveDown = countMoveHorizontal = 0;

        // Initialise boolean to control which invader appears to screen
        movingDown = false;

        // Initialise font to display current score and high score onto screen
        PFont font = createFont("PressStart2P-Regular.ttf", 10);
        textFont(font);

        // Initialise boolean to control appearance of pause menu, quit menu and game controls
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

        // Load tank to screen if it still exists
        if (tank.doesExist() && tank.getCount() < 3) {
            image(tank.getImage(), tank.getX(), tank.getY());
        }

        // Load barriers to screen unless they have been destroyed
        for (Barrier barrier : barriers) {
            if (barrier.doesExist() && barrier.getCount() == 0) {
                image(barrier.getImage(), barrier.getX(), barrier.getY());
            }
            else if (barrier.doesExist() && barrier.getCount() == 1) {
                image(barrier.getImage2(), barrier.getX(), barrier.getY());
            }
            else if (barrier.doesExist() && barrier.getCount() == 2) {
                image(barrier.getImage3(), barrier.getX(), barrier.getY());
            }
            else if (barrier.doesExist() && barrier.getCount() == 3) {
                barrier.destroy();
            }
        }

        // Load invaders to screen unless they have been destroyed
        loadInvaders();

        // Fire projectile from tank. If it reaches invader/barrier, invader/barrier is destroyed
        fireTankProjectile();

        // Prepare to shoot a projectile from a random invader after 5/4/3/2/1 seconds (depending on the level)
        if (startTime + shootTime <= System.currentTimeMillis()) {
            prepareInvaderFire();
            startTime = System.currentTimeMillis();
        }

        // Fire projectile from invader. If it reaches barrier/tank, barrier/tank is destroyed
        fireInvaderProjectile();

        // Move invaders across and down screen every two frames
        if (frameCount % 2 == 0) {
            moveInvaders();
        }

        // If there are no invaders left, start the next level
        if (!invadersExist()) {
            nextLevel();
        }

        // Display current score and high score to screen
        text("CURRENT SCORE: " + currentScore, 7, 15);
        text("HIGH SCORE: " + highScore, 460, 15);
    }

    public void keyPressed() {
        if (key == CODED) {

            // If LEFT key is pressed, move tank left, until it reaches its range
            if (keyCode == LEFT && !gameOverFlag && !nextLevelFlag) {
                if (tank.getX() >= 180) {
                    tank.moveLeft();
                }
            }

            // If RIGHT key is pressed, move tank right, until it reaches its range
            if (keyCode == RIGHT && !gameOverFlag && !nextLevelFlag) {
                if (tank.getX() <= 460) {
                    tank.moveRight();
                }
            }
        }

        // If SPACEBAR is pressed, prepare to fire projectile
        if (key == ' ' && !gameOverFlag && !nextLevelFlag && !controlsFlag) {
            int xTankProjectile = tank.getX() + 11;
            int yTankProjectile = tank.getY();
            tank.getProjectiles().add(new Projectile(loadImage("projectile.png"), xTankProjectile, yTankProjectile, false));
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

    // Load invaders to screen unless they have been destroyed
    private void loadInvaders() {
        for (Invader invader : invaders) {
            if (invader.doesExist() && !movingDown) {
                image(invader.getImage(), invader.getX(), invader.getY());
            }
            else if (invader.doesExist()) {
                image(invader.getImage2(), invader.getX(), invader.getY());
            }
        }
    }

    // Move invaders across/down the screen
    private void moveInvaders() {
        if (countMoveHorizontal < 30 && countMoveDown == 0) {
            movingDown = false;
            for (Invader invader : invaders) {
                invader.moveRight();
            }
            countMoveHorizontal++;
        }
        if (countMoveHorizontal == 30 && countMoveDown < 8) {
            movingDown = true;
            for (Invader invader : invaders) {
                invader.moveDown();
            }
            countMoveDown++;
            if (invadersReachBarrier()) {
                gameOver();
            }
        }
        if (countMoveHorizontal > 0 && countMoveDown == 8) {
            movingDown = false;
            for (Invader invader : invaders) {
                invader.moveLeft();
            }
            countMoveHorizontal--;
        }
        if (countMoveHorizontal == 0 && countMoveDown > 0) {
            movingDown = true;
            for (Invader invader : invaders) {
                invader.moveDown();
            }
            countMoveDown--;
            if (invadersReachBarrier()) {
                gameOver();
            }
        }
    }

    // Prepare invader fire by choosing which invader will randomly shoot and creating a projectile object
    private void prepareInvaderFire() {

        // Get the invader that will shoot
        Random random = new Random();
        Invader invaderToShoot;
        while (true) {
            int invaderShoot = random.nextInt(invaders.size());
            invaderToShoot = invaders.get(invaderShoot);
            if (invaderToShoot.doesExist()) {
                break;
            }
        }

        // Create the Projectile object
        String imagePath = "projectile.png";
        boolean isPower = false;
        if (invaderToShoot instanceof PowerInvader) {
            imagePath = "projectile_lg.png";
            isPower = true;
        }
        invaderProjectiles.add(new Projectile(loadImage(imagePath), invaderToShoot.getX() + 8, invaderToShoot.getY(), isPower));
    }

    // Fire invader projectile, destroying barrier/tank if it hits it
    private void fireInvaderProjectile() {
        invaderProjectileCount = 0;
        while (invaderProjectileCount < invaderProjectiles.size() && (!gameOverFlag || !nextLevelFlag)) {
            if (invaderProjectiles.get(invaderProjectileCount).doesExist()) {
                image(invaderProjectiles.get(invaderProjectileCount).getImage(), invaderProjectiles.get(invaderProjectileCount).getX(), invaderProjectiles.get(invaderProjectileCount).getY());
                invaderProjectiles.get(invaderProjectileCount).moveDown();
                if (barrierIsHit(invaderProjectileCount, invaderProjectiles) || invaderProjectiles.get(invaderProjectileCount).getY() == 480) {
                    invaderProjectiles.get(invaderProjectileCount).destroy();
                }
                if (tank.hitByProjectile(invaderProjectileCount, invaderProjectiles)) {
                    if (invaderProjectiles.get(invaderProjectileCount).isPower()) {
                        tank.hitByPowerProjectile();
                    }
                    invaderProjectiles.get(invaderProjectileCount).destroy();
                    if (tank.getCount() == 3) {
                        gameOver();
                    }
                }
            }
            invaderProjectileCount++;
        }
    }

    // Fire projectile from tank and destroy barrier/invader if it hits it
    private void fireTankProjectile() {
        tankProjectileCount = 0;
        while (tankProjectileCount < tank.getProjectiles().size()) {
            if (tank.getProjectiles().get(tankProjectileCount).doesExist()) {
                image(tank.getProjectiles().get(tankProjectileCount).getImage(), tank.getProjectiles().get(tankProjectileCount).getX(), tank.getProjectiles().get(tankProjectileCount).getY());
                tank.getProjectiles().get(tankProjectileCount).moveUp();
                if (barrierIsHit(tankProjectileCount, tank.getProjectiles()) || destroyInvader() || tank.getProjectiles().get(tankProjectileCount).getY() == 0) {
                    tank.getProjectiles().get(tankProjectileCount).destroy();
                }
            }
            tankProjectileCount++;
        }
    }

    // End the game if the invaders reach the barriers
    private boolean invadersReachBarrier() {
        if (!gameOverFlag && !nextLevelFlag) {
            for (Invader invader : invaders) {
                if (invader.doesExist() && invader.getY() == 412) {
                    return true;
                }
            }
        }
        return false;
    }

    // Remove invaders, barriers, tank and projectiles from screen and end the game.
    private void gameOver() {
        tank.destroy();
        destroyAllInvaders();
        destroyAllBarriers();
        removeTankProjectiles();
        removeInvaderProjectiles(invaderProjectiles);
        levelCount = 0;
        shootTime = 5000;
        startTime = System.currentTimeMillis();
        if (currentScore > highScore) {
            highScore = currentScore;
        }
        currentScore = 0;
        timer = 0;
        gameOverFlag = true;
    }

    // Remove invaders, barriers, tank and projectiles from screen and move to the next level.
    private void nextLevel() {
        tank.destroy();
        destroyAllInvaders();
        destroyAllBarriers();
        removeTankProjectiles();
        removeInvaderProjectiles(invaderProjectiles);
        levelCount++;
        if (shootTime != 1000) {
            shootTime -= 1000;
        }
        startTime = System.currentTimeMillis();
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
        for (Projectile projectile : tank.getProjectiles()) {
            projectile.destroy();
        }
        tank.getProjectiles().clear();
    }

    // Remove all invader projectiles from the screen and empty all invader projectile lists
    private void removeInvaderProjectiles(List<Projectile> invaderProjectilesList) {
        for (Projectile projectile : invaderProjectilesList) {
            projectile.destroy();
        }
        invaderProjectilesList.clear();
    }

    // Remove all invaders from the screen and empty all invader lists
    private void destroyAllInvaders() {
        for (Invader invader : invaders) {
            invader.destroy();
        }
        invaders.clear();
    }

    // Remove all barriers from the screen and empty the barriers list
    private void destroyAllBarriers() {
        for (Barrier barrier : barriers) {
            barrier.destroy();
        }
        barriers.clear();
    }

    // Remove invader from screen if it's destroyed by projectile fired by tank and return true
    private boolean destroyInvader() {
        int score;
        for (Invader invader : invaders) {
            score = invader.hasBeenShot(tank, tankProjectileCount);
            if (score != 0) {
                currentScore += score;
                invader.destroy();
                return true;
            }
        }
        return false;
    }

    // Return true if there is at least one invader left on screen
    private boolean invadersExist() {
        for (Invader invader : invaders) {
            if (invader.doesExist()) {
                return true;
            }
        }
        return false;
    }

    // If barrier is hit by a projectile, slowly destroy it
    private boolean barrierIsHit(int projectileCount, List<Projectile> projectiles) {
        for (Barrier barrier : barriers) {
            if (barrier.hitByProjectile(projectileCount, projectiles)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PApplet.main("invadem.App");
    }
}