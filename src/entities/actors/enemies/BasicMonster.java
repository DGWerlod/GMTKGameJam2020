package entities.actors.enemies;

import logic.actions.Action;

public class BasicMonster extends Enemy {

    public BasicMonster(float x, float y, float w, float h, float spd, float hp, float power, Action[] attacks) {
        super(x, y, w, h, spd, hp, power, attacks);
    }

    @Override
    public void pos() {

    }

}
