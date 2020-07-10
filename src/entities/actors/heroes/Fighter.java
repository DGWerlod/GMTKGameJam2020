package entities.actors.heroes;

import logic.Attack;

public class Fighter extends Hero {

    public Fighter(float x, float y, float w, float h, float spd, float hp, float power, Attack[] attacks) {
        super(x, y, w, h, spd, hp, power, attacks);
    }

    @Override
    public void pos() {

    }

}
