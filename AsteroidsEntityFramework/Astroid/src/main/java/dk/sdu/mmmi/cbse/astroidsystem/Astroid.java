package dk.sdu.mmmi.cbse.astroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;

import java.util.Random;


public class Astroid extends Entity {
    private final AstroidType type;
    private final int extraPoints;
    private float angle;

    public Astroid(AstroidType type) {
        this.type = type;
        this.extraPoints = new Random().nextInt(3);
        this.angle = (float) Math.random() * (float) Math.random();
    }

    public int getSize() {
        return type.getSize();
    }

    public int getPoints() {
        return type.getPoints() + extraPoints;
    }

    public float getSpeed() {
        return type.getSpeed();
    }

    public int getLife() {
        return type.getLife();
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public float getAngle() {
        return angle;
    }
}
