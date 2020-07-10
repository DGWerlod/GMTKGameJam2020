package entities.actors.enemies;

import entities.actors.Actor;
import logic.actions.Action;

public abstract class Enemy extends Actor {

    public Enemy(float x, float y, float w, float h, float spd, float hp, float power, Action[] attacks) {
        super(x, y, w, h, spd, hp, power, attacks);
    }

    public int getAllegiance() {
        return Actor.ENEMY;
    }

}
