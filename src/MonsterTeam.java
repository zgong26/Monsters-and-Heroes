/*
This hero collection class is used to contain all monster instance objects in the battle.
 */

import java.util.*;

public class MonsterTeam {
    private ArrayList<Monster> monsters;
    private int currentMonsterIndex;
    private boolean allFainted;

    public MonsterTeam() {
        monsters = new ArrayList<>();
        currentMonsterIndex = 0;
        allFainted = false;
    }

    public void addMonster(Monster m) {
        monsters.add(m);
    }

    public int size() {
        return monsters.size();
    }

    public boolean isAllFainted() {
        for (Monster m : monsters) {
            if (!m.isFaint())
                return false;
        }
        allFainted = true;
        return true;
    }

    public void displayMonsters() {
        for (int i = 0; i < monsters.size(); i++) {
            String faint = monsters.get(i).isFaint() ? "(fainted)" : "";
            System.out.println("" + (i + 1) + ". " + monsters.get(i).getName() + faint);
        }
    }


    public void displayStatistics() {
        for (int i = 0; i < monsters.size(); i++) {
            Monster monster = monsters.get(i);
            if (!monster.isFaint())
                System.out.printf("%s: \nlevel%d  HP: %d  strength: %d  dodge chance: 0.%d%%\n", monster.getName(), monster.getLevel(), monster.getHP(), monster.getStrength(), monster.getChance());
        }
    }

    public Monster getMonster(int menuIndex) {
        menuIndex--;
        return monsters.get(menuIndex);
    }

    public ArrayList<Integer> getUnfaintedIndices() {
        ArrayList<Integer> ls = new ArrayList<>();
        for (int i = 0; i < monsters.size(); i++) {
            if (!monsters.get(i).isFaint())
                ls.add(i);
        }
        return ls;
    }

    public int levelSum(){
        int sum = 0;
        for(Monster m : monsters)
            sum += m.getLevel();
        return sum;
    }


    //returns next unfainted monster
    public Monster nextAvailableMonster() {
        if (allFainted)
            return null;
        //get next unfainted monster's index
        while (monsters.get(currentMonsterIndex).isFaint())
            currentMonsterIndex = (currentMonsterIndex + 1) % monsters.size();
        return monsters.get(currentMonsterIndex);
    }

    public void clear(){
        monsters.clear();
    }

}
