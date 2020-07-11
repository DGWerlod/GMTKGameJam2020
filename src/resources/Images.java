package resources;

import processing.core.PApplet;
import processing.core.PImage;

public class Images {

    public static PImage jamLogo;
    public static PImage maria;
    public static PImage saturn;
    public static PImage poof;

    public static void loadImages(PApplet display) {
        jamLogo = display.loadImage("img/jamlogo.png");
        jamLogo.resize(1800, 902);
        maria = display.loadImage("img/cmyk.png");
        saturn = display.loadImage("img/saturn.png");
        poof = display.loadImage("img/poof.png");
    }

}
