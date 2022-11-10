import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Battle {
    private HeroTeam heroes;
    private MonsterTeam monsters;
    private boolean gameover;
    Scanner in = new Scanner(System.in);

    public Battle(HeroTeam hs, MonsterTeam ms) {
        heroes = hs;
        monsters = ms;
        gameover = false;
    }

    public boolean startBattle() {
        System.out.println("Encountered " + monsters.size() + " monsters!\nBattle start!\n");
        heroes.displayHeroes();
        System.out.println("vs");
        monsters.displayMonsters();
        System.out.println("");

        while (!gameover) {
            heroRounds();
            if (gameover)
                break;
            monsterRound();
        }
        if (heroes.isAllFainted())
            return true;
        return false;
    }

    private void printMenu(Hero next) {
        System.out.println(next.getName() + ", choose an option: ");
        System.out.println("Attack(a)");
        System.out.println("Cast a spell from inventory(s)");
        System.out.println("Use a potion from inventory(p)");
        System.out.println("Equip weapon/armor(e)");
        System.out.println("Display battle info(i)");
    }

    private void heroRound() {
        Hero next = heroes.nextAvailableHero();
        System.out.printf("\n%s's turn!\n", next.getName());

        boolean moveOn = false;
        while (!moveOn) {
            printMenu(next);
            String choice = ErrorControl.StringInput(new String[]{"a", "s", "p", "e", "i"});
            switch (choice) {
                case "a":
                    attack(next);
                    moveOn = true;
                    break;
                case "s":
                    moveOn = spell(next);
                    break;
                case "p":
                    moveOn = potion(next);
                    break;
                case "e":
                    moveOn = equip(next);
                    break;
                case "i":
                    info();
                    moveOn = false;
                    break;
                default:
                    break;
            }
        }
        if (monsters.isAllFainted())
            gameover = true;
    }

    private void heroRounds() {
        for (int i = 0; i < heroes.getUnfaintedIndices().size(); i++) {
            heroRound();
            if (gameover)
                break;
        }
    }

    private void attack(Hero hero) {
        monsters.displayMonsters();
        System.out.println("Which monster would you like to attack?");
        int index = ErrorControl.integerInput(1, monsters.size());
        Monster monster = monsters.getMonster(index);
        if (monster.isFaint()) {
            System.out.println("You attacked a fainted monster! Nothing happened, monster remains fainted");
            return;
        }
        String res = hero.attack(monster);
        System.out.println("You attacked " + monster.getName());
        if (res.equals("dodged")) {
            System.out.println("But the monster dodged your attack!!");
        } else {
            System.out.printf("%s damage dealt!\n", res);
            if (monster.getHP() <= 0) {
                System.out.println("Monster fainted!!");
                monster.setFaint(true);
            }
        }
        System.out.println("");
    }

    private boolean spell(Hero hero) {
        ArrayList<Spell> spells = hero.getInventory().getSpells();
        if (spells.size() == 0) {
            System.out.println("You have no spell in your inventory!!");
            return false;
        }
        for (int i = 0; i < spells.size(); i++) {
            Spell spell = spells.get(i);
            System.out.printf("%d. %s\tdamage: %d\tmana cost: %d\n\n", i + 1, spell.getName(), spell.getDamage(), spell.getMana());
        }
        System.out.println("Pick a spell('0' to quit spell menu): ");
        int pick = ErrorControl.integerInput(0, spells.size());
        if (pick == 0)
            return false;
        Spell s = spells.get(pick - 1);
        hero.getInventory().remove((Item) s);
        System.out.println("");
        monsters.displayMonsters();
        System.out.println("Which monster would like to use spell on?");
        int index = ErrorControl.integerInput(1, monsters.size());
        Monster monster = monsters.getMonster(index);
        if (monster.isFaint()) {
            System.out.println("You attacked a fainted monster! Nothing happened, you wasted a spell!");
            return true;
        } else {
            monster.setHP(monster.getHP() - s.getDamage());
            System.out.printf("Your spell caused %d damages to the monster!\n", s.getDamage());
            if (monster.getHP() <= 0) {
                System.out.println("Monster fainted!!");
                monster.setFaint(true);
            }
            System.out.println("");
        }
        return true;
    }

    private boolean potion(Hero hero) {
        ArrayList<Potion> potions = hero.getInventory().getPotions();
        if (potions.size() == 0) {
            System.out.println("You have no potion!");
            return false;
        }
        System.out.println("Name\tAttribute affected\tattribute increase");
        for (int i = 0; i < potions.size(); i++) {
            Potion p = potions.get(i);
            System.out.printf("%d. %s\t%s\t%d\n", i + 1, p.getName(), p.getAttributesStr(), p.getIncrease());
        }
        System.out.println("\nPick a potion you would like to use('0' to quit potion menu): ");
        int pick = ErrorControl.integerInput(0, potions.size());
        if (pick == 0)
            return false;
        Potion p = potions.get(pick - 1);
        hero.getInventory().remove(p);
        increaseAttributes(hero, p.getAttributes(), p.getIncrease());
        for (String str : p.getAttributes()) {
            System.out.printf("%s increased by %d\n", str, p.getIncrease());
        }
        return true;
    }

    private void increaseAttributes(Hero hero, String[] attributes, int increase) {
        for (String attribute : attributes) {
            switch (attribute) {
                case "Health":
                    hero.setHP(hero.getHP() + increase);
                    break;
                case "Strength":
                    hero.setStrength(hero.getStrength() + increase);
                    break;
                case "Mana":
                    hero.setMana(hero.getMana() + increase);
                    break;
                case "Agility":
                    hero.setAgility(hero.getAgility() + increase);
                    break;
                case "Dexterity":
                    hero.setDexterity(hero.getDexterity() + increase);
                    break;
                default:
                    break;
            }
        }
    }

    private void info() {
        System.out.println("Heroes: ");
        heroes.displayStatistics();
        System.out.println("\nMonsters: ");
        monsters.displayStatistics();
        System.out.println("");
    }

    private boolean equip(Hero hero) {
        ArrayList<Weapon> weapons = hero.getInventory().getWeapons();
        ArrayList<Armor> armors = hero.getInventory().getArmors();
        if (weapons.size() == 0 && armors.size() == 0) {
            System.out.println("You have no weapon nor armor!");
            return false;
        }
        int menuIndex = 1;
        if (weapons.size() != 0) {
            System.out.println("Weapons: ");
            System.out.println("Name\tDamage\tRequired Hands");
            for (int i = 0; i < weapons.size(); i++) {
                Weapon w = weapons.get(i);
                System.out.printf("%d. %s\t%s\t%d\n", menuIndex++, w.getName(), w.getDamage(), w.getHandsValue());
            }
        }
        if (armors.size() != 0) {
            System.out.println("Armors: ");
            System.out.println("Name\tDamage reduced");
            for (int i = 0; i < armors.size(); i++) {
                Armor a = armors.get(i);
                System.out.printf("%d. %s\t%s\t%d\n", menuIndex++, a.getName(), a.getReduce());
            }
        }
        System.out.println("Pick an item to put on: ");
        int pick = ErrorControl.integerInput(1, --menuIndex);
        if (pick <= weapons.size()) {
            pick--;
            hero.equipWeapon(weapons.get(pick));
            System.out.printf("%s equipped!\n\n", weapons.get(pick).getName());
        } else {
            pick -= weapons.size();
            pick--;
            Armor[] armorArr = hero.getArmors();
            boolean full = true;
            int index = 0;
            for (int i = 0; i < armorArr.length; i++) {
                if (armorArr[i] == null) {
                    full = false;
                    index = i;
                }
            }
            if (!full) {
                hero.replaceArmor(index, armors.get(pick));
            } else {
                System.out.println("Your armors are full!\nPick one to replace: ");
                for (int i = 0; i < armorArr.length; i++) {
                    Armor temp = armorArr[i];
                    System.out.printf("%d. %s\tReduced damage: %d\n", i + 1, temp.getName(), temp.getReduce());
                }
                int i = ErrorControl.integerInput(1, armorArr.length);
                hero.replaceArmor(i - 1, armors.get(pick));
            }
        }
        return true;
    }


    private void monsterRound() {
        //each monster randomly attack a hero
        ArrayList<Integer> unfaintedMonsterIndices = monsters.getUnfaintedIndices();
        for (int m : unfaintedMonsterIndices) {
            Monster monster = monsters.getMonster(m + 1);
            ArrayList<Integer> unfaintedHeroIndices = heroes.getUnfaintedIndices();
            Collections.shuffle(unfaintedHeroIndices);
            int index = unfaintedHeroIndices.get(0);
            Hero hero = heroes.getHero(index + 1);
            String res = monster.attack(hero);
            System.out.println("Monster " + monster.getName() + " attacked " + hero.getName());
            if (res.equals("dodged")) {
                System.out.println("But the hero dodged the monster's attack!!");
            } else {
                System.out.printf("%s damage dealt!\n", res);
                if (hero.getHP() <= 0) {
                    System.out.println("Hero fainted!!");
                    hero.setFaint(true);
                }
            }
            if (heroes.isAllFainted()) {
                gameover = true;
                break;
            }
        }


    }

}
