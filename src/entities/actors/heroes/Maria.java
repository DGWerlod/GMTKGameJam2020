package entities.actors.heroes;

import entities.actions.Punch;
import graphics.Animation;
import resources.Images;

public class Maria extends Mage {

    public Maria(float x, float y) {
        super(x, y, 100,100, 5, 5, 3, new Animation(Images.maria, 8, false, true),
                new Punch[]{new Punch(x, y, 50, 50, Images.poof[0], 0.01f, (float)(-Math.PI/2),120)});
    }

    public void moveInDir(float xcomp, float ycomp) {
        double length = Math.sqrt(xcomp*xcomp + ycomp*ycomp);
        xcomp *= spd/length;
        ycomp *= spd/length;
        x += xcomp;
        y += ycomp;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
