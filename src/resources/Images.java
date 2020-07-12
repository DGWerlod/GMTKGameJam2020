package resources;

import processing.core.PApplet;
import processing.core.PImage;

public class Images {

    public static PImage jamLogo;
    public static PImage[] maria = new PImage[10];
    public static PImage saturn;
    public static PImage poof;
    public static PImage background;

    public static void loadImages(PApplet display) {
        // load in maria
        maria[0] = display.loadImage("img/maria/1.png");
        maria[1] = display.loadImage("img/maria/2.png");
        maria[2] = display.loadImage("img/maria/3.png");
        maria[3] = display.loadImage("img/maria/4.png");
        maria[4] = maria[2];
        maria[5] = maria[1];
        maria[6] = maria[0];
        maria[7] = display.loadImage("img/maria/8.png");
        maria[8] = display.loadImage("img/maria/9.png");
        maria[9] = maria[7];

        jamLogo = display.loadImage("img/jamlogo.png");
        jamLogo.resize(1440, 800);
        saturn = display.loadImage("img/saturn.png");
        poof = display.loadImage("img/poof.png");
        background = display.loadImage("img/jamlogo.png");
        background.resize(1440, 800);
    }

}
