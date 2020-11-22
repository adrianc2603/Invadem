package invadem;

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
