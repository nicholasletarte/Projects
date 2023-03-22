/******
 Name: Michael Swartz & Nicholas Letarte
 Assignment: Creative Lab
 Date: 10/31/2022
 ******/


//Mike and Nicks super cool creative project
//Character abstract class
//will be used to create heros and villains for arena

import java.util.Random;

abstract public class Character {
    final int strength;
    final String name;
    int hitPoints;
    boolean isAlive;

    //parameters that make up all characters
    public Character(int strength, int hitPoints, String name) {
        this.strength = strength;
        this.hitPoints = hitPoints;
        this.name = name;
        this.isAlive = true;
    }

    //regular attack method without weapon
    int attack() {
        Random rand = new Random();
        return rand.nextInt(0, this.strength + 1);
    }
    //characters hp reduced
    public void reduceHitPoints(int difference) {
        hitPoints -= difference;
        if (hitPoints <= 0) {
            isAlive = false;
            hitPoints = 0;
        }

    }

    public String getName() {
        return name;
    }

}
