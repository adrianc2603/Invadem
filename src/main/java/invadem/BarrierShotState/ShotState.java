package invadem.BarrierShotState;

import processing.core.PApplet;
import processing.core.PImage;

public interface ShotState {
    PImage getImage(String rootImagePath, PApplet parent);
}
