package invadem.LevelBuilder;

import invadem.*;
import invadem.BarrierFactory.*;
import invadem.InvaderFactory.*;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class ConcreteLevelBuilder implements LevelBuilder {

    private Tank tank;
    private List<Barrier> barriers = new ArrayList<>();
    private List<Invader> invaders = new ArrayList<>();

    InvaderFactory invaderFactory = new ConcreteInvaderFactory();
    BarrierFactory barrierFactory = new ConcreteBarrierFactory();

    @Override
    public void buildLevel(PApplet parent) {
        buildBarriers(parent);
        buildInvaders(parent);
        buildTank(parent);
    }

    @Override
    public void buildBarriers(PApplet parent) {

        // Initialise left barriers
        barriers.add(barrierFactory.createBarrier(BarrierFactory.BarrierType.SOLID, 214, 438, parent));
        barriers.add(barrierFactory.createBarrier(BarrierFactory.BarrierType.SOLID, 214, 430, parent));
        barriers.add(barrierFactory.createBarrier(BarrierFactory.BarrierType.LEFT, 214, 422, parent));
        barriers.add(barrierFactory.createBarrier(BarrierFactory.BarrierType.TOP, 222, 422, parent));
        barriers.add(barrierFactory.createBarrier(BarrierFactory.BarrierType.RIGHT, 230, 422, parent));
        barriers.add(barrierFactory.createBarrier(BarrierFactory.BarrierType.SOLID, 230, 430, parent));
        barriers.add(barrierFactory.createBarrier(BarrierFactory.BarrierType.SOLID, 230, 438, parent));

        // Initialise centre barrier
        barriers.add(barrierFactory.createBarrier(BarrierFactory.BarrierType.SOLID, 319, 438, parent));
        barriers.add(barrierFactory.createBarrier(BarrierFactory.BarrierType.SOLID, 319, 430, parent));
        barriers.add(barrierFactory.createBarrier(BarrierFactory.BarrierType.LEFT, 319, 422, parent));
        barriers.add(barrierFactory.createBarrier(BarrierFactory.BarrierType.TOP, 327, 422, parent));
        barriers.add(barrierFactory.createBarrier(BarrierFactory.BarrierType.RIGHT, 335, 422, parent));
        barriers.add(barrierFactory.createBarrier(BarrierFactory.BarrierType.SOLID, 335, 430, parent));
        barriers.add(barrierFactory.createBarrier(BarrierFactory.BarrierType.SOLID, 335, 438, parent));

        // Initialise right barrier
        barriers.add(barrierFactory.createBarrier(BarrierFactory.BarrierType.SOLID, 424, 438, parent));
        barriers.add(barrierFactory.createBarrier(BarrierFactory.BarrierType.SOLID, 424, 430, parent));
        barriers.add(barrierFactory.createBarrier(BarrierFactory.BarrierType.LEFT, 424, 422, parent));
        barriers.add(barrierFactory.createBarrier(BarrierFactory.BarrierType.TOP, 432, 422, parent));
        barriers.add(barrierFactory.createBarrier(BarrierFactory.BarrierType.RIGHT, 440, 422, parent));
        barriers.add(barrierFactory.createBarrier(BarrierFactory.BarrierType.SOLID, 440, 430, parent));
        barriers.add(barrierFactory.createBarrier(BarrierFactory.BarrierType.SOLID, 440, 438, parent));
    }

    @Override
    public void buildInvaders(PApplet parent) {

        // Initialise row 1 invaders (Armoured Invaders)
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.ARMOURED, 150, 40, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.ARMOURED, 185, 40, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.ARMOURED, 220, 40, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.ARMOURED, 255, 40, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.ARMOURED, 290, 40, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.ARMOURED, 325, 40, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.ARMOURED, 360, 40, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.ARMOURED, 395, 40, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.ARMOURED, 430, 40, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.ARMOURED, 465, 40, parent));

        // Initialise row 2 invaders (Power Invaders)
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.POWER, 150, 80, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.POWER, 185, 80, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.POWER, 220, 80, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.POWER, 255, 80, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.POWER, 290, 80, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.POWER, 325, 80, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.POWER, 360, 80, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.POWER, 395, 80, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.POWER, 430, 80, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.POWER, 465, 80, parent));

        // Initialise row 3 invaders
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.REGULAR, 150, 120, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.REGULAR, 185, 120, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.REGULAR, 220, 120, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.REGULAR, 255, 120, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.REGULAR, 290, 120, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.REGULAR, 325, 120, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.REGULAR, 360, 120, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.REGULAR, 395, 120, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.REGULAR, 430, 120, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.REGULAR, 465, 120, parent));

        // Initialise row 4 invaders
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.REGULAR, 150, 160, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.REGULAR, 185, 160, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.REGULAR, 220, 160, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.REGULAR, 255, 160, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.REGULAR, 290, 160, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.REGULAR, 325, 160, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.REGULAR, 360, 160, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.REGULAR, 395, 160, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.REGULAR, 430, 160, parent));
        invaders.add(invaderFactory.createInvader(InvaderFactory.InvaderType.REGULAR, 465, 160, parent));
    }

    @Override
    public void buildTank(PApplet parent) {
        tank = new Tank(parent.loadImage("tank1.png"), 320, 455);
    }

    @Override
    public Level getLevel(PApplet parent, long shootTime, int currentScore, int highScore) {
        return new Level(parent, shootTime, currentScore, highScore, tank, barriers, invaders);
    }
}
