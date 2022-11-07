/*
A warrior class that extends Character abstract class and implements hero interface
 */
public class Warrior extends Hero {

    public Warrior(String name, int level, int mana, int strength, int dexterity, int agility, int gold, int experience){
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
    @Override
    public void attack(Monster enemy) {
        int rawDamage = 0;
        rawDamage += strength;
        rawDamage += weaponDamage();
        rawDamage *= 0.05;
        enemy.beAttacked(rawDamage);
    }

    @Override
    //return damage taken, return "dodged" if dodged
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

    public int emptyHandsNum(){
        int num = 0;
        if(hands[0].isEmpty())
            num++;
        if(hands[1].isEmpty())
            num++;
        return num;
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

    private boolean dodged(){
        double rand = Math.random() * 100;
        if(rand <= (0.002 * agility))
            return true;
        return false;
    }

    @Override
    public boolean updateLevel(){
        int nextLevelExp = level * 10;
        boolean levelChanged = false;
        while(experience >= nextLevelExp){
            levelUP();
            experience -= nextLevelExp;
            levelChanged = true;
        }
        return levelChanged;
    }

    private void levelUP(){
        //base property
        level++;
        HP = level * 100;
        mana = (int)(1.1 * mana);
        strength = (int)(1.05 * strength);
        dexterity = (int)(1.05 * dexterity);
        agility = (int)(1.05 * agility);
        //warrior extra
        strength = (int)(1.05 * strength);
        agility = (int)(1.05 * agility);
    }
}
