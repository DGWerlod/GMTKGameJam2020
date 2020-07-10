package logic;

import entities.actors.Actor;

public class Slash implements Attack {

    @Override
    public void strikeAt(Actor target, float power) {
        target.takeDamage((float) Math.random() * power);
    }

}
