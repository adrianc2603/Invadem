package invadem;

import processing.core.PApplet;

public class ArmouredInvader extends Invader {

    public ArmouredInvader(int x, int y, PApplet parent) {
        super("_armoured.png", x, y, parent);
    }

    int hasBeenShot(Tank tank, int tankProjectileCount) {
        if ((doesExist()) && (getX() <= tank.getProjectiles().get(tankProjectileCount).getX()) && (tank.getProjectiles().get(tankProjectileCount).getX() <= getX() + 16) && (getY() <= tank.getProjectiles().get(tankProjectileCount).getY()) && (tank.getProjectiles().get(tankProjectileCount).getY() <= getY() + 16)) {
            incrementCount();
            if (getCount() == 3) {
                return 250;
            }
            else {
                tank.getProjectiles().get(tankProjectileCount).destroy();
                return 0;
            }
        }
        return 0;
    }
}
