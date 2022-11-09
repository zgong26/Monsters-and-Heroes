import java.util.ArrayList;

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

    public Inventory(){
        inventory = new ArrayList<>();
        weapons = new ArrayList<>();
        armors = new ArrayList<>();
        potions = new ArrayList<>();
        fireSpells = new ArrayList<>();
        iceSpells = new ArrayList<>();
        lightningSpells = new ArrayList<>();
    }

    public void sortInventory(){
        weapons.clear();
        armors.clear();
        potions.clear();
        fireSpells.clear();
        iceSpells.clear();
        lightningSpells.clear();
        for(Item i : inventory){
            if(i instanceof Weapon)
                weapons.add((Weapon) i);
            if(i instanceof Armor)
                armors.add((Armor) i);
            if(i instanceof Potion)
                potions.add((Potion) i);
            if(i instanceof FireSpell)
                fireSpells.add((FireSpell) i);
            if(i instanceof IceSpell)
                iceSpells.add((IceSpell) i);
            if(i instanceof LightningSpell)
                lightningSpells.add((LightningSpell) i);
        }
        inventory.clear();
        weapons.forEach(weapon -> {inventory.add(weapon);});
        armors.forEach(armor -> {inventory.add(armor);});
        potions.forEach(potion -> {inventory.add(potion);});
        fireSpells.forEach(fireSpell -> {inventory.add(fireSpell);});
        iceSpells.forEach(iceSpell -> {inventory.add(iceSpell);});
        lightningSpells.forEach(lightningSpell -> {inventory.add(lightningSpell);});
    }

    public void add(Item i){
        inventory.add(i);
    }

    public Item remove(int index){
        return inventory.remove(index);
    }
    public int size(){return inventory.size();}

    public void remove(Item i){
        inventory.remove(i);
    }

    public Item get(int index){
        return inventory.get(index);
    }

    public void displayInventory(){
        int index = 0;
        System.out.println("Weapon: ");
        System.out.println("Name\tPrice\tLevel\tDamage\tRequired Hands");
        while(index < inventory.size() && inventory.get(index) instanceof Weapon){
            System.out.printf("%d. %s\t%d\t%d\t%d\t%d\n", index + 1, inventory.get(index).getName(), inventory.get(index).getPrice(), inventory.get(index).getLevel(), ((Weapon) inventory.get(index)).getDamage(), ((Weapon) inventory.get(index)).getHandsValue());
            index++;
        }
        System.out.println("Armor: ");
        System.out.println("Name\tPrice\tLevel\tDamage Reduction");
        while(index < inventory.size() && inventory.get(index) instanceof Armor){
            System.out.printf("%d. %s\t%d\t%d\t%d\n", index + 1, inventory.get(index).getName(), inventory.get(index).getPrice(), inventory.get(index).getLevel(), ((Armor) inventory.get(index)).getReduce());
            index++;
        }
        System.out.println("Potion: ");
        System.out.println("Name\tPrice\tLevel\tAttribute Increase\tAttribute Affected");
        while(index < inventory.size() && inventory.get(index) instanceof Potion){
            System.out.printf("%d. %s\t%d\t%d\t%d\t%s\n", index + 1, inventory.get(index).getName(), inventory.get(index).getPrice(), inventory.get(index).getLevel(), ((Potion) inventory.get(index)).getIncrease(), ((Potion) inventory.get(index)).getAttributesStr());
            index++;
        }
        System.out.println("FireSpell: ");
        System.out.println("Name\tPrice\tLevel\tDamage\tMana Cost");
        while(index < inventory.size() && inventory.get(index) instanceof FireSpell){
            System.out.printf("%d. %s\t%d\t%d\t%d\t%s\n", index + 1, inventory.get(index).getName(), inventory.get(index).getPrice(), inventory.get(index).getLevel(), ((Spell) inventory.get(index)).getDamage(), ((Spell) inventory.get(index)).getMana());
            index++;
        }
        System.out.println("IceSpell: ");
        System.out.println("Name\tPrice\tLevel\tDamage\tMana Cost");
        while(index < inventory.size() && inventory.get(index) instanceof IceSpell){
            System.out.printf("%d. %s\t%d\t%d\t%d\t%s\n", index + 1, inventory.get(index).getName(), inventory.get(index).getPrice(), inventory.get(index).getLevel(), ((Spell) inventory.get(index)).getDamage(), ((Spell) inventory.get(index)).getMana());
            index++;
        }
        System.out.println("LightningSpell: ");
        System.out.println("Name\tPrice\tLevel\tDamage\tMana Cost");
        while(index < inventory.size() && inventory.get(index) instanceof LightningSpell){
            System.out.printf("%d. %s\t%d\t%d\t%d\t%s\n", index + 1, inventory.get(index).getName(), inventory.get(index).getPrice(), inventory.get(index).getLevel(), ((Spell) inventory.get(index)).getDamage(), ((Spell) inventory.get(index)).getMana());
            index++;
        }
    }
}
