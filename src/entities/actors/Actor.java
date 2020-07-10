package entities.actors;

import entities.Entity;
import logic.actions.Action;
import processing.core.PApplet;

public abstract class Actor extends Entity {

    public static final int ENEMY = -1;
    public static final int NPC = 0;
    public static final int HERO = 1;

    protected float spd;
    protected float hp;
    protected float power;
    protected Action[] attacks;
    protected boolean isAlive;

    public Actor(float x, float y, float w, float h, float spd, float hp, float power, Action[] attacks) {
        super(x, y, w, h);
        this.spd = spd;
        this.hp = hp;
        this.power = power;
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

    public void attack(Actor target) {
        int toExecute = (int)(Math.random() * attacks.length);
        attacks[toExecute].applyTo(target, power);
    }

    public void adjustHP(float amount) {
        hp += amount;
        if (hp <= 0) {
            isAlive = false;
        }
    }

    abstract public void pos();

    public void go(PApplet display) {
        this.pos();
        super.go(display);
    }

}
