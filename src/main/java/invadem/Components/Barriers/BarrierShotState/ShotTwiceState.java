package invadem.Components.Barriers.BarrierShotState;

import processing.core.PApplet;
import processing.core.PImage;

public class ShotTwiceState implements ShotState {

    private String imagePathEnding = "3.png";

    @Override
    public PImage getImage(String rootImagePath, PApplet parent) {
        String imagePath = rootImagePath + imagePathEnding;
        return parent.loadImage(imagePath);
    }
}
