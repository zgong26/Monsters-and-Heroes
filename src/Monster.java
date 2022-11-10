/*
A monster interface that declares some unique behaviors of monsters
 */
public abstract class Monster implements Character {
    String name;
    int level;
    int HP;
    int strength;
    int defenseValue;
    int chance;
    boolean faint;
    Weapon monsterWeapon;

    public Monster(String name, int level, int strength, int defenseValue, int chance) {
        this.name = name;
        this.level = level;
        this.HP = level * 100;
        this.strength = strength;
        this.defenseValue = defenseValue;
        this.chance = chance;
        faint = false;
        monsterWeapon = new Weapon("Monster Magic Weapon", 999999, 400 + level * 50, level, 8);
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

    public int getStrength() {
        return strength;
    }

    public int getDefenseValue() {
        return defenseValue;
    }

    public int getChance() {
        return chance;
    }

    public Weapon getMonsterWeapon() {
        return monsterWeapon;
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

    public void setDefenseValue(int defenseValue) {
        this.defenseValue = defenseValue;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public void setMonsterWeapon(Weapon monsterWeapon) {
        this.monsterWeapon = monsterWeapon;
    }

    public void setFaint(boolean faint) {
        this.faint = faint;
    }

    public String attack(Hero enemy) {
        int rawDamage = (int) ((strength + weaponDamage()) * 0.05);
        return enemy.beAttacked(rawDamage);
    }

    private int weaponDamage() {
        return monsterWeapon.getDamage();
    }

    public String beAttacked(int rawDamage) {
        if (dodged())
            return "dodged";
        rawDamage = (int) (rawDamage - defenseValue * 0.03);
        rawDamage = Math.max(rawDamage, 0);
        HP -= rawDamage;
        return String.valueOf(rawDamage);
    }

    private boolean dodged() {
        double rand = Math.random() * 100;
        if (rand <= (0.01 * chance))
            return true;
        return false;
    }
}

