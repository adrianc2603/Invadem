package invadem;

import processing.core.PApplet;
import processing.core.PImage;

public class RegularInvader extends Invader {

    public RegularInvader(int x, int y, PApplet parent) {
        super(".png", x, y, parent);
    }

    int hasBeenShot(Tank tank, int tankProjectileCount) {
        if ((doesExist()) && (getX() <= tank.getProjectiles().get(tankProjectileCount).getX()) && (tank.getProjectiles().get(tankProjectileCount).getX() <= getX() + 16) && (getY() <= tank.getProjectiles().get(tankProjectileCount).getY()) && (tank.getProjectiles().get(tankProjectileCount).getY() <= getY() + 16)) {
            return 100;
        }
        return 0;
    }

}
