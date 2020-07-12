package logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LengthFinder {

    public static final String[] FILENAMES = {
            "src/entities/actions/Action.java",
            "src/entities/actions/Punch.java",
            "src/entities/actors/enemies/Saturn.java",
            "src/entities/actors/enemies/Enemy.java",
            "src/entities/actors/heroes/Mage.java",
            "src/entities/actors/heroes/Hero.java",
            "src/entities/actors/npcs/NPC.java",
            "src/entities/wedges/Wedge.java",
            "src/entities/Entity.java",
            "src/entities/Wheel.java",
            "src/graphics/Animation.java",
            "src/graphics/Main.java",
            "src/resources/Images.java",
            "src/logic/Encounter.java"
    };

    public static void main(String[] args) {
        int total = 0;
        for (String s : FILENAMES) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(s));
                while (reader.readLine() != null) {
                    total++;
                }
                reader.close();
            } catch (FileNotFoundException e) {
                System.out.println("Couldn't find " + s);
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Something went wrong with reading/closing " + s);
                e.printStackTrace();
            }
        }
        System.out.println(total + " lines");
    }

}
