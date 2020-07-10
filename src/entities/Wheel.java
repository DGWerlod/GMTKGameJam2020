package entities;

import entities.wedges.Wedge;

import java.util.ArrayList;

public class Wheel extends Entity {

    private ArrayList<Wedge> wedges;

    public Wheel(int x, int y, int w, int h) {
        super(x, y, w, h);
        this.wedges = new ArrayList<>();
    }

    public Wheel(int x, int y, int w, int h, ArrayList<Wedge> wedges) {
        super(x, y, w, h);
        this.wedges = wedges;
    }

    public void addWedge(Wedge toAdd) {
        wedges.add(toAdd);
    }

    // True if successful, false if not (b/c not present on wheel)
    public boolean removeWedge(int wedgeID) {
        for (Wedge w : wedges) {
            if (w.getID() == wedgeID) {
                wedges.remove(w);
                return true;
            }
        }
        return false;
    }

    public int spin() {
        return wedges.get((int)(Math.random() * wedges.size())).getID();
    }

}
