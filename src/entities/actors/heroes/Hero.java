package entities.actors.heroes;

import entities.actors.Actor;
import logic.actions.Action;

public abstract class Hero extends Actor {

    public Hero(float x, float y, float w, float h, float spd, float hp, float power, Action[] attacks) {
        super(x, y, w, h, spd, hp, power, attacks);
    }

    public int getAllegiance() {
        return Actor.HERO;
    }

}
