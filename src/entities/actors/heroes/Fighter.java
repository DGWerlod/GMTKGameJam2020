package entities.actors.heroes;

import logic.actions.Action;

public class Fighter extends Hero {

    public Fighter(float x, float y, float w, float h, float spd, float hp, float power, Action[] attacks) {
        super(x, y, w, h, spd, hp, power, attacks);
    }

    @Override
    public void pos() {

    }

}
