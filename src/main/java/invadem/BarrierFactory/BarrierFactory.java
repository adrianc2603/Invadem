package invadem.BarrierFactory;

import invadem.Barrier;
import processing.core.PApplet;

public interface BarrierFactory {

    public enum BarrierType {
        SOLID,
        LEFT,
        TOP,
        RIGHT;
    }

    Barrier createBarrier(BarrierType type, int x, int y, PApplet parent);
}
