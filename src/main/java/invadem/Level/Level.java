package invadem.Level;

import invadem.Components.Barriers.Barrier;
import invadem.Components.Invaders.Invader;
import invadem.Components.Projectile;
import invadem.Components.Tank;

import java.util.List;

public interface Level {
    Tank getTank();
    List<Invader> getInvaders();
    List<Barrier> getBarriers();
    List<Projectile> getInvaderProjectiles();
    int getCurrentScore();
    void tick();
    boolean invadersExist();
    boolean invadersReachBarrier();
}
