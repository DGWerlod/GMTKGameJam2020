package logic.actions;

import entities.actors.Actor;

public interface Action {

    void applyTo(Actor target, float power);

}
