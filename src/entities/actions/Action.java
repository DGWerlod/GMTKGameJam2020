package entities.actions;

import entities.Entity;
import entities.actors.Actor;
import graphics.Animation;
import processing.core.PApplet;

public abstract class Action extends Entity {

    public static final float CLOSE_ORBIT_RADIUS = 0;
    public static final float FAR_ORBIT_RADIUS = 0;

    protected float centerX;
    protected float centerY;
    protected float spd;
    protected float currentAngle;
    protected float currentOrbitRadius;
    protected Animation currentAnimation;

    public Action(float centerX, float centerY, float w, float h, float spd, float startingAngle) {
        super(0, 0, w, h); // x and y are filled in later
        this.centerX = centerX;
        this.centerY = centerY;
        this.spd = spd;
        this.currentAngle = startingAngle;
        this.currentOrbitRadius = FAR_ORBIT_RADIUS;
        this.pos();
    }

    abstract public void applyTo(Actor[] targets, float power);

    public void pos() {
        x = (float) (centerX + this.currentOrbitRadius * Math.cos(currentAngle));
        y = (float) (centerY + this.currentOrbitRadius * Math.sin(currentAngle));
    }

    @Override
    public void go(PApplet display) {
        currentAngle += spd;
        currentAngle %= 2 * Math.PI;
        this.pos();
        super.go(display);
    }

}
