package invadem;

import processing.core.PApplet;

import java.util.ArrayList;

abstract class BuildArrayLists {

    public static ArrayList<Barrier> buildBarriers(PApplet parent) {
        ArrayList<Barrier> barriers = new ArrayList<>();

        // Initialise left barriers
        barriers.add(new Barrier(parent.loadImage("barrier_solid1.png"), parent.loadImage("barrier_solid2.png"), parent.loadImage("barrier_solid3.png"), 214, 438 ));
        barriers.add(new Barrier(parent.loadImage("barrier_solid1.png"), parent.loadImage("barrier_solid2.png"), parent.loadImage("barrier_solid3.png"), 214, 430 ));
        barriers.add(new Barrier(parent.loadImage("barrier_left1.png"), parent.loadImage("barrier_left2.png"), parent.loadImage("barrier_left3.png"), 214, 422));
        barriers.add(new Barrier(parent.loadImage("barrier_top1.png"), parent.loadImage("barrier_top2.png"), parent.loadImage("barrier_top3.png"),222, 422));
        barriers.add(new Barrier(parent.loadImage("barrier_right1.png"), parent.loadImage("barrier_right2.png"), parent.loadImage("barrier_right3.png"), 230, 422));
        barriers.add(new Barrier(parent.loadImage("barrier_solid1.png"), parent.loadImage("barrier_solid2.png"), parent.loadImage("barrier_solid3.png"),230, 430 ));
        barriers.add(new Barrier(parent.loadImage("barrier_solid1.png"), parent.loadImage("barrier_solid2.png"), parent.loadImage("barrier_solid3.png"),230, 438 ));

        // Initialise centre barrier
        barriers.add(new Barrier(parent.loadImage("barrier_solid1.png"), parent.loadImage("barrier_solid2.png"), parent.loadImage("barrier_solid3.png"),319, 438 ));
        barriers.add(new Barrier(parent.loadImage("barrier_solid1.png"), parent.loadImage("barrier_solid2.png"), parent.loadImage("barrier_solid3.png"),319, 430 ));
        barriers.add(new Barrier(parent.loadImage("barrier_left1.png"), parent.loadImage("barrier_left2.png"), parent.loadImage("barrier_left3.png"),319, 422));
        barriers.add(new Barrier(parent.loadImage("barrier_top1.png"), parent.loadImage("barrier_top2.png"), parent.loadImage("barrier_top3.png"), 327, 422));
        barriers.add(new Barrier(parent.loadImage("barrier_right1.png"), parent.loadImage("barrier_right2.png"), parent.loadImage("barrier_right3.png"), 335, 422));
        barriers.add(new Barrier(parent.loadImage("barrier_solid1.png"), parent.loadImage("barrier_solid2.png"), parent.loadImage("barrier_solid3.png"),335, 430 ));
        barriers.add(new Barrier(parent.loadImage("barrier_solid1.png"), parent.loadImage("barrier_solid2.png"), parent.loadImage("barrier_solid3.png"),335, 438 ));

        // Initialise right barrier
        barriers.add(new Barrier(parent.loadImage("barrier_solid1.png"), parent.loadImage("barrier_solid2.png"), parent.loadImage("barrier_solid3.png"),424, 438 ));
        barriers.add(new Barrier(parent.loadImage("barrier_solid1.png"), parent.loadImage("barrier_solid2.png"), parent.loadImage("barrier_solid3.png"),424, 430 ));
        barriers.add(new Barrier(parent.loadImage("barrier_left1.png"), parent.loadImage("barrier_left2.png"), parent.loadImage("barrier_left3.png"),424, 422));
        barriers.add(new Barrier(parent.loadImage("barrier_top1.png"), parent.loadImage("barrier_top2.png"), parent.loadImage("barrier_top3.png"), 432, 422));
        barriers.add(new Barrier(parent.loadImage("barrier_right1.png"), parent.loadImage("barrier_right2.png"), parent.loadImage("barrier_right3.png"), 440, 422));
        barriers.add(new Barrier(parent.loadImage("barrier_solid1.png"), parent.loadImage("barrier_solid2.png"), parent.loadImage("barrier_solid3.png"),440, 430 ));
        barriers.add(new Barrier(parent.loadImage("barrier_solid1.png"), parent.loadImage("barrier_solid2.png"), parent.loadImage("barrier_solid3.png"),440, 438 ));

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
