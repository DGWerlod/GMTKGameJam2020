package entities.actions;

import entities.Entity;
import entities.actors.Actor;
import graphics.Animation;
import processing.core.PApplet;
import processing.core.PImage;

public abstract class Action extends Entity {

    public static final float ACTIVE_ORBIT_RADIUS = 30;
    public static final float INACTIVE_ORBIT_RADIUS = 50;

    protected float orbitCenterX;
    protected float orbitCenterY;
    protected float spd;
    protected float currentAngle;
    protected float currentOrbitRadius;
    protected PImage image;
    protected Animation particleEffect;

    protected Actor[] currentTargets;
    protected float currentPower;
    protected int activeTime;
    protected int activeTimeRemaining;

    protected float[] color;

    public enum Actionkind {
        NONE,
        PUNCH,
        STAR,
        BOX
    }

    private final Actionkind id;

    public Action(float orbitCenterX, float orbitCenterY, float w, float h, PImage image,
                  Animation particleEffect, float spd, float startingAngle, int activeTime,
                  float[] color, Actionkind id) {
        super(0, 0, w, h); // x and y are filled in later
        this.orbitCenterX = orbitCenterX;
        this.orbitCenterY = orbitCenterY;
        this.spd = spd;
        this.currentAngle = startingAngle;
        this.currentOrbitRadius = INACTIVE_ORBIT_RADIUS;
        this.image = image;
        this.particleEffect = particleEffect;
        this.activeTime = activeTime;
        this.color = color;
        this.id = id;
        this.pos();
        this.reset();
    }

    public Actionkind getId() {
        return id;
    }

    public float[] getColor() {
        return color;
    }

    public Animation getParticleEffect() {
        return this.particleEffect;
    }

    public void reset() {
        currentTargets = null;
        currentPower = 0;
    }

    public void actOn(Actor[] targets, float power) {
        currentTargets = targets;
        currentPower = power;
        currentOrbitRadius = ACTIVE_ORBIT_RADIUS;
        activeTimeRemaining = activeTime;
        // change animation
    }

    public void sendToTarget() {
        for (Actor a : currentTargets) {
            a.receiveEffect(this);
        }
    }

    abstract public void apply();

    public void pos() {
        x = (float) (orbitCenterX + currentOrbitRadius * Math.cos(currentAngle));
        y = (float) (orbitCenterY + currentOrbitRadius * Math.sin(currentAngle));
    }

    public void setAngle(float angle) {
        this.currentAngle = angle;
    }

    @Override
    public void draw(PApplet display) {
        display.image(image, x, y);
    }

    @Override
    public void go(PApplet display) {
        currentAngle += spd;
        currentAngle %= 2 * Math.PI;
        if (currentOrbitRadius == ACTIVE_ORBIT_RADIUS) {
            activeTimeRemaining--;
            if (activeTimeRemaining <= 0) {
                this.sendToTarget();
                currentOrbitRadius = INACTIVE_ORBIT_RADIUS;
            }
        }
        this.pos();
        super.go(display);
    }

}
