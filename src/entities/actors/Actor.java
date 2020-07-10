package entities.actors;

import entities.Entity;
import logic.Attack;
import processing.core.PApplet;

public abstract class Actor extends Entity {

    private float spd;
    private float hp;
    private float power;
    private Attack[] attacks;
    private boolean isAlive;

    public Actor(float x, float y, float w, float h, float spd, float hp, float power, Attack[] attacks) {
        super(x, y, w, h);
        this.spd = spd;
        this.hp = hp;
        this.power = power;
        this.attacks = attacks;
        this.isAlive = true;
    }

    public float getSpd() {
        return this.spd;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public void attack(Actor target) {
        int toExecute = (int)(Math.random() * this.attacks.length);
        this.attacks[toExecute].strikeAt(target, this.power);
    }

    public void takeDamage(float amount) {
        this.hp -= amount;
        if (this.hp <= 0) {
            this.isAlive = false;
        }
    }

    abstract public void pos();

    public void go(PApplet display) {
        this.pos();
        super.go(display);
    }

}
