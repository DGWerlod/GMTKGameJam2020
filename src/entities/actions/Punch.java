package entities.actions;

import entities.actors.Actor;
import graphics.Animation;
import processing.core.PApplet;
import processing.core.PImage;
import resources.Images;

public class Punch extends Action {

    public Punch(float centerX, float centerY, float w, float h,
                 PImage image, float spd, float startingAngle, int activeTime) {
        super(centerX, centerY, w, h, image, new Animation(Images.poof, 12, true, true),
                spd, startingAngle, activeTime, new float[]{233f, 160f, 70f}, Actionkind.PUNCH);
    }

    @Override
    public void actOn(Actor[] targets, float power) {
        if (targets.length != 1) {
            throw new IllegalArgumentException(String.format("Punch accepts only one target, but %s were specified.", targets.length));
        }
        super.actOn(targets, power);
    }

    @Override
    public void apply() {
        currentTargets[0].adjustHP((float) -Math.random() * currentPower);
    }

    @Override
    public void draw(PApplet display) {
        super.draw(display);
    }

}
