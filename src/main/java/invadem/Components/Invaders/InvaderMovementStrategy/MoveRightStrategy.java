package invadem.Components.Invaders.InvaderMovementStrategy;

import invadem.Components.Invaders.Invader;
import processing.core.PApplet;
import processing.core.PImage;

public class MoveRightStrategy implements MovementStrategy {

    private String imagePathStart = "invader1";

    public PImage getImage(String imagePathEnding, PApplet parent) {
        String imagePath = imagePathStart + imagePathEnding;
        return parent.loadImage(imagePath);
    }

    public void move(Invader invader) {
        invader.setX(invader.getX() + 1);
    }

}
