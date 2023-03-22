/******
 Name: Michael Swartz & Nicholas Letarte
 Assignment: Creative Lab
 Date: 10/31/2022
 ******/


//Mike and Nicks super cool creative project
//This is how we will pit the heroes and villains against one another
//the functionality of this will be shown in the driver
//We also have our EXTENSION in here. It allows for heroes and villains to get healed under certain circumstances

import java.util.LinkedList;
import java.util.Random;

public class BattleArena {
    //must have random list of heroes and villains to fight and a weapon rack to choose weapons from
    private LinkedList<Hero> heroes;
    private LinkedList<Villain> villains;
    private final Weapon[] weapons;
    private final Random rand = new Random();
    private Villain villain;
    private Hero hero;

    //constructor
    public BattleArena(LinkedList<Villain> villains, LinkedList<Hero> heroes, Weapon[] weapons) {
        this.villains = villains;
        this.heroes = heroes;
        this.weapons = weapons;
        setHero();
        setVillain();
    }
    //setters and getters for heroes and villains
    private void setHero() {
        hero = heroes.remove(rand.nextInt(heroes.size()));
    }

    private void setVillain() {
        villain = villains.remove(rand.nextInt(villains.size()));
    }


    public Villain getVillain() {
        return villain;
    }

    public Hero getHero() {
        return hero;
    }
    //Allows us to see what weapons are at our disposal
    public String displayWeapons() {
        StringBuilder weapons_string = new StringBuilder();
        for (int i = 0; i < weapons.length; i++) {
            weapons_string.append("Weapon " + (i + 1) + ": " + weapons[i].toString());
        }
        return weapons_string.toString();
    }

    public String getCombatants() {
        return hero + " versus " + villain;
    }

    public String setHeroWeapon(int weapon_index) {
        Weapon weapon = weapons[weapon_index - 1];
        hero.setWeapon(weapon);
        return weapon.toString();
    }

    public String fight(HeroAttack heroAttackMethod) {
        StringBuilder output = new StringBuilder();
        output.append(villain.sayStuff());
        //how we determine how hero will attack
        int heroAttack = switch (heroAttackMethod) {
            case ATTACK -> hero.attack();
            case ATTACK_WITH_WEAPON -> hero.attackWithWeapon();
            case SPEC_ATTACK_WITH_WEAPON -> hero.specAttackWithWeapon();
        };
        //Tells us how attack occurred
        output.append(hero.getName() + " attacks! \n" + heroAttack + " damage done.\n");
        villain.reduceHitPoints(heroAttack); //villains hp reduced by heroes attack

        int villainAttack = villain.attack();
        hero.reduceHitPoints(villainAttack);
        output.append(villain.getName() + " attacks! \n" + villainAttack + " damage done.\n");

        output.append("" + hero + villain);
        //EXTENSION - Healing occurs for hero or villain randomly under certain conditions
        // Randomly replenish villains or heroes
        if (rand.nextInt(50) == 1) {
            villains = Villain.getVillains();
        }
        if (rand.nextInt(45) == 1) {
            heroes = Hero.getHeroes();
        }
        //exit phrases if hero/villain dies
        if (!(villain.isAlive)) {
            output.append("\n" + villain.name + " is dead!\n");
            if (villains.size() > 0) {
                setVillain();
                output.append("New villain enters arena: " + villain);
            } else {
                output.append("All villains defeated!\n");
            }
        }
        if (!(hero.isAlive)) {
            output.append("\n" + hero.name + " is dead!\n");
            if (heroes.size() > 0) {
                Weapon weapon = hero.getWeapon();
                setHero();
                hero.setWeapon(weapon);
                output.append("New hero enters arena: " + hero);
            } else {
                output.append("All heroes defeated!\n");
            }

        }

        return output.toString();
    }
}
