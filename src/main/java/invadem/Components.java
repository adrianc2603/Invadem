package invadem;

import processing.core.PImage;

abstract class Components {

    private PImage image;
    int x, y;
    boolean doesExist;

    Components(PImage image, int x, int y) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.doesExist = true;
    }

    PImage getImage() {
        return this.image;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    boolean doesExist() {
        return this.doesExist;
    }

    void destroy() {
        this.doesExist = false;
    }
}
