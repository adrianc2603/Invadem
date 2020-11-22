package invadem.LevelBuilder;

import invadem.ConcreteLevel;
import invadem.Level;
import processing.core.PApplet;

public class LevelDirector {

    private final LevelBuilder builder;
    private final PApplet parent;
    private final long shootTime;
    private final int currentScore;
    private final int highScore;

    public LevelDirector(LevelBuilder builder, PApplet parent, long shootTime, int currentScore, int highScore) {
        this.builder = builder;
        this.parent = parent;
        this.shootTime = shootTime;
        this.currentScore = currentScore;
        this.highScore = highScore;
    }

    public Level construct() {
        builder.buildLevel(this.parent);
        return builder.getLevel(this.parent, this.shootTime, this.currentScore, this.highScore);
    }
}
