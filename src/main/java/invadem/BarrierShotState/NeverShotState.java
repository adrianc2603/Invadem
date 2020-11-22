package invadem.BarrierShotState;

import processing.core.PApplet;
import processing.core.PImage;

public class NeverShotState implements ShotState {

    private String imagePathEnding = "1.png";

    @Override
    public PImage getImage(String rootImagePath, PApplet parent) {
        String imagePath = rootImagePath + imagePathEnding;
        return parent.loadImage(imagePath);
    }

}
