package invadem.Components.Invaders;

import invadem.Components.Component;
import invadem.Components.Projectile;
import invadem.Components.Tank;
import invadem.Components.Invaders.InvaderMovementStrategy.*;
import processing.core.PApplet;
import processing.core.PImage;

public abstract class Invader extends Component {

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
        this.width = 16;
        this.height = 16;
        this.movementStrategy = new MoveRightStrategy();
    }

    @Override
    public PImage getImage() {
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

    public void incrementCount() {
        this.count++;
    }

    public int getCount() {
        return this.count;
    }

    public abstract int hasBeenShot(Projectile proj);
}
