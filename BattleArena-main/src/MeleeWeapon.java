/******
 Name: Michael Swartz & Nicholas Letarte
 Assignment: Creative Lab
 Date: 10/31/2022
 ******/


//Mike and Nicks super cool creative project
// child of abstract weapons class
// Melee type weapon class

import java.util.Random;

public class MeleeWeapon extends Weapon {


    //super constructor
    public MeleeWeapon(String name, int strength, int durability) {
        super(name, strength, durability);
    }

    //from abstract class
    @Override
    public int weaponAttack() {
        if (this.durability <= 0) {
            return 0;
        } else {
            Random rand = new Random();
            this.durability = this.durability - 1;
            return rand.nextInt(1, this.strength);

        }
    }
    //toString in Weapon abstract class

    //works same as WeaponAttack, damage is higher, more durability taken off
    @Override
    public int specAttack() {
        if (this.durability <= 0) {
            return 0;
        } else {
            Random rand = new Random();
            //more durability is lost upon this attack
            this.durability = this.durability - 4;
            return rand.nextInt(25, this.strength + 25);


        }

    }

}
