package graphics;

import processing.core.PApplet;
import resources.Images;

public class Main extends PApplet {

    public void settings() {
        size(1440, 800);
    }

    public void setup() {
        imageMode(CENTER);
        Images.loadImages(this);
        textFont(createFont("fonts/muli.ttf", 32));
    }

    public void draw() {
        image(Images.jamLogo, (float) width / 2, (float) height / 2);
        ellipse(mouseX, mouseY, 50, 50);
        text("Hello", 10, 30);
    }

    public void mousePressed() {
        background(64);
    }

    public static void main(String[] args) {
        String[] processingArgs = {"graphics.Main"};
        Main main = new Main();
        PApplet.runSketch(processingArgs, main);
    }
}