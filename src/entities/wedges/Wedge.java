package entities.wedges;

public abstract class Wedge {

    private float[] color = new float[3];

    public static final int BASIC_WEDGE = 0;
    //...

    abstract public int getID();

    public float[] getColor() {
        return color;
    }

}
