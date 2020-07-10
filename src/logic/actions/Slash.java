package logic.actions;

import entities.actors.Actor;

public class Slash implements Action {

    @Override
    public void applyTo(Actor target, float power) {
        target.adjustHP((float) -Math.random() * power);
    }

}
