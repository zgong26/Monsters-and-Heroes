public class Exoskeleton extends Monster{

    public Exoskeleton(String name, int level, int strength, int defenseValue, int chance){
        super(name, level, strength, defenseValue, chance);
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
