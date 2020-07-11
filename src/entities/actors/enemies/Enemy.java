package entities.actors.enemies;

import entities.actors.Actor;
import graphics.Animation;
import logic.actions.Action;

public abstract class Enemy extends Actor {

    public Enemy(float x, float y, float w, float h, int spd, float hp,
                 float power, Animation currentAnimation, Action[] attacks) {
        super(x, y, w, h, spd, hp, power, currentAnimation, attacks);
    }

    public int getAllegiance() {
        return Actor.ENEMY;
    }

}
