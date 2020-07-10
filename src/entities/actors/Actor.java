package entities.actors;

import entities.Entity;
import processing.core.PApplet;

public abstract class Actor extends Entity {

    public Actor(float x, float y, float w, float h) {
        super(x, y, w, h);
    }

    public void attack(Actor target) {

    }

    public void pos() {

    }

    public void go(PApplet display) {
        this.pos();
        super.go(display);
    }

}
