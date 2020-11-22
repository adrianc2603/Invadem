package invadem.Level;

import processing.core.PApplet;

public interface LevelBuilder {
    void buildLevel(PApplet parent);
    void buildBarriers(PApplet parent);
    void buildInvaders(PApplet parent);
    void buildTank(PApplet parent);
    Level getLevel(PApplet parent, long shootTime, int currentScore, int highScore);
}
