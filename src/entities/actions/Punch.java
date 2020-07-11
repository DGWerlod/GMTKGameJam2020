package entities.actions;

import entities.actors.Actor;
import processing.core.PApplet;
import processing.core.PImage;

public class Punch extends Action {

    public Punch(float centerX, float centerY, float w, float h,
                 PImage image, float spd, float startingAngle, int activeTime) {
        super(centerX, centerY, w, h, image, spd, startingAngle, activeTime);
    }

    @Override
    public void sendTo(Actor[] targets, float power) {
        if (targets.length != 1) {
            throw new IllegalArgumentException("Punch accepts only one target, but more than one was specified.");
        }
        super.sendTo(targets, power);
    }

    @Override
    public void apply() {
        currentTargets[0].adjustHP((float) -Math.random() * currentPower);
    }

    @Override
    public void draw(PApplet display) {

    }

}
