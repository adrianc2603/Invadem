package invadem;

import invadem.BarrierShotState.*;
import invadem.BarrierShotState.ShotState;
import processing.core.PApplet;
import processing.core.PImage;

import java.util.List;

class Barrier extends Components {

    private int count;
    private ShotState shotState;
    PApplet parent;
    String rootImagePath;

    Barrier(String rootImagePath, int x, int y, PApplet parent) {
        super(parent.loadImage(rootImagePath + "1.png"), x, y);
        this.rootImagePath = rootImagePath;
        this.parent = parent;
        this.x = x;
        this.y = y;
        this.count = 0;
        this.shotState = new NeverShotState();
    }

    @Override
    PImage getImage() {
        return shotState.getImage(this.rootImagePath, this.parent);
    }

    int getCount() {
        return this.count;
    }

    void incrementCount() {
        this.count++;
        if (this.count == 1) {
            shotState = new ShotOnceState();
        }
        if (this.count == 2) {
            shotState = new ShotTwiceState();
        }
    }

    boolean hitByProjectile(int projectileCount, List<Projectile> projectiles) {
        if ((doesExist()) && (getX() <= projectiles.get(projectileCount).getX()) && (projectiles.get(projectileCount).getX() <= getX() + 8) && (getY() <= projectiles.get(projectileCount).getY()) && (projectiles.get(projectileCount).getY() <= getY() + 8)) {
            if (projectiles.get(projectileCount).isPower()) {
                destroy();
            } else {
                incrementCount();
            }
            return true;
        }
        return false;
    }
}
