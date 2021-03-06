package graphics;

import processing.core.PApplet;
import processing.core.PImage;

public class Animation {

    public static final int ALPHA = 128;

    private PImage[] source;
    private int currentFrame;
    private int updatesPerFrame;
    private int untilNextFrame;
    private boolean isTranslucent;
    private boolean loop;
    private boolean done;

    public Animation(PImage[] source, int updatesPerFrame, boolean makeTranslucent, boolean loop) {
        this.source = source;
        this.currentFrame = 0;
        this.updatesPerFrame = updatesPerFrame;
        this.untilNextFrame = updatesPerFrame;
        this.isTranslucent = makeTranslucent;
        this.loop = loop;
        this.done = false;
    }

    public boolean isDone() {
        return this.done;
    }

    public void draw(PApplet display, float x, float y, float w, float h) {
        if (isTranslucent) {
            display.tint(255, ALPHA);
        }
        display.image(source[currentFrame], x, y, w, h);
        display.noTint();
    }

    public void update() {
        if (!this.done) {
            this.untilNextFrame--;
            if (this.untilNextFrame <= 0) {
                if (this.currentFrame == source.length - 1) {
                    if (!this.loop) {
                        this.done = true;
                        return;
                    } else {
                        this.currentFrame = 0;
                    }
                } else {
                    this.currentFrame++;
                }
                this.untilNextFrame = this.updatesPerFrame;
            }
        }
    }

}
