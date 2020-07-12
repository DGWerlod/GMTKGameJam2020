package entities.wedges;

public class StarWedge extends Wedge {

    public Wedgekind getID() {
        return Wedgekind.STAR;
    }

    public float[] getColor() {
        return new float[]{233f, 160f, 70f};
    }
}
