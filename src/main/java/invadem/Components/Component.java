package invadem.Components;

import processing.core.PImage;

public abstract class Component {

    private PImage image;
    protected int x, y;
    protected boolean doesExist;

    public Component(PImage image, int x, int y) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.doesExist = true;
    }

    public PImage getImage() {
        return this.image;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean doesExist() {
        return this.doesExist;
    }

    public void destroy() {
        this.doesExist = false;
    }
}
