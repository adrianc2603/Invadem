package invadem.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import invadem.Components.Barriers.Barrier;
import invadem.Components.Invaders.Invader;
import invadem.Components.Invaders.PowerInvader;
import invadem.Components.Projectile;
import invadem.Components.Tank;
import processing.core.PApplet;

public class ConcreteLevel implements Level {

    private Tank tank;
    private List<Barrier> barriers;
    private List<Invader> invaders;

    private List<Projectile> invaderProjectiles;

    long shootStartTime;
    long shootTime;

    private int currentScore;
    private final int highScore;

    private long frameCount = 0;

    private PApplet parent;

    public ConcreteLevel(PApplet parent, long shootTime, int currentScore, int highScore, Tank tank,
                         List<Barrier> barriers, List<Invader> invaders) {
        this.tank = tank;
        this.barriers = barriers;
        this.invaders = invaders;

        this.invaderProjectiles = new ArrayList<>();

        this.shootStartTime = System.currentTimeMillis() - shootTime;
        this.shootTime = shootTime;

        this.currentScore = currentScore;
        this.highScore = highScore;

        this.parent = parent;
    }

    @Override
    public Tank getTank() {
        return tank;
    }

    @Override
    public List<Invader> getInvaders() {
        return invaders;
    }

    @Override
    public List<Barrier> getBarriers() {
        return barriers;
    }

    @Override
    public List<Projectile> getInvaderProjectiles() {
        return invaderProjectiles;
    }

    @Override
    public int getCurrentScore() {
        return this.currentScore;
    }

    @Override
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
        frameCount++;
        if (frameCount % 2 == 0) {
            moveInvaders();
        }

        // Display current score and high score to screen
        parent.text("CURRENT SCORE: " + currentScore, 7, 15);
        parent.text("HIGH SCORE: " + highScore, 460, 15);
    }

    // Return true if there is at least one invader left on screen
    @Override
    public boolean invadersExist() {
        for (Invader invader : invaders) {
            if (invader.doesExist()) {
                return true;
            }
        }
        return false;
    }

    @Override
    // End the game if the invaders reach the barriers
    public boolean invadersReachBarrier() {
        for (Invader invader : invaders) {
            if (invader.doesExist() && invader.getY() == 412) {
                return true;
            }
        }
        return false;
    }


    // Load invaders to screen unless they have been destroyed
    private void loadInvaders() {
        for (Invader invader : invaders) {
            if (invader.doesExist()) {
                parent.image(invader.getImage(), invader.getX(), invader.getY());
            }
        }
    }

    // Move invaders across/down the screen
    private void moveInvaders() {
        for (Invader invader : invaders) {
            invader.move();
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
        invaderProjectiles.add(new Projectile(parent.loadImage(imagePath), invaderToShoot.getX() + 8,
                invaderToShoot.getY(), isPower));
    }

    // Fire invader projectile, destroying barrier/tank if it hits it
    private void fireInvaderProjectile() {
        for (Projectile proj : invaderProjectiles) {
            if (!proj.doesExist()) {
                continue;
            }
            parent.image(proj.getImage(), proj.getX(), proj.getY());
            proj.moveDown();
            if (barrierIsHit(proj) || proj.getY() >= 480) {
                proj.destroy();
            }
            if (tank.hitByProjectile(proj)) {
                if (proj.isPower()) {
                    tank.hitByPowerProjectile();
                }
                proj.destroy();
            }
        }
    }

    // Fire projectile from tank and destroy barrier/invader if it hits it
    private void fireTankProjectile() {
        for (Projectile proj : tank.getProjectiles()) {
            if (!proj.doesExist()) {
                continue;
            }
            parent.image(proj.getImage(), proj.getX(), proj.getY());
            proj.moveUp();
            if (barrierIsHit(proj) || destroyInvader(proj) || proj.getY() <= 0) {
                proj.destroy();
            }
        }
    }

    // Remove invader from screen if it's destroyed by projectile fired by tank and return true
    private boolean destroyInvader(Projectile proj) {
        int score;
        for (Invader invader : invaders) {
            score = invader.hasBeenShot(proj);
            if (score != 0) {
                currentScore += score;
                invader.destroy();
                return true;
            }
        }
        return false;
    }

    // If barrier is hit by a projectile, slowly destroy it
    private boolean barrierIsHit(Projectile proj) {
        for (Barrier barrier : barriers) {
            if (barrier.hitByProjectile(proj)) {
                return true;
            }
        }
        return false;
    }
}
