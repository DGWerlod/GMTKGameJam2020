package entities;

import processing.core.PApplet;

public abstract class Entity {

    protected float x, y, w, h;

    public Entity(float x, float y, float w, float h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    abstract public void draw(PApplet display);

    public void go(PApplet display) {
        this.draw(display);
    }

}
