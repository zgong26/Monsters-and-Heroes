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
