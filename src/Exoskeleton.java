public class Exoskeleton extends Monster{

    public Exoskeleton(String name, int level, int strength, int defenseValue, int chance){
        this.name = name;
        this.level = level;
        this.HP = level * 100;
        this.strength = strength;
        this.defenseValue = defenseValue;
        this.chance = chance;
    }
    @Override
    public void attack(Hero enemy) {
        int rawDamage = 0;
        rawDamage += strength;
        rawDamage += weaponDamage();
        enemy.beAttacked(rawDamage);
    }

    @Override
    public String beAttacked(int rawDamage) {
        return null;
    }

    private boolean dodged(){
        double rand = Math.random() * 100;
        if(rand <= (0.01 * chance))
            return true;
        return false;
    }
    private int weaponDamage(){
        return monsterWeapon.getDamage();
    }
}
