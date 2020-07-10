package entities.actors.npcs;

import entities.actors.Actor;
import logic.actions.Action;

public abstract class NPC extends Actor {

    public NPC(float x, float y, float w, float h, float spd, float hp, float power, Action[] attacks) {
        super(x, y, w, h, spd, hp, power, attacks);
    }

    public int getAllegiance() {
        return Actor.NPC;
    }

}
