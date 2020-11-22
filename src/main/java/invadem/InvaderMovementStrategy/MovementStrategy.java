package invadem.InvaderMovementStrategy;

import invadem.Invader;
import processing.core.PApplet;
import processing.core.PImage;

public interface MovementStrategy {
    PImage getImage(String imagePathEnding, PApplet parent);
    void move(Invader invader);
}
