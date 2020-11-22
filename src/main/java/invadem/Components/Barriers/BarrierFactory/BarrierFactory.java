package invadem.Components.Barriers.BarrierFactory;

import invadem.Components.Barriers.Barrier;
import processing.core.PApplet;

public interface BarrierFactory {

    enum BarrierType {
        SOLID,
        LEFT,
        TOP,
        RIGHT;
    }

    Barrier createBarrier(BarrierType type, int x, int y, PApplet parent);
}
