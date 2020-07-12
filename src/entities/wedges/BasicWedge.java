package entities.wedges;

public class BasicWedge extends Wedge {

    public Wedgekind getID() {
        return Wedgekind.BASIC;
    }

    public float[] getColor() {
        return new float[]{200f, 200f, 200f};
    }
}