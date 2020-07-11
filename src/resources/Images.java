package resources;

import processing.core.PApplet;
import processing.core.PImage;

public class Images {

    public static PImage jamLogo;

    public static void loadImages(PApplet display) {
        jamLogo = display.loadImage("img/jamlogo.png");
    }

}
