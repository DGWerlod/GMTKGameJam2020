package entities;

import entities.actions.Action;
import processing.core.PApplet;

import java.util.ArrayList;

public class Wheel extends Entity {

    private ArrayList<Action> actions;
    private boolean isSpinning;
    private float countacc;
    private float countvel;
    private float countdisp;
    private int choice;

    public Wheel(int x, int y, int w, int h) {
        super(x, y, w, h);
        this.actions = new ArrayList<>();
    }

    public Wheel(int x, int y, int w, int h, ArrayList<Action> actions) {
        super(x, y, w, h);
        this.actions = actions;
        isSpinning = false;
        countacc = 0;
        countvel = 0;
        countdisp = 0;
        choice = 0;
    }

    public void addWedge(Action toAdd) {
        actions.add(toAdd);
    }

    // True if successful, false if not (b/c not present on wheel)
    public boolean removeWedge(Action.Actionkind actionID) {
        for (int i = 0; i < actions.size(); i++) {
            if (actions.get(i).getId() == actionID) {
                actions.remove(i);
                return true;
            }
        }
        return false;
    }

    public void beginSpin() {
        isSpinning = true;
        choice = (int)(Math.random() * actions.size());
        countdisp = 0;
        countvel = 0.25f;
        countacc = -0.005f;
    }

    public boolean isSpinning() {
        return isSpinning;
    }

    public Action.Actionkind getSpinResult() {
        return Action.Actionkind.values()[choice];
    }

    @Override
    public void draw(PApplet display) {
        if (actions.size() > 0) {
            float[] color;
            float angleIncr = (float)(2*Math.PI/actions.size());
            float startAngle = (float)(-Math.PI/2 + countdisp);
            for (Action atn : actions) {
                display.push();
                display.stroke(0);
                color = atn.getColor();
                display.fill(color[0], color[1], color[2]);
                display.arc(x, y, w, h, startAngle, startAngle+angleIncr, display.PIE);
                startAngle += angleIncr;
                display.pop();
            }
            if (isSpinning) {
                if (countvel > 0.125) {
                    countvel += countacc;
                }
                countdisp += countvel;
                if (countdisp > 2 * Math.PI) {
                    countdisp -= 2 * Math.PI;
                }
                if (countvel <= 0.125 && Math.abs(countdisp - ((choice + 0.5) * angleIncr)) < angleIncr / 8) {
                    isSpinning = false;
                }
            }
        } else {
            display.push();
            display.noFill();
            display.stroke(0);
            display.ellipse(x,y,w,h);
            display.pop();
        }

        // draw the arrow of designation
        display.push();
        display.noStroke();
        display.fill(250,50,50);
        display.beginShape();
        display.vertex(x, y-h/4);
        display.vertex(x-5, y-h/2-5);
        display.vertex(x+5, y-h/2-5);
        display.endShape();
        display.pop();
    }

    public void translate(float x, float y) {
        this.x = x;
        this.y = y;
    }

}
