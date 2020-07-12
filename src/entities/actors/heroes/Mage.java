package entities.actors.heroes;

import entities.actors.Actor;
import graphics.Animation;
import entities.actions.Action;

public class Mage extends Hero {

    public Mage(float x, float y, float w, float h, int spd, float hp,
                float power, Animation currentAnimation, Action[] attacks) {
        super(x, y, w, h, spd, hp, power, currentAnimation, attacks);
    }

    @Override
    public Actor[] chooseTargets(Action toExecute, Actor[] actors) {
        Actor[] target = new Actor[1];
        for (Actor a : actors) {
            if (a.getAllegiance() == Actor.ENEMY) {
                target[0] = a;
                break;
            }
        }
        return target;
    }

    @Override
    public void pos() {

    }

}
