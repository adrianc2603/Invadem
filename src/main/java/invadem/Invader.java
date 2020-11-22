package invadem;

import processing.core.PImage;

abstract class Invader extends Components {

    private PImage image2;

    private int count;

    Invader(PImage image, PImage image2, int x, int y) {
        super(image, x, y);
        this.image2 = image2;
        this.count = 0;
    }

    PImage getImage2() {
        return this.image2;
    }

    void moveRight() {
        this.x++;
    }

    void moveDown() {
        this.y++;
    }

    void moveLeft() {
        this.x--;
    }

    void incrementCount() {
        this.count++;
    }

    int getCount() {
        return this.count;
    }

    abstract int hasBeenShot(Tank tank, int tankProjectileCount);
}
