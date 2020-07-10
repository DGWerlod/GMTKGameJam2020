package entities.actors.npcs;

import entities.actors.Actor;
import logic.Attack;

public abstract class NPC extends Actor {

    public NPC(float x, float y, float w, float h, float spd, float hp, float power, Attack[] attacks) {
        super(x, y, w, h, spd, hp, power, attacks);
    }

}
