package invadem.Components.Barriers.BarrierShotState;

import processing.core.PApplet;
import processing.core.PImage;

public interface ShotState {
    PImage getImage(String rootImagePath, PApplet parent);
}
