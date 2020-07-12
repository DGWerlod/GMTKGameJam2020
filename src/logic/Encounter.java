package logic;

import entities.actors.Actor;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Collections;

public class Encounter {

    public static final int VICTORY = 1;
    public static final int ONGOING = 0;
    public static final int DEFEAT = -1;

    int currentIndex;
    ArrayList<Actor> actors;

    public Encounter(ArrayList<Actor> actors) {
        this.currentIndex = 0;
        this.actors = actors;
        this.prepareTurnOrder();
    }

    public int getNumActors() {
        return actors.size();
    }

    public void prepareTurnOrder() {
        Collections.sort(actors);
    }

    public int getStatus() {
        int numHeroes = 0;
        int numEnemies = 0;
        for (Actor a : actors) {
            if (a.getAllegiance() == Actor.HERO && a.isAlive()) {
                numHeroes++;
            } else if (a.getAllegiance() == Actor.ENEMY && a.isAlive()) {
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

    public void go(PApplet display, boolean clicked) {

        boolean readyForNextAction = true;
        for (Actor a : actors) {
            if (a.isBeingAttacked()) {
                readyForNextAction = false;
                break;
            }
        }

        Actor now = actors.get(currentIndex);

        if (readyForNextAction) {
            if (now.getAllegiance() == Actor.ENEMY) {
                // randomize action, then...
                // now.act((Actor[]) actors.toArray(), actionToUse);
            } else if (now.getAllegiance() == Actor.HERO && clicked) {
                // spin wheel, then...
                // now.act((Actor[]) actors.toArray(), actionToUse);
            }
            currentIndex++;
            if (currentIndex >= actors.size()) {
                currentIndex = 0;
                this.prepareTurnOrder();
            }
        }

        for (Actor a : actors) {
            if (a.isAlive()) {
                a.go(display);
            }
        }

    }

}
