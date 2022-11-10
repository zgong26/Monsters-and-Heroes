public class LightningSpell extends Item implements Spell {
    private int damage;
    private int mana;

    public LightningSpell(String name, int price, int level) {
        super(name, price, level);
    }

    public LightningSpell(String name, int price, int level, int damage, int mana) {
        this(name, price, level);
        this.damage = damage;
        this.mana = mana;
    }

    public int getDamage() {
        return damage;
    }

    public int getMana() {
        return mana;
    }

    public String getName() {
        return name;
    }
}
