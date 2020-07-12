package entities.actors;

import entities.Entity;
import graphics.Animation;
import entities.actions.Action;
import processing.core.PApplet;

public abstract class Actor extends Entity implements Comparable<Actor> {

    public static final int ENEMY = -1;
    public static final int NPC = 0;
    public static final int HERO = 1;

    protected int spd;
    protected float hp;
    protected float hpmax;
    protected float power;
    protected Animation currentAnimation;
    protected Action[] attacks;
    protected boolean isAlive;

    public Actor(float x, float y, float w, float h, int spd, float hp,
                 float power, Animation currentAnimation, Action[] attacks) {
        super(x, y, w, h);
        this.spd = spd;
        this.hp = hp;
        this.hpmax = hp;
        this.power = power;
        this.currentAnimation = currentAnimation;
        this.attacks = attacks;
        this.isAlive = true;
    }

    public float getSpd() {
        return spd;
    }

    public boolean isAlive() {
        return isAlive;
    }

    abstract public int getAllegiance();

    abstract public Actor[] chooseTargets(Action toExecute, Actor[] actors);

    public void act(Actor[] actors) {
        int indexToExecute = (int)(Math.random() * attacks.length);
        Action toExecute = attacks[indexToExecute];
        toExecute.sendTo(chooseTargets(toExecute, actors), power);
    }

    public void adjustHP(float amount) {
        hp += amount;
        if (hp <= 0) {
            isAlive = false;
        }
    }

    abstract public void pos();

    @Override
    public void draw(PApplet display) {
        currentAnimation.draw(display, x, y, w, h);

        // draw hp bars
        display.push();
        display.noStroke();
        display.fill(50,225,100);
        display.beginShape(PApplet.QUAD);
        display.vertex(x-w/2,y+h/2+10);
        display.vertex(x-w/2,y+h/2+15);
        display.vertex(x-w/2 + (w*hp/hpmax),y+h/2+15);
        display.vertex(x-w/2 + (w*hp/hpmax),y+h/2+10);
        display.endShape();
        display.pop();
    }

    @Override
    public void go(PApplet display) {
        this.pos();
        currentAnimation.update();
        super.go(display);
    }

    @Override
    public int compareTo(Actor o) {
        return this.spd - o.spd;
    }

}
