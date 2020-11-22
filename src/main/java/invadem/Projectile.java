package invadem;

import processing.core.PImage;

class Projectile extends Components {

    private boolean isPower;

    Projectile(PImage image, int x, int y, boolean isPower) {
        super(image, x, y);
        this.isPower = isPower;
    }

    void moveUp() {
        this.y -= 10;
    }

    void moveDown() {
        this.y += 3;
    }

    boolean isPower() {
        return this.isPower;
    }
}
