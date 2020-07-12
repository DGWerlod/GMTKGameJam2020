package entities;

import entities.actions.Action;
import entities.actors.Actor;
import processing.core.PApplet;

public class Wheel extends Entity {

    private final Actor source;
    private Action[] actions;
    private boolean isSpinning;
    private float angleIncrement;
    private float countAcceleration;
    private float countVelocity;
    private float countDisplacement;
    private int choice;

    public Wheel(int x, int y, int w, int h, Actor source) {
        super(x, y, w, h);
        this.source = source;
        this.actions = source.getActions();
        this.isSpinning = true;
        this.choice = (int)(Math.random() * actions.length);
        this.countDisplacement = 0;
        this.countVelocity = 0.25f;
        this.countAcceleration = -0.005f;
    }

    public boolean isSpinning() {
        return isSpinning;
    }

    public Action.Actionkind getSpinResult() {
        return Action.Actionkind.values()[choice];
    }

    public void enforceResult(Actor[] actors) {
        source.act(actors, actions[choice]);
    }

    public void translate(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void doPhysics() {
        if (countVelocity > 0.125) {
            countVelocity += countAcceleration;
        }
        countDisplacement += countVelocity;
        if (countDisplacement > 2 * Math.PI) {
            countDisplacement -= 2 * Math.PI;
        }
        if (countVelocity <= 0.125 && Math.abs(countDisplacement - ((choice + 0.5) * angleIncrement)) < angleIncrement / 8) {
            isSpinning = false;
        }
    }

    @Override
    public void draw(PApplet display) {
        if (actions.length > 0) {
            float[] color;
            float startAngle = (float)(-Math.PI/2 + countDisplacement);
            for (Action a : actions) {
                display.push();
                display.stroke(0);
                color = a.getColor();
                display.fill(color[0], color[1], color[2]);
                display.arc(x, y, w, h, startAngle, startAngle + angleIncrement, display.PIE);
                startAngle += angleIncrement;
                display.pop();
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

    public void go(PApplet display) {
        angleIncrement = (float)(2*Math.PI/actions.length);
        if (actions.length > 0) {
            if (isSpinning) {
                this.doPhysics();
            }
        }
        this.draw(display);
    }

}
