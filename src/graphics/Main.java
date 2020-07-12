package graphics;

import processing.core.PApplet;
import resources.Images;
import entities.actors.heroes.*;
import entities.actors.enemies.*;
import entities.actors.*;

public class Main extends PApplet {

    Mage maria;
    Enemy saturn;
    float background = 64;

    public void settings() {
        size(1440, 800);
    }

    public void setup() {
        imageMode(CENTER);
        Images.loadImages(this);
        textFont(createFont("fonts/muli.ttf", 32));
        maria = new Maria(width/2, height/2);
        saturn = new Saturn(random(width), random(height));
    }

    public void draw() {
        image(Images.background, width/2, height/2, width, height);

        maria.draw(this);
        maria.go(this);
        maria.act(new Actor[]{saturn});
        saturn.draw(this);
        saturn.go(this);
        saturn.act(new Actor[]{maria});
        ellipse(mouseX, mouseY, 50, 50);
        text("Hello", 10, 30);
    }

    public void mousePressed() {
        background = random(255);
    }

    public static void main(String[] args) {
        String[] processingArgs = {"graphics.Main"};
        Main main = new Main();
        PApplet.runSketch(processingArgs, main);
    }
}