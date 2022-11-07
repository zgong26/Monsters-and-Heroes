/*
This abstract character class encapsulates the commonplace between heroes and monsters
 */
public abstract class Hero implements Character{
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
    public Hero(String name, int level, int mana, int strength, int dexterity, int agility, int gold, int experience){
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
        faint = false;
    }
    public String getName(){return name;}

    public int getLevel(){return level;}
    public int getHP(){return HP;}
    public int getStrength(){return strength;}
    public int getAgility(){return agility;}
    public boolean isFaint(){return faint;}

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

    public void attack(Monster enemy) {
        int rawDamage = (int) ((strength + weaponDamage()) * 0.05);
        enemy.beAttacked(rawDamage);
    }

    private int weaponDamage(){
        int dmg = 0;
        //if the current weapon requires 2 hands, calculate weapon damage only once
        for(Hand hand : hands){
            if(!hand.isEmpty() && hand.getWeapon().getHandsValue() == 2){
                dmg += hand.getWeapon().getDamage();
                break;
            }
            //otherwise calculate each hand's weapon damage
            if(!hand.isEmpty())
                dmg += hand.getWeapon().getDamage();
        }
        return dmg;
    }

    public String beAttacked(int rawDamage) {
        if(dodged())
            return "dodged";
        for(Armor armor : armors){
            if(armor != null)
                rawDamage -= armor.getReducedDamage(rawDamage);
        }
        rawDamage = Math.max(rawDamage, 0);
        HP -= rawDamage;
        return String.valueOf(rawDamage);
    }

    private boolean dodged(){
        double rand = Math.random() * 100;
        if(rand <= (0.002 * agility))
            return true;
        return false;
    }

    public int emptyHandsNum(){
        int num = 0;
        if(hands[0].isEmpty())
            num++;
        if(hands[1].isEmpty())
            num++;
        return num;
    }
    public abstract boolean updateLevel();
}
