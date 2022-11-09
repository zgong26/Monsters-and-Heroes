public class FireSpell extends Item implements Spell{
    private int damage;
    private int mana;
    public FireSpell(String name, int price, int level) {
        super(name, price, level);
    }

    public FireSpell(String name, int price, int level, int damage, int mana){
        this(name, price, level);
        this.damage = damage;
        this.mana = mana;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getMana() {
        return mana;
    }
}
