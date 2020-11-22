package invadem;

import processing.core.PImage;

class PowerInvader extends Invader {

    PowerInvader(PImage image, PImage image2, int x, int y) {
        super(image, image2, x, y);
    }

    int hasBeenShot(Tank tank, int tankProjectileCount) {
        if ((doesExist()) && (getX() <= tank.getProjectiles().get(tankProjectileCount).getX()) && (tank.getProjectiles().get(tankProjectileCount).getX() <= getX() + 16) && (getY() <= tank.getProjectiles().get(tankProjectileCount).getY()) && (tank.getProjectiles().get(tankProjectileCount).getY() <= getY() + 16)) {
            return 250;
        }
        return 0;
    }
}
