package invadem.InvaderFactory;

import invadem.ArmouredInvader;
import invadem.Invader;
import invadem.PowerInvader;
import invadem.RegularInvader;
import processing.core.PApplet;

public class ConcreteInvaderFactory implements InvaderFactory {

    @Override
    public Invader createInvader(InvaderType type, int x, int y, PApplet parent) {
        switch (type) {
            case ARMOURED:
                return new ArmouredInvader(x, y, parent);
            case POWER:
                return new PowerInvader(x, y, parent);
            case REGULAR:
                return new RegularInvader(x, y, parent);
            default: // Will never get here
                return null;
        }
    }


}
