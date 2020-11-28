package invadem.Components.Invaders;

import invadem.Components.Invaders.Invader;
import invadem.Components.Projectile;
import invadem.Components.Tank;
import processing.core.PApplet;

public class ArmouredInvader extends Invader {

    public ArmouredInvader(int x, int y, PApplet parent) {
        super("_armoured.png", x, y, parent);
    }

    public int hasBeenShot(Projectile proj) {
        if (collision(proj)) {
            incrementCount();
            if (getCount() == 3) {
                return 250;
            }
            else {
                proj.destroy();
                return 0;
            }
        }
        return 0;
    }
}
