package invadem;

import invadem.InvaderMovementStrategy.*;
import processing.core.PApplet;
import processing.core.PImage;

public abstract class Invader extends Components {

    private int count;

    private String imagePathEnding;
    private PApplet parent;

    int countMoveDown = 0;
    int countMoveHorizontal = 0;
    boolean movingDown = false;

    private MovementStrategy movementStrategy;

    public Invader(String imagePathEnding, int x, int y, PApplet parent) {
        super(parent.loadImage("invader1" + imagePathEnding), x, y);
        this.imagePathEnding = imagePathEnding;
        this.parent = parent;
        this.count = 0;
        this.movementStrategy = new MoveRightStrategy();
    }

    @Override
    PImage getImage() {
        return movementStrategy.getImage(this.imagePathEnding, this.parent);
    }

    public void move() {
        this.movementStrategy.move(this);

        if (countMoveHorizontal < 30 && countMoveDown == 0) {
            movingDown = false;
            this.movementStrategy = new MoveRightStrategy();
            countMoveHorizontal++;
        }
        if (countMoveHorizontal == 30 && countMoveDown < 8) {
            movingDown = true;
            this.movementStrategy = new MoveDownStrategy();
            countMoveDown++;
        }
        if (countMoveHorizontal > 0 && countMoveDown == 8) {
            movingDown = false;
            this.movementStrategy = new MoveLeftStrategy();
            countMoveHorizontal--;
        }
        if (countMoveHorizontal == 0 && countMoveDown > 0) {
            movingDown = true;
            this.movementStrategy = new MoveDownStrategy();
            countMoveDown--;
        }
    }


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    void incrementCount() {
        this.count++;
    }

    int getCount() {
        return this.count;
    }

    abstract int hasBeenShot(Tank tank, int tankProjectileCount);
}
