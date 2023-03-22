/******
 Name: Michael Swartz & Nicholas Letarte
 Assignment: Creative Lab
 Date: 10/31/2022
 ******/


//Nick and Mikes super cool creative project
//the villain class who will fight the hero class
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
//child class of Character
public class Villain extends Character {

    //constructor using abstract class
    public Villain(int strength, int hitPoints, String name) {
        super(strength, hitPoints, name);
    }
    //linked list to store villains so they can randomly fight in arena
    public static LinkedList<Villain> getVillains() {
        return new LinkedList<>(Arrays.asList(new Villain(10, 50, "Grunt"),
                new Villain(30, 100, "Slenderman"),
                new Villain(45, 60, "Cyclops"),
                new Villain(30, 150, "Kuja")
        ));
    }
    //funny stuff a villain might say before attacking
    public String sayStuff() {
        Random rand = new Random();
        String[] stuff = new String[]{"I'm gonna get you!\n", "I'm dumb!\n", "I wish I weren't stuck in here.\n", "Must we fight?\n", "Are you sure this is safe?\n"};
        return name + " says: " + stuff[rand.nextInt(stuff.length)];

    }

    @Override
    public String toString() {
        return "Villain " + name + ": strength: " + strength + ", hit points: " + hitPoints + "\n";
    }
}
