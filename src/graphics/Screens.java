package graphics;

import processing.core.PApplet;
import processing.core.PFont;
import resources.Images;

public class Screens {

    public static void drawAuthors(PApplet display, PFont large, PFont small) {
        display.push();
        display.textAlign(display.CENTER, display.CENTER);
        display.textFont(large);
        display.text("Created by", (float) display.width / 2, (float) display.height / 2 - 140);
        display.text("Created with", (float) display.width / 2, (float) display.height / 2 + 10);
        display.textFont(small);
        display.text("Daniel DeAnda and Desmond Kamas", (float) display.width / 2, (float) display.height / 2 - 50);
        display.text("Java, Processing 3, Intellij IDEA, and Love", (float) display.width / 2, (float) display.height / 2 + 100);
        display.pop();
    }

    public static void drawJamLogo(PApplet display, PFont small) {
        display.push();
        display.textAlign(display.LEFT, display.TOP);
        display.textFont(small);
        display.text("Created for", 10, 0);
        display.pop();
        display.image(Images.jamLogo, (float) display.width / 2, (float) display.height / 2, (float) display.width * 0.8f, (float) display.height * 0.8f);
    }

    public static void drawSplash(PApplet display, PFont large) {
        display.push();
        display.textAlign(display.CENTER, display.CENTER);
        display.textFont(large);
        display.text("This is the splash screen my dude", (float) display.width / 2, (float) display.height / 2);
        display.pop();
    }

}
