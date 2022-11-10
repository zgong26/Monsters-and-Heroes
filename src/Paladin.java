/*
A concret class of a type of Hero
 */
public class Paladin extends Hero {
    public Paladin(String name, int level, int mana, int strength, int agility, int dexterity, int gold, int experience) {
        super(name, level, mana, strength, agility, dexterity, gold, experience);
    }

    @Override
    public boolean updateLevel() {
        int nextLevelExp = level * 10;
        boolean levelChanged = false;
        while (experience >= nextLevelExp) {
            levelUP();
            experience -= nextLevelExp;
            levelChanged = true;
        }
        return levelChanged;
    }

    private void levelUP() {
        //base property
        level++;
        HP = level * 100;
        mana = (int) (1.1 * mana);
        strength = (int) (1.05 * strength);
        dexterity = (int) (1.05 * dexterity);
        agility = (int) (1.05 * agility);
        //paladin extra
        strength = (int) (1.05 * strength);
        dexterity = (int) (1.05 * dexterity);
    }
}
