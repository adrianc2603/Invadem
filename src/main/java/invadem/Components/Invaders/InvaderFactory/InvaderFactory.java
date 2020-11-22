package invadem.Components.Invaders.InvaderFactory;

import invadem.Components.Invaders.Invader;
import processing.core.PApplet;

public interface InvaderFactory {

    public enum InvaderType {
        ARMOURED,
        POWER,
        REGULAR;
    }

    Invader createInvader(InvaderType type, int x, int y, PApplet parent);
}
