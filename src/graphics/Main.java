package graphics;

import processing.core.PApplet;
import resources.Images;
import entities.actors.heroes.*;
import entities.actors.enemies.*;
import entities.actors.*;
import entities.Wheel;
import entities.wedges.*;

import static graphics.GAME_STATE.*;

enum GAME_STATE {
    AUTHORS,
    JAM_LOGO,
    SPLASH,
    SELECTION,
    ENCOUNTER,
    VICTORY,
    DEFEAT,
    PAUSE
}

public class Main extends PApplet {

    private Maria maria;
    private Enemy saturn;
    private Wheel wheel;

    private boolean mouseClicked = false;
    private boolean mouseHeld = false;

    private GAME_STATE currentState;

    public void settings() {
        size(1440, 800);
    }

    public void setup() {
        imageMode(CENTER);
        Images.loadImages(this);
        textFont(createFont("fonts/muli.ttf", 32));
        maria = new Maria((float) width / 2, (float) height / 2);
        saturn = new Saturn(random(width), random(height));
        wheel = new Wheel(0, 0, 50, 50);
        wheel.addWedge(new BasicWedge());
        wheel.addWedge(new StarWedge());
        currentState = AUTHORS;
    }

    public void draw() {
        image(Images.background, (float) width / 2, (float) height / 2, width, height);
        switch (currentState) {
            case AUTHORS:
                text("Hello", 10, 30);
                if (mouseClicked) {
                    currentState = JAM_LOGO;
                }
                break;
            case JAM_LOGO:
                image(Images.jamLogo, (float) width / 2, (float) height / 2, width, height);
                if (mouseClicked) {
                    currentState = SPLASH;
                }
                break;
            case SPLASH:
                text("This is the splash screen my dude", 10, 30);
                if (mouseClicked) {
                    currentState = SELECTION;
                }
                break;
            case SELECTION:
                currentState = ENCOUNTER;
                break;
            case ENCOUNTER:
                maria.draw(this);
                maria.go(this);
                maria.act(new Actor[]{saturn});
                if (Math.abs(mouseX - maria.getX()) > 5 || Math.abs(mouseY - maria.getY()) > 5) {
                    maria.moveInDir(mouseX - maria.getX(), mouseY - maria.getY());
                }

                saturn.draw(this);
                saturn.go(this);
                saturn.act(new Actor[]{maria});

                if (mouseHeld) {
                    wheel.translate(mouseX, mouseY);
                    wheel.draw(this);
                }
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

        // reset mouseClicked
        mouseClicked = false;

    }

    public void mousePressed() {
        mouseHeld = true;
    }

    public void mouseReleased() {
        mouseHeld = false;
    }

    public void mouseClicked() {
        mouseClicked = true;
    }

    public static void main(String[] args) {
        String[] processingArgs = {"graphics.Main"};
        Main main = new Main();
        PApplet.runSketch(processingArgs, main);
    }
}