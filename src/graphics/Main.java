package graphics;

import processing.core.PApplet;
import resources.Images;
import entities.actors.heroes.*;
import entities.actors.enemies.*;
import entities.actors.*;
import entities.Wheel;
import entities.wedges.*;

public class Main extends PApplet {

    Maria maria;
    Enemy saturn;
    Wheel wheel;

    boolean clicking = false;

    public void settings() {
        size(1440, 800);
    }

    public void setup() {
        imageMode(CENTER);
        Images.loadImages(this);
        textFont(createFont("fonts/muli.ttf", 32));
        maria = new Maria(width/2, height/2);
        saturn = new Saturn(random(width), random(height));
        wheel = new Wheel(0, 0, 50, 50);
        wheel.addWedge(new BasicWedge());
        wheel.addWedge(new StarWedge());
    }

    public void draw() {
        image(Images.background, width/2, height/2, width, height);

        maria.draw(this);
        maria.go(this);
        maria.act(new Actor[]{saturn});
        if (Math.abs(mouseX - maria.getX()) > 5 || Math.abs(mouseY - maria.getY()) > 5) {
            maria.moveInDir(mouseX - maria.getX(), mouseY - maria.getY());
        }

        saturn.draw(this);
        saturn.go(this);
        saturn.act(new Actor[]{maria});

        if (clicking) {
            wheel.translate(mouseX, mouseY);
            wheel.draw(this);
        }

        text("Hello", 10, 30);
    }

    public void mousePressed() {
        clicking = true;

    }

    public void mouseReleased() {
        clicking = false;
    }

    public static void main(String[] args) {
        String[] processingArgs = {"graphics.Main"};
        Main main = new Main();
        PApplet.runSketch(processingArgs, main);
    }
}