package logic;

import entities.Wheel;
import entities.actors.Actor;
import processing.core.PApplet;
import java.util.Arrays;

public class Encounter {

    public static final int VICTORY = 1;
    public static final int ONGOING = 0;
    public static final int DEFEAT = -1;

    private int currentIndex;
    private Actor[] actors;
    private Wheel wheel;

    public Encounter(Actor[] actors) {
        this.currentIndex = 0;
        this.actors = actors;
        this.prepareTurnOrder();
    }

    public int getNumActors() {
        return actors.length;
    }

    public void prepareTurnOrder() {
        Arrays.sort(actors);
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

    public void go(PApplet display, boolean clicked, boolean held) {

        boolean readyForNextAction = true;
        for (Actor a : actors) {
            if (a.isBeingAttacked()) {
                readyForNextAction = false;
                break;
            }
        }

        Actor now = actors[currentIndex];

        if (wheel == null && readyForNextAction) {
            boolean tookAction = false;
            if (now.getAllegiance() == Actor.ENEMY) {
                // randomize action, then...
                // now.act((Actor[]) actors.toArray(), actionToUse);
                tookAction = true;
            } else if (now.getAllegiance() == Actor.HERO && clicked) {
                wheel = new Wheel(display.mouseX, display.mouseY, 200, 200, now);
                tookAction = true;
            }
            if (tookAction) {
                currentIndex++;
                if (currentIndex >= actors.length) {
                    currentIndex = 0;
                    this.prepareTurnOrder();
                }
            }
        }

//        if (Math.abs(mouseX - maria.getX()) > 5 || Math.abs(mouseY - maria.getY()) > 5) {
//            maria.moveInDir(mouseX - maria.getX(), mouseY - maria.getY());
//        }
        if (wheel != null) {
            wheel.translate(display.mouseX, display.mouseY);
            wheel.go(display);
            if (!wheel.isSpinning()) {
                wheel.enforceResult(actors);
                wheel = null;
            }
        }

        for (Actor a : actors) {
            if (a.isAlive()) {
                a.go(display);
            }
        }

    }

}
