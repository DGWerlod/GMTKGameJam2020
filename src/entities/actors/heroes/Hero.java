package entities.actors.heroes;

import entities.actors.Actor;
import graphics.Animation;
import entities.actions.Action;

public abstract class Hero extends Actor {

    public Hero(float x, float y, float w, float h, int spd, float hp,
                float power, Animation currentAnimation, Action[] attacks) {
        super(x, y, w, h, spd, hp, power, currentAnimation, attacks);
    }

    public int getAllegiance() {
        return Actor.HERO;
    }

}
