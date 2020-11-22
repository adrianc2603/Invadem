package invadem;

import processing.core.PImage;

import java.util.List;

class Barrier extends Components {

    private PImage image2, image3;
    private int count;

    Barrier(PImage image, PImage image2, PImage image3, int x, int y) {
        super(image, x, y);
        this.image2 = image2;
        this.image3 = image3;
        this.count = 0;
    }

    PImage getImage2() {
        return this.image2;
    }

    PImage getImage3() {
        return this.image3;
    }

    int getCount() {
        return this.count;
    }

    void incrementCount() {
        this.count++;
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
