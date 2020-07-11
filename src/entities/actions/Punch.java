package entities.actions;

import entities.actors.Actor;
import processing.core.PApplet;

public class Punch extends Action {

    public Punch(float x, float y, float w, float h, float spd, float startingAngle) {
        super(x, y, w, h, spd, startingAngle);
    }

    @Override
    public void applyTo(Actor[] targets, float power) {
        if (targets.length != 1) {
            throw new IllegalArgumentException("Punch accepts only one target, but more than one was specified.");
        }
        targets[0].adjustHP((float) -Math.random() * power);
    }

    @Override
    public void draw(PApplet display) {

    }

}
