package invadem.Components.Barriers.BarrierFactory;

import invadem.Components.Barriers.*;
import processing.core.PApplet;

public class ConcreteBarrierFactory implements BarrierFactory {

    @Override
    public Barrier createBarrier(BarrierFactory.BarrierType type, int x, int y, PApplet parent) {
        switch (type) {
            case SOLID:
                return new SolidBarrier(x, y, parent);
            case LEFT:
                return new LeftBarrier(x, y, parent);
            case TOP:
                return new TopBarrier(x, y, parent);
            case RIGHT:
                return new RightBarrier(x, y, parent);
            default: // Will never get here
                return null;
        }
    }
}
