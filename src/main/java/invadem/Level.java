package invadem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import processing.core.PApplet;

public class Level {

    private Tank tank;
    private List<Projectile> invaderProjectiles;
    private List<Barrier> barriers;
    private List<Invader> invaders;

    private int tankProjectileCount;
    private int invaderProjectileCount;

    private int countMoveDown;
    private int countMoveHorizontal;
    private boolean movingDown;

    long shootStartTime;
    long shootTime;

    private int currentScore;
    private final int highScore;

    private long frameCount;

    private PApplet parent;

    public Level(PApplet parent, long shootTime, int currentScore, int highScore) {
        this.tank = new Tank(parent.loadImage("tank1.png"), 320, 455);
        this.invaderProjectiles = new ArrayList<>();
        this.barriers = BuildArrayLists.buildBarriers(parent);
        this.invaders = BuildArrayLists.buildInvaders(parent);

        this.tankProjectileCount = 0;
        this.invaderProjectileCount = 0;

        this.countMoveDown = 0;
        this.countMoveHorizontal = 0;
        this.movingDown = false;

        this.shootStartTime = System.currentTimeMillis();
        this.shootTime = shootTime;

        this.currentScore = currentScore;
        this.highScore = highScore;

        this.frameCount = 0;

        this.parent = parent;
    }

    public Tank getTank() {
        return tank;
    }

    public List<Invader> getInvaders() {
        return invaders;
    }

    public List<Barrier> getBarriers() {
        return barriers;
    }

    public List<Projectile> getInvaderProjectiles() {
        return invaderProjectiles;
    }

    public int getCurrentScore() {
        return this.currentScore;
    }

    public void tick() {

        // Load tank to screen if it still exists
        if (tank.doesExist() && tank.getCount() < 3) {
            parent.image(tank.getImage(), tank.getX(), tank.getY());
        }

        // Load barriers to screen unless they have been destroyed
        for (Barrier barrier : barriers) {
            if (barrier.doesExist() && barrier.getCount() != 3) {
                parent.image(barrier.getImage(), barrier.getX(), barrier.getY());
            }
            else {
                barrier.destroy();
            }
        }

        // Load invaders to screen unless they have been destroyed
        loadInvaders();

        // Fire projectile from tank. If it reaches invader/barrier, invader/barrier is destroyed
        fireTankProjectile();

        // Prepare to shoot a projectile from a random invader after 5/4/3/2/1 seconds (depending on the level)
        if (shootStartTime + shootTime <= System.currentTimeMillis()) {
            prepareInvaderFire();
            shootStartTime = System.currentTimeMillis();
        }

        // Fire projectile from invader. If it reaches barrier/tank, barrier/tank is destroyed
        fireInvaderProjectile();

        // Move invaders across and down screen every two frames
        if (frameCount % 2 == 0) {
            moveInvaders();
            frameCount = 0;
        }
        frameCount++;

        // Display current score and high score to screen
        parent.text("CURRENT SCORE: " + currentScore, 7, 15);
        parent.text("HIGH SCORE: " + highScore, 460, 15);
    }

    // Load invaders to screen unless they have been destroyed
    private void loadInvaders() {
        for (Invader invader : invaders) {
            if (invader.doesExist() && !movingDown) {
                parent.image(invader.getImage(), invader.getX(), invader.getY());
            }
            else if (invader.doesExist()) {
                parent.image(invader.getImage2(), invader.getX(), invader.getY());
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
        invaderProjectiles.add(new Projectile(parent.loadImage(imagePath), invaderToShoot.getX() + 8, invaderToShoot.getY(), isPower));
    }

    // Fire invader projectile, destroying barrier/tank if it hits it
    private void fireInvaderProjectile() {
        invaderProjectileCount = 0;
        while (invaderProjectileCount < invaderProjectiles.size()) {
            if (invaderProjectiles.get(invaderProjectileCount).doesExist()) {
                parent.image(invaderProjectiles.get(invaderProjectileCount).getImage(), invaderProjectiles.get(invaderProjectileCount).getX(), invaderProjectiles.get(invaderProjectileCount).getY());
                invaderProjectiles.get(invaderProjectileCount).moveDown();
                if (barrierIsHit(invaderProjectileCount, invaderProjectiles) || invaderProjectiles.get(invaderProjectileCount).getY() == 480) {
                    invaderProjectiles.get(invaderProjectileCount).destroy();
                }
                if (tank.hitByProjectile(invaderProjectileCount, invaderProjectiles)) {
                    if (invaderProjectiles.get(invaderProjectileCount).isPower()) {
                        tank.hitByPowerProjectile();
                    }
                    invaderProjectiles.get(invaderProjectileCount).destroy();
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
                parent.image(tank.getProjectiles().get(tankProjectileCount).getImage(), tank.getProjectiles().get(tankProjectileCount).getX(), tank.getProjectiles().get(tankProjectileCount).getY());
                tank.getProjectiles().get(tankProjectileCount).moveUp();
                if (barrierIsHit(tankProjectileCount, tank.getProjectiles()) || destroyInvader() || tank.getProjectiles().get(tankProjectileCount).getY() == 0) {
                    tank.getProjectiles().get(tankProjectileCount).destroy();
                }
            }
            tankProjectileCount++;
        }
    }

    // End the game if the invaders reach the barriers
    public boolean invadersReachBarrier() {
        for (Invader invader : invaders) {
            if (invader.doesExist() && invader.getY() == 412) {
                return true;
            }
        }
        return false;
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
    public boolean invadersExist() {
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
}
