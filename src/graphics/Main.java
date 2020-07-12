package graphics;

import processing.core.PApplet;
import resources.Images;
import entities.actors.heroes.*;

public class Main extends PApplet {

    Mage maria;
    float background = 64;

    public void settings() {
        size(1440, 800);
    }

    public void setup() {
        imageMode(CENTER);
        Images.loadImages(this);
        textFont(createFont("fonts/muli.ttf", 32));
        maria = new Maria(width/2, height/2);
    }

    public void draw() {
        background(background);
        maria.draw(this);
        maria.go(this);
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