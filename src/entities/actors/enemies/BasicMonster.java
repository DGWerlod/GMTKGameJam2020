package entities.actors.enemies;

import entities.actors.Actor;
import graphics.Animation;
import logic.actions.Action;

public class BasicMonster extends Enemy {

    public BasicMonster(float x, float y, float w, float h, int spd, float hp,
                        float power, Animation currentAnimation, Action[] attacks) {
        super(x, y, w, h, spd, hp, power, currentAnimation, attacks);
    }

    @Override
    public Actor[] chooseTargets(Action toExecute, Actor[] actors) {
        return new Actor[0];
    }

    @Override
    public void pos() {

    }

}
