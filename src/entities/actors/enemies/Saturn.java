package entities.actors.enemies;

import entities.actions.Punch;
import entities.actors.Actor;
import graphics.Animation;
import entities.actions.Action;
import resources.Images;

public class Saturn extends Enemy {

    public Saturn(float x, float y) {
        super(x, y, 150, 150, 4, 5, 3, new Animation(Images.saturn, 12, false, true),
                new Action[]{new Punch(x, y, 50, 50, Images.poof[0], 0.01f, (float)(-Math.PI/2),120)});
    }

    @Override
    public Actor[] chooseTargets(Action toExecute, Actor[] actors) {
        Actor[] target = new Actor[1];
        for (Actor a : actors) {
            if (a.getAllegiance() == Actor.HERO) {
                target[0] = a;
                break;
            }
        }
        return target;
    }



    @Override
    public void pos() {

    }

}
