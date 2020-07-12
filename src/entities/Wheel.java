package entities;

import entities.wedges.Wedge;
import processing.core.PApplet;

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
    public boolean removeWedge(Wedge.Wedgekind wedgeID) {
        for (Wedge w : wedges) {
            if (w.getID() == wedgeID) {
                wedges.remove(w);
                return true;
            }
        }
        return false;
    }

    public Wedge.Wedgekind spin() {
        return wedges.get((int)(Math.random() * wedges.size())).getID();
    }

    @Override
    public void draw(PApplet display) {
        if (wedges.size() > 0) {
            float[] color;
            float startAngle = (float)(-Math.PI/2);
            float angleIncr = (float)(2*Math.PI/wedges.size());
            for (Wedge wedge : wedges) {
                display.push();
                display.stroke(0);
                color = wedge.getColor();
                display.fill(color[0], color[1], color[2]);
                display.arc(x, y, w, h, startAngle, startAngle+angleIncr, display.PIE);
                startAngle += angleIncr;
                display.pop();
            }
        } else {
            display.push();
            display.noFill();
            display.stroke(0);
            display.ellipse(x,y,w,h);
            display.pop();
        }
    }

    public void translate(float x, float y) {
        this.x = x;
        this.y = y;
    }

}
