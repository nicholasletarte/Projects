

/******
 Name: Michael Swartz & Nicholas Letarte
 Assignment: Creative Lab
 Date: 10/31/2022
 ******/


//Mike and Nicks super cool creative project
//Hero subclass used to fight villains

import java.util.Arrays;
import java.util.LinkedList;

public class Hero extends Character {
    private int mana;//parameter specifci to hero since villains cannot cast magic

    public Weapon getWeapon() {
        return weapon;
    }

    private Weapon weapon; //instance of Weapon class declared here

    public Hero(int strength, int hitPoints, String name, int mana) {
        super(strength, hitPoints, name);
        this.mana = mana;
        this.weapon = null; //is not holding weapon currently
    }
    //our list of brave heros
    public static LinkedList<Hero> getHeroes() {
        return new LinkedList<>(Arrays.asList(
                new Hero(35, 175, "Francisco", 20),
                new Hero(40, 150, "Gwen Stefani", 30),
                new Hero(50, 50, "RouxBarb", 50)));
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
        if (weapon instanceof MagicWeapon) {
            ((MagicWeapon) weapon).setHero(this);
        }
    }
    //allows ability to attack with weapon
    public int attackWithWeapon() {
        return weapon.weaponAttack();
    }

    public int specAttackWithWeapon() {
        return weapon.specAttack(); //allows for special attack with weapon
    }

    @Override
    public String toString() {
        return "Hero " + name +
                ": mana: " + mana +
                ", strength: " + strength +
                ", hit points: " + hitPoints +
                ", with weapon " + weapon + "\n";
    }
}
