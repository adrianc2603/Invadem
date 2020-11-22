package invadem.Components.Invaders;

import invadem.Components.Invaders.Invader;
import invadem.Components.Tank;
import processing.core.PApplet;

public class PowerInvader extends Invader {

    public PowerInvader(int x, int y, PApplet parent) {
        super("_power.png", x, y, parent);
    }

    public int hasBeenShot(Tank tank, int tankProjectileCount) {
        if ((doesExist()) && (getX() <= tank.getProjectiles().get(tankProjectileCount).getX()) && (tank.getProjectiles().get(tankProjectileCount).getX() <= getX() + 16) && (getY() <= tank.getProjectiles().get(tankProjectileCount).getY()) && (tank.getProjectiles().get(tankProjectileCount).getY() <= getY() + 16)) {
            return 250;
        }
        return 0;
    }
}
