package resources;

import processing.core.PApplet;
import processing.core.PImage;

public class Images {

    public static PImage jamLogo;
    public static PImage[] maria = new PImage[10];
    public static PImage[] saturn = new PImage[8];
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


        saturn[0] = display.loadImage("img/saturn/1.png");
        saturn[1] = display.loadImage("img/saturn/2.png");
        saturn[2] = display.loadImage("img/saturn/3.png");
        saturn[3] = saturn[1];
        saturn[4] = saturn[0];
        saturn[5] = display.loadImage("img/saturn/6.png");
        saturn[6] = display.loadImage("img/saturn/7.png");
        saturn[7] = saturn[5];

        jamLogo = display.loadImage("img/jamlogo.png");
        jamLogo.resize(1440, 800);
        poof = display.loadImage("img/attacks/poof.png");
        background = display.loadImage("img/background.png");
        background.resize(1440, 800);
    }

}
