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

    public boolean hitByProjectile(int projectileCount, List<Projectile> projectiles) {
        if ((doesExist()) && (getX() <= projectiles.get(projectileCount).getX()) && (projectiles.get(projectileCount).getX() <= getX() + 22) && (getY() <= projectiles.get(projectileCount).getY()) && (projectiles.get(projectileCount).getY() <= getY() + 14)) {
            incrementCount();
            return true;
        }
        return false;
    }

}