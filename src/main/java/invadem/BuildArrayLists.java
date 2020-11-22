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
        invaders.add(new ArmouredInvader("_armoured.png", 150, 40, parent));
        invaders.add(new ArmouredInvader("_armoured.png", 185, 40, parent));
        invaders.add(new ArmouredInvader("_armoured.png", 220, 40, parent));
        invaders.add(new ArmouredInvader("_armoured.png", 255, 40, parent));
        invaders.add(new ArmouredInvader("_armoured.png", 290, 40, parent));
        invaders.add(new ArmouredInvader("_armoured.png", 325, 40, parent));
        invaders.add(new ArmouredInvader("_armoured.png", 360, 40, parent));
        invaders.add(new ArmouredInvader("_armoured.png", 395, 40, parent));
        invaders.add(new ArmouredInvader("_armoured.png", 430, 40, parent));
        invaders.add(new ArmouredInvader("_armoured.png", 465, 40, parent));

        // Initialise row 2 invaders (Power Invaders)
        invaders.add(new PowerInvader("_power.png", 150, 80, parent));
        invaders.add(new PowerInvader("_power.png", 185, 80, parent));
        invaders.add(new PowerInvader("_power.png", 220, 80, parent));
        invaders.add(new PowerInvader("_power.png", 255, 80, parent));
        invaders.add(new PowerInvader("_power.png", 290, 80, parent));
        invaders.add(new PowerInvader("_power.png", 325, 80, parent));
        invaders.add(new PowerInvader("_power.png", 360, 80, parent));
        invaders.add(new PowerInvader("_power.png", 395, 80, parent));
        invaders.add(new PowerInvader("_power.png", 430, 80, parent));
        invaders.add(new PowerInvader("_power.png", 465, 80, parent));

        // Initialise row 3 invaders
        invaders.add(new RegularInvader(".png", 150, 120, parent));
        invaders.add(new RegularInvader(".png", 185, 120, parent));
        invaders.add(new RegularInvader(".png", 220, 120, parent));
        invaders.add(new RegularInvader(".png", 255, 120, parent));
        invaders.add(new RegularInvader(".png", 290, 120, parent));
        invaders.add(new RegularInvader(".png", 325, 120, parent));
        invaders.add(new RegularInvader(".png", 360, 120, parent));
        invaders.add(new RegularInvader(".png", 395, 120, parent));
        invaders.add(new RegularInvader(".png", 430, 120, parent));
        invaders.add(new RegularInvader(".png", 465, 120, parent));

        // Initialise row 4 invaders
        invaders.add(new RegularInvader(".png", 150, 160, parent));
        invaders.add(new RegularInvader(".png", 185, 160, parent));
        invaders.add(new RegularInvader(".png", 220, 160, parent));
        invaders.add(new RegularInvader(".png", 255, 160, parent));
        invaders.add(new RegularInvader(".png", 290, 160, parent));
        invaders.add(new RegularInvader(".png", 325, 160, parent));
        invaders.add(new RegularInvader(".png", 360, 160, parent));
        invaders.add(new RegularInvader(".png", 395, 160, parent));
        invaders.add(new RegularInvader(".png", 430, 160, parent));
        invaders.add(new RegularInvader(".png", 465, 160, parent));

        return invaders;
    }



}
