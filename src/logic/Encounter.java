package logic;

import entities.actors.Actor;
import processing.core.PApplet;

import java.util.ArrayList;

public class Encounter {

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

}
