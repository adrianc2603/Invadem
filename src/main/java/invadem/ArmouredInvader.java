package invadem;

import processing.core.PImage;

class ArmouredInvader extends Invader {

    ArmouredInvader(PImage image, PImage image2, int x, int y) {
        super(image, image2, x, y);
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
