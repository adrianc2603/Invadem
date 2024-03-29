package invadem.Components.Invaders;

import invadem.Components.Invaders.Invader;
import invadem.Components.Projectile;
import invadem.Components.Tank;
import processing.core.PApplet;

public class RegularInvader extends Invader {

    public RegularInvader(int x, int y, PApplet parent) {
        super(".png", x, y, parent);
    }

    public int hasBeenShot(Projectile proj) {
        if (collision(proj)) {
            return 100;
        }
        return 0;
    }

}
