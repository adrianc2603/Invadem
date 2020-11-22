package invadem.Components.Invaders;

import invadem.Components.Invaders.Invader;
import invadem.Components.Tank;
import processing.core.PApplet;

public class RegularInvader extends Invader {

    public RegularInvader(int x, int y, PApplet parent) {
        super(".png", x, y, parent);
    }

    public int hasBeenShot(Tank tank, int tankProjectileCount) {
        if ((doesExist()) && (getX() <= tank.getProjectiles().get(tankProjectileCount).getX()) && (tank.getProjectiles().get(tankProjectileCount).getX() <= getX() + 16) && (getY() <= tank.getProjectiles().get(tankProjectileCount).getY()) && (tank.getProjectiles().get(tankProjectileCount).getY() <= getY() + 16)) {
            return 100;
        }
        return 0;
    }

}
