package logic.actions;

import entities.actors.Actor;

public class Punch implements Action {

    @Override
    public void applyTo(Actor[] targets, float power) {
        if (targets.length != 1) {
            throw new IllegalArgumentException("Punch accepts only one target, but more than one was specified.");
        }
        targets[0].adjustHP((float) -Math.random() * power);
    }

}
