package invadem.InvaderMovementStrategy;

import invadem.Invader;
import processing.core.PApplet;
import processing.core.PImage;

public class MoveDownStrategy implements MovementStrategy {

    private String imagePathStart = "invader2";

    public PImage getImage(String imagePathEnding, PApplet parent) {
        String imagePath = imagePathStart + imagePathEnding;
        return parent.loadImage(imagePath);
    }

    public void move(Invader invader) {
        invader.setY(invader.getY() + 1);
    }

}
