package invadem.Components;

import processing.core.PImage;

public class Projectile extends Component {

    private final boolean isPower;

    public Projectile(PImage image, int x, int y, boolean isPower) {
        super(image, x, y);
        this.isPower = isPower;
    }

    public void moveUp() {
        this.y -= 10;
    }

    public void moveDown() {
        this.y += 3;
    }

    public boolean isPower() {
        return this.isPower;
    }
}
