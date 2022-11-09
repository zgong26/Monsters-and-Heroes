/*
This hero collection class is used to contain all hero instance objects.
 */

import java.util.*;

public class HeroTeam {
    private ArrayList<Hero> heroes;
    private int currentHeroIndex;
    private boolean allFainted;

    public HeroTeam() {
        heroes = new ArrayList<>();
        currentHeroIndex = 0;
        allFainted = false;
    }

    public int size() {
        return heroes.size();
    }

    public void addHero(Hero h) {
        heroes.add(h);
    }

    public boolean isAllFainted() {
        for (Hero h : heroes) {
            if (!h.isFaint())
                return false;
        }
        allFainted = true;
        return true;
    }

    public void displayHeroes() {
        for (int i = 0; i < heroes.size(); i++) {
            String faint = "";
            if (heroes.get(i).isFaint())
                faint = "(fainted!)";
            System.out.println("" + (i + 1) + ". " + heroes.get(i).getName() + faint);
        }
    }

    public void unfaintAll() {
        for (Hero h : heroes)
            h.setFaint(false);
    }

    public void displayUnfaintedHeroes() {
        for (int i = 0; i < heroes.size(); i++) {
            if (!heroes.get(i).isFaint()) {
                System.out.println("" + (i + 1) + ". " + heroes.get(i).getName());
            }
        }
    }

    public Hero getHero(int menuIndex) {
        menuIndex--;
        return heroes.get(menuIndex);
    }

    public void updateLevelAll() {
        for (int i = 0; i < heroes.size(); i++) {
            Hero h = heroes.get(i);
            boolean updated = h.updateLevel();
            if (updated) {
                System.out.printf("Hero %s level up! Now level %d\n", h.getName(), h.getLevel());
            }
        }
    }

    //returns next unfainted hero
    public Hero nextAvailableHero() {
        if (allFainted)
            return null;
        //get next unfainted hero's index
        while (heroes.get(currentHeroIndex).isFaint())
            currentHeroIndex = (currentHeroIndex + 1) % heroes.size();
        return heroes.get(currentHeroIndex);
    }

    public void displayStatistics() {
        for (int i = 0; i < heroes.size(); i++) {
            Hero h = heroes.get(i);
            String faint = "";
            if (h.isFaint())
                faint = "(fainted!)";
            System.out.printf("%s%s: \nlevel%d  HP: %d  mana: %d  strength: %d  dexterity: %d  agility: %d  equipped weapon: %s\n", h.getName(), faint, h.getLevel(), h.getHP(), h.getMana(), h.getStrength(), h.getDexterity(), h.getAgility(), h.getWeapon());
        }
    }
}
