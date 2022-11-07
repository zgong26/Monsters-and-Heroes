/*
This abstract character class encapsulates the commonplace between heroes and monsters
 */
public abstract class Hero {
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
    final int maxHands = 2;
    final int maxArmors = 2;

    public String getName(){return name;}

    public int getLevel(){return level;}
    public int getHP(){return HP;}
    public int getStrength(){return strength;}
    public int getAgility(){return agility;}
    public boolean getFaint(){return faint;}

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
    public void setFaint(boolean faint){this.faint = faint;}

    public abstract void attack(Monster enemy);
    public abstract String beAttacked(int rawDamage);
    public abstract boolean updateLevel();
}
