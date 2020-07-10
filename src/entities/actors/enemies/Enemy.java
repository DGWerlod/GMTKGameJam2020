package entities.actors.enemies;

import entities.actors.Actor;
import logic.Attack;

public abstract class Enemy extends Actor {

    public Enemy(float x, float y, float w, float h, float spd, float hp, float power, Attack[] attacks) {
        super(x, y, w, h, spd, hp, power, attacks);
    }

}
