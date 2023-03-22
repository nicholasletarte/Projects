/******
 Name: Michael Swartz & Nicholas Letarte
 Assignment: Creative Lab
 Date: 10/31/2022
 ******/


//Mike and Nicks super cool creative project
// child of abstract weapons class
//Magic type weapon class


import java.util.Random;

public class MagicWeapon extends Weapon {

    Hero hero;

    //Hero object added to constructor to access mana from Hero class
    public MagicWeapon(String name, int strength, int durability) {
        super(name, strength, durability);
    }

    public void setHero(Hero h) {
        this.hero = h;
    }

    @Override
    public int weaponAttack() {
        if (this.hero.getMana() <= 0) {
            this.hero.setMana(0);
            return 0;
        } else {
            Random rand = new Random();
            if (this.hero.getMana()<2){return 0;}
            this.hero.setMana(this.hero.getMana() - 2);
            return rand.nextInt(15, 50);

        }
    }

    //works same as WeaponAttack, damage is higher
    @Override
    public int specAttack() {
        if (this.hero.getMana() <= 0) {
            this.hero.setMana(0);
            return 0;
        } else {
            Random rand = new Random();
            if (this.hero.getMana()<8){return 0;}
            this.hero.setMana(this.hero.getMana() - 8);
            return rand.nextInt(25, 75);
        }
    }
}
