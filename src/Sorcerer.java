/*
A sorcerer class that extends Hero abstract class
 */
public class Sorcerer extends Hero{

    public Sorcerer(String name, int level, int mana, int strength, int dexterity, int agility, int gold, int experience){
        super(name, level, mana, strength, dexterity, agility, gold, experience);
    }

    @Override
    public boolean updateLevel() {
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
        //sorcerer extra
        dexterity = (int)(1.05 * dexterity);
        agility = (int)(1.05 * agility);
    }
}
