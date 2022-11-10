import java.util.ArrayList;
import java.util.Arrays;

/*
Inventory class is used by Hero and Market to store items. It also includes necessary functions such as sorting.
 */
public class Inventory {
    private ArrayList<Item> inventory;
    private ArrayList<Weapon> weapons;
    private ArrayList<Armor> armors;
    private ArrayList<Potion> potions;
    private ArrayList<FireSpell> fireSpells;
    private ArrayList<IceSpell> iceSpells;
    private ArrayList<LightningSpell> lightningSpells;

    public Inventory() {
        inventory = new ArrayList<>();
        weapons = new ArrayList<>();
        armors = new ArrayList<>();
        potions = new ArrayList<>();
        fireSpells = new ArrayList<>();
        iceSpells = new ArrayList<>();
        lightningSpells = new ArrayList<>();
    }

    public void sortInventory() {
        weapons.clear();
        armors.clear();
        potions.clear();
        fireSpells.clear();
        iceSpells.clear();
        lightningSpells.clear();
        for (Item i : inventory) {
            if (i instanceof Weapon)
                weapons.add((Weapon) i);
            if (i instanceof Armor)
                armors.add((Armor) i);
            if (i instanceof Potion)
                potions.add((Potion) i);
            if (i instanceof FireSpell)
                fireSpells.add((FireSpell) i);
            if (i instanceof IceSpell)
                iceSpells.add((IceSpell) i);
            if (i instanceof LightningSpell)
                lightningSpells.add((LightningSpell) i);
        }
        inventory.clear();
        weapons.forEach(weapon -> {
            inventory.add(weapon);
        });
        armors.forEach(armor -> {
            inventory.add(armor);
        });
        potions.forEach(potion -> {
            inventory.add(potion);
        });
        fireSpells.forEach(fireSpell -> {
            inventory.add(fireSpell);
        });
        iceSpells.forEach(iceSpell -> {
            inventory.add(iceSpell);
        });
        lightningSpells.forEach(lightningSpell -> {
            inventory.add(lightningSpell);
        });
    }

    public ArrayList<Potion> getPotions() {
        return potions;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public ArrayList<Armor> getArmors() {
        return armors;
    }

    public ArrayList<FireSpell> getFireSpells() {
        return fireSpells;
    }

    public ArrayList<LightningSpell> getLightningSpells() {
        return lightningSpells;
    }

    public ArrayList<IceSpell> getIceSpells() {
        return iceSpells;
    }

    public void add(Item i) {
        inventory.add(i);
        sortInventory();
    }

    public Item remove(int index) {
        Item i = inventory.remove(index);
        sortInventory();
        return i;
    }

    public ArrayList<Spell> getSpells() {
        ArrayList<Spell> spells = new ArrayList<>();
        for (Spell s : fireSpells)
            spells.add(s);
        for (Spell s : iceSpells)
            spells.add(s);
        for (Spell s : lightningSpells)
            spells.add(s);
        return spells;
    }

    public int size() {
        return inventory.size();
    }

    public void remove(Item i) {
        inventory.remove(i);
        sortInventory();
    }

    public Item get(int index) {
        return inventory.get(index);
    }

    public void displayInventory() {
        int index = 0;
        boolean[] typeContains = new boolean[6];
        Arrays.fill(typeContains, false);
        for (Item i : inventory) {
            if (i instanceof Weapon)
                typeContains[0] = true;
            if (i instanceof Armor)
                typeContains[1] = true;

            if (i instanceof Potion)
                typeContains[2] = true;

            if (i instanceof FireSpell)
                typeContains[3] = true;

            if (i instanceof IceSpell)
                typeContains[4] = true;

            if (i instanceof LightningSpell)
                typeContains[5] = true;

        }
        if (typeContains[0]) {
            System.out.println("Weapon: ");
            System.out.println("Name\tPrice\tLevel\tDamage\tRequired Hands");
            while (index < inventory.size() && inventory.get(index) instanceof Weapon) {
                System.out.printf("%d. %s\t%d\t%d\t%d\t%d\n", index + 1, inventory.get(index).getName(), inventory.get(index).getPrice(), inventory.get(index).getLevel(), ((Weapon) inventory.get(index)).getDamage(), ((Weapon) inventory.get(index)).getHandsValue());
                index++;
            }
        }
        if (typeContains[1]) {
            System.out.println("\nArmor: ");
            System.out.println("Name\tPrice\tLevel\tDamage Reduction");
            while (index < inventory.size() && inventory.get(index) instanceof Armor) {
                System.out.printf("%d. %s\t%d\t%d\t%d\n", index + 1, inventory.get(index).getName(), inventory.get(index).getPrice(), inventory.get(index).getLevel(), ((Armor) inventory.get(index)).getReduce());
                index++;
            }
        }
        if (typeContains[2]) {
            System.out.println("\nPotion: ");
            System.out.println("Name\tPrice\tLevel\tAttribute Increase\tAttribute Affected");
            while (index < inventory.size() && inventory.get(index) instanceof Potion) {
                System.out.printf("%d. %s\t%d\t%d\t%d\t%s\n", index + 1, inventory.get(index).getName(), inventory.get(index).getPrice(), inventory.get(index).getLevel(), ((Potion) inventory.get(index)).getIncrease(), ((Potion) inventory.get(index)).getAttributesStr());
                index++;
            }
        }
        if (typeContains[3]) {
            System.out.println("\nFireSpell: ");
            System.out.println("Name\tPrice\tLevel\tDamage\tMana Cost");
            while (index < inventory.size() && inventory.get(index) instanceof FireSpell) {
                System.out.printf("%d. %s\t%d\t%d\t%d\t%s\n", index + 1, inventory.get(index).getName(), inventory.get(index).getPrice(), inventory.get(index).getLevel(), ((Spell) inventory.get(index)).getDamage(), ((Spell) inventory.get(index)).getMana());
                index++;
            }
        }
        if (typeContains[4]) {
            System.out.println("\nIceSpell: ");
            System.out.println("Name\tPrice\tLevel\tDamage\tMana Cost");
            while (index < inventory.size() && inventory.get(index) instanceof IceSpell) {
                System.out.printf("%d. %s\t%d\t%d\t%d\t%s\n", index + 1, inventory.get(index).getName(), inventory.get(index).getPrice(), inventory.get(index).getLevel(), ((Spell) inventory.get(index)).getDamage(), ((Spell) inventory.get(index)).getMana());
                index++;
            }
        }
        if (typeContains[5]) {
            System.out.println("\nLightningSpell: ");
            System.out.println("Name\tPrice\tLevel\tDamage\tMana Cost");
            while (index < inventory.size() && inventory.get(index) instanceof LightningSpell) {
                System.out.printf("%d. %s\t%d\t%d\t%d\t%s\n", index + 1, inventory.get(index).getName(), inventory.get(index).getPrice(), inventory.get(index).getLevel(), ((Spell) inventory.get(index)).getDamage(), ((Spell) inventory.get(index)).getMana());
                index++;
            }
        }
    }
}
