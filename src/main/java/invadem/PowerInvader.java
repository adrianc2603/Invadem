package invadem;

import processing.core.PApplet;
import processing.core.PImage;

public class PowerInvader extends Invader {

    public PowerInvader(String rootImagePath, int x, int y, PApplet parent) {
        super(rootImagePath, x, y, parent);
    }

    int hasBeenShot(Tank tank, int tankProjectileCount) {
        if ((doesExist()) && (getX() <= tank.getProjectiles().get(tankProjectileCount).getX()) && (tank.getProjectiles().get(tankProjectileCount).getX() <= getX() + 16) && (getY() <= tank.getProjectiles().get(tankProjectileCount).getY()) && (tank.getProjectiles().get(tankProjectileCount).getY() <= getY() + 16)) {
            return 250;
        }
        return 0;
    }
}
