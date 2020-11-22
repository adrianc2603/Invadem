package invadem;

import processing.core.PApplet;

class ArmouredInvader extends Invader {

    ArmouredInvader(String rootImagePath, int x, int y, PApplet parent) {
        super(rootImagePath, x, y, parent);
    }

    int hasBeenShot(Tank tank, int tankProjectileCount) {
        if ((doesExist()) && (getX() <= tank.getProjectiles().get(tankProjectileCount).getX()) && (tank.getProjectiles().get(tankProjectileCount).getX() <= getX() + 16) && (getY() <= tank.getProjectiles().get(tankProjectileCount).getY()) && (tank.getProjectiles().get(tankProjectileCount).getY() <= getY() + 16)) {
            if (getCount() == 3) {
                return 250;
            }
            else {
                incrementCount();
                return 0;
            }
        }
        return 0;
    }
}
