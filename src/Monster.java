/*
A monster interface that declares some unique behaviors of monsters
 */
public abstract class Monster {
    String name;
    int level;
    int HP;
    int strength;
    int defenseValue;
    int chance;
    boolean faint;
    Weapon monsterWeapon;

    public String getName(){return name;}

    public int getLevel(){return level;}
    public int getHP(){return HP;}
    public int getStrength(){return strength;}
    public int getDefenseValue() {return defenseValue;}
    public int getChance() {return chance;}
    public Weapon getMonsterWeapon() {return monsterWeapon;}
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

    public void setDefenseValue(int defenseValue) {this.defenseValue = defenseValue;}

    public void setChance(int chance) {this.chance = chance;}

    public void setMonsterWeapon(Weapon monsterWeapon) {this.monsterWeapon = monsterWeapon;}

    public void setFaint(boolean faint){this.faint = faint;}

    public abstract void attack(Hero enemy);
    public abstract String beAttacked(int rawDamage);
}
