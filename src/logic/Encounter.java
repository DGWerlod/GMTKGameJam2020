package logic;

import entities.actors.Actor;
import processing.core.PApplet;

import java.util.ArrayList;

public class Encounter {

    public static final int VICTORY = 1;
    public static final int ONGOING = 0;
    public static final int DEFEAT = -1;

    int currentIndex;
    ArrayList<Actor> actors;

    public Encounter(ArrayList<Actor> actors) {
        this.currentIndex = 0;
        this.actors = actors;
    }

    public int getNumActors() {
        return actors.size();
    }

    public void nextActor(PApplet display) {
        Actor now = actors.get(currentIndex);
        now.go(display);
        if (now.isAlive()) {
            currentIndex++;
        } else {
            actors.remove(currentIndex);
        }
        if (currentIndex >= actors.size()) {
            currentIndex = 0;
        }
    }

    public int getStatus() {
        int numHeroes = 0;
        int numEnemies = 0;
        for (Actor a : actors) {
            if (a.getAllegiance() == Actor.HERO) {
                numHeroes++;
            } else if (a.getAllegiance() == Actor.ENEMY) {
                numEnemies++;
            }
        }
        if (numHeroes == 0) {
            return VICTORY;
        } else if (numEnemies == 0) {
            return DEFEAT;
        } else {
            return ONGOING;
        }
    }

}
