package invadem.Components.Invaders;

import invadem.Components.Invaders.Invader;
import invadem.Components.Projectile;
import invadem.Components.Tank;
import processing.core.PApplet;

public class PowerInvader extends Invader {

    public PowerInvader(int x, int y, PApplet parent) {
        super("_power.png", x, y, parent);
    }

    public int hasBeenShot(Projectile proj) {
        if ((doesExist()) && (getX() <= proj.getX()) && (proj.getX() <= getX() + getWidth()) && (getY() <= proj.getY()) && (proj.getY() <= getY() + getHeight())) {
            return 250;
        }
        return 0;
    }
}
