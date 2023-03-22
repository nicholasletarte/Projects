/******
 Name: Michael Swartz & Nicholas Letarte
 Assignment: Creative Lab
 Date: 10/31/2022
 ******/


/**
 * Nick and Mikes super cool creative project
 * Making an abstract Weapon class
 */


public abstract class Weapon {
    //abstract methods
    int durability;
    String name;
    int strength;

    //constructor
    public Weapon(String name, int strength, int durability) {
        this.name = name;
        this.strength = strength;
        this.durability = durability; //maybe use this in melee and range classes? magic will not use it
    }
    //list of weapons for battle arena
    public static Weapon[] getWeapons() {
        return new Weapon[]{new MagicWeapon("Plastic Wand", 10, 0),
                new RangedWeapon("Nerf Gun", 15, 10),
                new MeleeWeapon("Katana", 25, 10),};
    }

    //ABSTRACT METHODS
    //attacking with weapon
    // make it abstract. Melee and Ranged should use same implementation and magic should differ
    public abstract int weaponAttack();

    //melee, range and magic will have to implement their own
    public abstract int specAttack();


    public String toString() {
        return name + ", "
                + strength + " strength.";
    }
}