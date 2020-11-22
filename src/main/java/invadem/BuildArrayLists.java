package invadem;

import processing.core.PApplet;

import java.util.ArrayList;

abstract class BuildArrayLists {

    public static ArrayList<Barrier> buildBarriers(PApplet parent) {
        ArrayList<Barrier> barriers = new ArrayList<>();

        // Initialise left barriers
        barriers.add(new Barrier("barrier_solid", 214, 438, parent));
        barriers.add(new Barrier("barrier_solid", 214, 430, parent));
        barriers.add(new Barrier("barrier_left", 214, 422, parent));
        barriers.add(new Barrier("barrier_top", 222, 422, parent));
        barriers.add(new Barrier("barrier_right", 230, 422, parent));
        barriers.add(new Barrier("barrier_solid", 230, 430, parent));
        barriers.add(new Barrier("barrier_solid", 230, 438, parent));

        // Initialise centre barrier
        barriers.add(new Barrier("barrier_solid", 319, 438, parent));
        barriers.add(new Barrier("barrier_solid", 319, 430, parent));
        barriers.add(new Barrier("barrier_left", 319, 422, parent));
        barriers.add(new Barrier("barrier_top", 327, 422, parent));
        barriers.add(new Barrier("barrier_right", 335, 422, parent));
        barriers.add(new Barrier("barrier_solid", 335, 430, parent));
        barriers.add(new Barrier("barrier_solid", 335, 438, parent));

        // Initialise right barrier
        barriers.add(new Barrier("barrier_solid", 424, 438, parent));
        barriers.add(new Barrier("barrier_solid", 424, 430, parent));
        barriers.add(new Barrier("barrier_left", 424, 422, parent));
        barriers.add(new Barrier("barrier_top", 432, 422, parent));
        barriers.add(new Barrier("barrier_right", 440, 422, parent));
        barriers.add(new Barrier("barrier_solid", 440, 430, parent));
        barriers.add(new Barrier("barrier_solid", 440, 438, parent));

        return barriers;
    }

    public static ArrayList<Invader> buildInvaders(PApplet parent) {
        ArrayList<Invader> invaders = new ArrayList<>();

        // Initialise row 1 invaders (Armoured Invaders)
        invaders.add(new ArmouredInvader(parent.loadImage("invader1_armoured.png"), parent.loadImage("invader2_armoured.png"), 150, 40));
        invaders.add(new ArmouredInvader(parent.loadImage("invader1_armoured.png"), parent.loadImage("invader2_armoured.png"),185, 40));
        invaders.add(new ArmouredInvader(parent.loadImage("invader1_armoured.png"), parent.loadImage("invader2_armoured.png"),220, 40));
        invaders.add(new ArmouredInvader(parent.loadImage("invader1_armoured.png"), parent.loadImage("invader2_armoured.png"),255, 40));
        invaders.add(new ArmouredInvader(parent.loadImage("invader1_armoured.png"), parent.loadImage("invader2_armoured.png"),290, 40));
        invaders.add(new ArmouredInvader(parent.loadImage("invader1_armoured.png"), parent.loadImage("invader2_armoured.png"),325, 40));
        invaders.add(new ArmouredInvader(parent.loadImage("invader1_armoured.png"), parent.loadImage("invader2_armoured.png"),360, 40));
        invaders.add(new ArmouredInvader(parent.loadImage("invader1_armoured.png"), parent.loadImage("invader2_armoured.png"),395, 40));
        invaders.add(new ArmouredInvader(parent.loadImage("invader1_armoured.png"), parent.loadImage("invader2_armoured.png"),430, 40));
        invaders.add(new ArmouredInvader(parent.loadImage("invader1_armoured.png"), parent.loadImage("invader2_armoured.png"),465, 40));

        // Initialise row 2 invaders (Power Invaders)
        invaders.add(new PowerInvader(parent.loadImage("invader1_power.png"), parent.loadImage("invader2_power.png"),150, 80));
        invaders.add(new PowerInvader(parent.loadImage("invader1_power.png"), parent.loadImage("invader2_power.png"), 185, 80));
        invaders.add(new PowerInvader(parent.loadImage("invader1_power.png"), parent.loadImage("invader2_power.png"),220, 80));
        invaders.add(new PowerInvader(parent.loadImage("invader1_power.png"), parent.loadImage("invader2_power.png"), 255, 80));
        invaders.add(new PowerInvader(parent.loadImage("invader1_power.png"), parent.loadImage("invader2_power.png"),290, 80));
        invaders.add(new PowerInvader(parent.loadImage("invader1_power.png"), parent.loadImage("invader2_power.png"), 325, 80));
        invaders.add(new PowerInvader(parent.loadImage("invader1_power.png"), parent.loadImage("invader2_power.png"),360, 80));
        invaders.add(new PowerInvader(parent.loadImage("invader1_power.png"), parent.loadImage("invader2_power.png"),395, 80));
        invaders.add(new PowerInvader(parent.loadImage("invader1_power.png"), parent.loadImage("invader2_power.png"),430, 80));
        invaders.add(new PowerInvader(parent.loadImage("invader1_power.png"), parent.loadImage("invader2_power.png"),465, 80));

        // Initialise row 3 invaders
        invaders.add(new RegularInvader(parent.loadImage("invader1.png"), parent.loadImage("invader2.png"),150, 120));
        invaders.add(new RegularInvader(parent.loadImage("invader1.png"), parent.loadImage("invader2.png"),185, 120));
        invaders.add(new RegularInvader(parent.loadImage("invader1.png"), parent.loadImage("invader2.png"),220, 120));
        invaders.add(new RegularInvader(parent.loadImage("invader1.png"), parent.loadImage("invader2.png"),255, 120));
        invaders.add(new RegularInvader(parent.loadImage("invader1.png"), parent.loadImage("invader2.png"),290, 120));
        invaders.add(new RegularInvader(parent.loadImage("invader1.png"),parent.loadImage("invader2.png"), 325, 120));
        invaders.add(new RegularInvader(parent.loadImage("invader1.png"), parent.loadImage("invader2.png"),360, 120));
        invaders.add(new RegularInvader(parent.loadImage("invader1.png"), parent.loadImage("invader2.png"),395, 120));
        invaders.add(new RegularInvader(parent.loadImage("invader1.png"), parent.loadImage("invader2.png"),430, 120));
        invaders.add(new RegularInvader(parent.loadImage("invader1.png"), parent.loadImage("invader2.png"),465, 120));

        // Initialise row 4 invaders
        invaders.add(new RegularInvader(parent.loadImage("invader1.png"), parent.loadImage("invader2.png"),150, 160));
        invaders.add(new RegularInvader(parent.loadImage("invader1.png"), parent.loadImage("invader2.png"), 185, 160));
        invaders.add(new RegularInvader(parent.loadImage("invader1.png"), parent.loadImage("invader2.png"),220, 160));
        invaders.add(new RegularInvader(parent.loadImage("invader1.png"), parent.loadImage("invader2.png"),255, 160));
        invaders.add(new RegularInvader(parent.loadImage("invader1.png"), parent.loadImage("invader2.png"),290, 160));
        invaders.add(new RegularInvader(parent.loadImage("invader1.png"), parent.loadImage("invader2.png"),325, 160));
        invaders.add(new RegularInvader(parent.loadImage("invader1.png"), parent.loadImage("invader2.png"),360, 160));
        invaders.add(new RegularInvader(parent.loadImage("invader1.png"), parent.loadImage("invader2.png"),395, 160));
        invaders.add(new RegularInvader(parent.loadImage("invader1.png"), parent.loadImage("invader2.png"),430, 160));
        invaders.add(new RegularInvader(parent.loadImage("invader1.png"), parent.loadImage("invader2.png"),465, 160));

        return invaders;
    }



}
