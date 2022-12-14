import java.util.ArrayList;

/*
This abstract Hero class implements Character and defines some unique and necessary features of Hero.
 */
public abstract class Hero implements Character {
    String name;
    int level;
    int experience;
    int HP;
    int mana;
    int strength;
    int dexterity;
    int agility;
    int gold;
    Hand[] hands;
    Armor[] armors;
    boolean faint;
    Inventory inventory;
    final int maxHands = 2;
    final int maxArmors = 2;

    public Hero(String name, int level, int mana, int strength, int agility, int dexterity, int gold, int experience) {
        this.name = name;
        this.level = level;
        this.HP = level * 100;
        this.mana = mana;
        this.strength = strength;
        this.dexterity = dexterity;
        this.agility = agility;
        this.gold = gold;
        this.experience = experience;
        hands = new Hand[maxHands];
        hands[0] = new Hand("left");
        hands[1] = new Hand("right");
        armors = new Armor[maxArmors];
        inventory = new Inventory();
        faint = false;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHP() {
        return HP;
    }

    public int getMana() {
        return mana;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getGold() {
        return gold;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getExperience() {
        return experience;
    }

    public boolean isFaint() {
        return faint;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setFaint(boolean faint) {
        this.faint = faint;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public String attack(Monster enemy) {
        int rawDamage = (int) ((strength + weaponDamage()) * 0.05);
        return enemy.beAttacked(rawDamage);
    }

    private int weaponDamage() {
        int dmg = 0;
        //if the current weapon requires 2 hands, calculate weapon damage only once
        for (Hand hand : hands) {
            if (!hand.isEmpty() && hand.getWeapon().getHandsValue() == 2) {
                dmg += hand.getWeapon().getDamage();
                break;
            }
            //otherwise calculate each hand's weapon damage
            if (!hand.isEmpty())
                dmg += hand.getWeapon().getDamage();
        }
        return dmg;
    }

    public String getWeapon() {
        String res = "";
        if (hands[0].isEmpty() && hands[1].isEmpty())
            return "None";
        if (!hands[0].isEmpty() && hands[0].getWeapon().getHandsValue() == 2)
            return hands[0].getWeapon().getName();
        if ((!hands[0].isEmpty()) && (!hands[1].isEmpty()))
            return "" + hands[0].getWeapon().getName() + " and " + hands[1].getWeapon().getName();
        if (!hands[0].isEmpty())
            return hands[0].getWeapon().getName();
        return hands[1].getWeapon().getName();
    }

    public String beAttacked(int rawDamage) {
        if (dodged())
            return "dodged";
        for (Armor armor : armors) {
            if (armor != null)
                rawDamage -= armor.getReduce();
        }
        rawDamage = Math.max(rawDamage, 0);
        HP -= rawDamage;
        return String.valueOf(rawDamage);
    }

    public Armor[] getArmors() {
        return armors;
    }

    public void replaceArmor(int index, Armor a) {
        armors[index] = a;
    }

    private boolean dodged() {
        double rand = Math.random() * 100;
        if (rand <= (0.002 * agility))
            return true;
        return false;
    }

    public int emptyHandsNum() {
        int num = 0;
        if (hands[0].isEmpty())
            num++;
        if (hands[1].isEmpty())
            num++;
        return num;
    }

    public void addItem(Item i) {
        inventory.add(i);
    }

    public Item getItem(int menuIndex) {
        menuIndex--;
        return inventory.get(menuIndex);
    }

    public void removeItem(int menuIndex) {
        menuIndex--;
        inventory.remove(menuIndex);
    }

    public void addGold(int g) {
        gold += g;
    }


    public abstract boolean updateLevel();

    public void setMana(int i) {
        mana = i;
    }

    public void addExp(int i) {
        experience += i;
    }

    public void setDexterity(int i) {
        dexterity = i;
    }

    public void equipWeapon(Weapon w) {
        if (w.getHandsValue() == 2) {
            hands[0].setWeapon(w);
            hands[1].setWeapon(w);
            return;
        }
        if (hands[0].isEmpty()) {
            hands[0].setWeapon(w);
        } else if (hands[1].isEmpty()) {
            hands[1].setWeapon(w);
        } else if (hands[0].getWeapon().getHandsValue() == 2) {
            hands[0].setWeapon(w);
            hands[1].setWeapon(null);
        } else {
            hands[0].setWeapon(w);
        }
    }
}
