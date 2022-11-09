/*
This is the weapon interface which declares some unique properties for weapon items
 */
public class Weapon extends Item {
    private int damage;
    private int handsValue;

    public Weapon(String name, int price, int level) {
        super(name, price, level);
    }

    public Weapon(String name, int price, int level, int damage, int handsValue) {
        this(name, price, level);
        this.damage = damage;
        this.handsValue = handsValue;
    }

    public int getDamage() {
        return damage;
    }

    public int getHandsValue() {
        return handsValue;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setHandsValue(int handsValue) {
        this.handsValue = handsValue;
    }
}
