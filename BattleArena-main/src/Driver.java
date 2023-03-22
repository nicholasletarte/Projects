/******
 Name: Michael Swartz & Nicholas Letarte
 Assignment: Creative Lab
 Date: 10/31/2022
 ******/


//Mike and Nicks super cool creative project
//This is the driver where the bloodshed in this simulation occurs

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class Driver {
    public static void getUserWeaponChoice(BattleArena arena, Scanner scan) {
        System.out.println(arena.displayWeapons());
        System.out.println("Please select 1, 2 or 3 for your weapon choice bravest of heroes. ");
        int result = scan.nextInt(); //allows for user input
        if (Set.of(1, 2, 3).contains(result)) {
            System.out.println(arena.setHeroWeapon(result));
        } else {
            //handling in case user tries an input aside from 1,2 or 3
            System.out.println("Not gonna work!");
            getUserWeaponChoice(arena, scan);
        }
    }
    //allows user to select attack
    private static HeroAttack getUserAttackChoice(Scanner scan) {
        System.out.println("""
                Please select what kind of attack to perform:\s
                1 for a regular attack\s
                2 for attack with weapon\s
                3 for a special attack\s
                """
        );
        int input = scan.nextInt();

        //more handling in case wrong input
        if (!(Set.of(1, 2, 3).contains(input))) {
            System.out.println("Not gonna work!");
            return getUserAttackChoice(scan);
        }
        //switch statements that guide how we attack
        return switch (input) {
            case 1 -> HeroAttack.ATTACK;
            case 2 -> HeroAttack.ATTACK_WITH_WEAPON;
            default -> HeroAttack.SPEC_ATTACK_WITH_WEAPON;
        };
    }

    public static void main(String[] args) {
        //list of characters to fight against each other
        LinkedList<Villain> villains = Villain.getVillains();
        LinkedList<Hero> heroes = Hero.getHeroes();
        Weapon[] weaponRack = Weapon.getWeapons();

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Death Dome!\n");
        BattleArena arena = new BattleArena(villains, heroes, weaponRack);
        getUserWeaponChoice(arena, scan);
        System.out.println(arena.getCombatants());

        //while loop to occur while one of arrays is not empty
        while (arena.getHero().isAlive && arena.getVillain().isAlive) {
            System.out.println(arena.fight(getUserAttackChoice(scan)));
        }

        System.out.println("Battle over!");
    }
}
