package entities.actors.enemies;

import logic.Attack;

public class BasicMonster extends Enemy {

    public BasicMonster(float x, float y, float w, float h, float spd, float hp, float power, Attack[] attacks) {
        super(x, y, w, h, spd, hp, power, attacks);
    }

    @Override
    public void pos() {

    }

}
