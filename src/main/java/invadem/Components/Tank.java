package invadem.Components;

import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;

public class Tank extends Component {

    private int count;

    private List<Projectile> projectiles;

    public Tank(PImage image, int x, int y) {
        super(image, x, y);
        this.count = 0;
        this.width = 22;
        this.height = 14;
        this.projectiles = new ArrayList<>();
    }

    public void moveRight() {
        this.x += 4;
    }

    public void moveLeft() {
        this.x -= 4;
    }

    public int getCount() {
        return this.count;
    }

    public List<Projectile> getProjectiles() {
        return this.projectiles;
    }

    public void incrementCount() {
        this.count++;
    }

    public void hitByPowerProjectile() {
        this.count = 3;
    }

    public boolean hitByProjectile(Projectile proj) {
        if ((doesExist()) && (getX() <= proj.getX()) && (proj.getX() <= getX() + getWidth()) && (getY() <= proj.getY()) && (proj.getY() <= getY() + getHeight())) {
            incrementCount();
            return true;
        }
        return false;
    }

}
