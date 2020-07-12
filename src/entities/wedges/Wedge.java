package entities.wedges;

import graphics.Animation;

public abstract class Wedge {

    public static enum Wedgekind {
        BASIC,
        STAR,
        BOX
    };

    abstract public Wedgekind getID();

    abstract public float[] getColor();

}
