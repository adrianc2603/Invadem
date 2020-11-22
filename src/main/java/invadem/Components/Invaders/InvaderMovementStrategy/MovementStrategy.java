package invadem.Components.Invaders.InvaderMovementStrategy;

import invadem.Components.Invaders.Invader;
import processing.core.PApplet;
import processing.core.PImage;

public interface MovementStrategy {
    PImage getImage(String imagePathEnding, PApplet parent);
    void move(Invader invader);
}
