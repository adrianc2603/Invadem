package invadem.Components.Barriers;

import invadem.Components.Barriers.BarrierShotState.*;
import invadem.Components.Barriers.BarrierShotState.ShotState;
import invadem.Components.Component;
import invadem.Components.Projectile;
import processing.core.PApplet;
import processing.core.PImage;

import java.util.List;

public class Barrier extends Component {

    private int count;
    private ShotState shotState;
    PApplet parent;
    String imagePathBeginning;

    public Barrier(String imagePathBeginning, int x, int y, PApplet parent) {
        super(parent.loadImage(imagePathBeginning + "1.png"), x, y);
        this.imagePathBeginning = imagePathBeginning;
        this.parent = parent;
        this.x = x;
        this.y = y;
        this.count = 0;
        this.shotState = new NeverShotState();
    }

    @Override
    public PImage getImage() {
        return shotState.getImage(this.imagePathBeginning, this.parent);
    }

    public int getCount() {
        return this.count;
    }

    public void incrementCount() {
        this.count++;
        if (this.count == 1) {
            shotState = new ShotOnceState();
        }
        if (this.count == 2) {
            shotState = new ShotTwiceState();
        }
        if (this.count == 3) {
            destroy();
        }
    }

    public boolean hitByProjectile(int projectileCount, List<Projectile> projectiles) {
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
