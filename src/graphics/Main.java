package graphics;

import entities.actors.enemies.Saturn;
import entities.actors.heroes.Maria;
import logic.Encounter;
import processing.core.PApplet;
import processing.core.PFont;
import resources.Images;
import entities.actors.Actor;

import java.util.ArrayList;

public class Main extends PApplet {

    public static final int AUTHORS = 0;
    public static final int JAM_LOGO = 1;
    public static final int SPLASH = 2;
    public static final int SELECTION = 3;
    public static final int ENCOUNTER = 4;
    public static final int VICTORY = 5;
    public static final int DEFEAT = 6;
    public static final int PAUSE = 7;

    private boolean mouseClicked = false;
    private boolean mouseHeld = false;

    private PFont SMALL;
    private PFont LARGE;

    private int currentState;
    private Encounter currentEncounter;

    public void settings() {
        size(1440, 800);
    }

    public void setup() {
        imageMode(CENTER);
        Images.loadImages(this);
        SMALL = createFont("fonts/muli.ttf", 30);
        LARGE = createFont("fonts/muli.ttf", 70);
        currentState = AUTHORS;
    }

    public void draw() {
        image(Images.background, (float) width / 2, (float) height / 2, width, height);
        switch (currentState) {
            case AUTHORS:
                Screens.drawAuthors(this, LARGE, SMALL);
                break;
            case JAM_LOGO:
                Screens.drawJamLogo(this, SMALL);
                break;
            case SPLASH:
                Screens.drawSplash(this, LARGE);
                break;
            case SELECTION:
                // Begin in-place setup
                Actor[] actors = new Actor[] {
                        new Maria((float) width / 2, (float) height / 2),
                        new Saturn(random(width), random(height))
                };
                // End in-place setup
                currentEncounter = new Encounter(actors); // change to selection later
                currentState = ENCOUNTER;
                break;
            case ENCOUNTER:
                currentEncounter.go(this, mouseClicked, mouseHeld);
                break;
            case VICTORY:
                break;
            case DEFEAT:
                break;
            case PAUSE:
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + currentState);
        }

        if (mouseClicked && currentState <= SPLASH) {
            currentState++;
        }

        // reset mouseClicked
        mouseClicked = false;

    }

    public void mousePressed() {
        mouseClicked = true;
        mouseHeld = true;
    }

    public void mouseReleased() {
        mouseHeld = false;
    }

    public static void main(String[] args) {
        String[] processingArgs = {"graphics.Main"};
        Main main = new Main();
        PApplet.runSketch(processingArgs, main);
    }
}