package graphics;

import processing.core.PApplet;
import resources.Images;

public class Main extends PApplet {

    public void settings() {
        size(1800, 902);
    }

    public void setup() {
        Images.loadImages(this);
    }

    public void draw() {
        image(Images.jamLogo, 0, 0);
        ellipse(mouseX, mouseY, 50, 50);
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