/*
This hero collection class is used to contain all monster instance objects in the battle.
 */
import java.util.*;
public class MonsterTeam {
    private ArrayList<Monster> monsters;
    private int currentMonsterIndex;
    private boolean allFainted;

    public MonsterTeam(){
        monsters = new ArrayList<>();
        currentMonsterIndex = 0;
        allFainted = false;
    }

    public void addMonster(Monster m){
        monsters.add(m);
    }

    public boolean isAllFainted(){
        for(Monster m : monsters){
            if(!m.isFaint())
                return false;
        }
        allFainted = true;
        return true;
    }

    public void displayMonsters(){
        for(int i = 0; i < monsters.size(); i++){
            System.out.println("" + (i + 1) + ". " + monsters.get(i).getName());
        }
    }

    public void displayUnfaintedMonsters(){
        for(int i = 0; i < monsters.size(); i++){
            if(!monsters.get(i).isFaint())
                System.out.println("" + (i + 1) + ". " + monsters.get(i).getName());
        }
    }

    public Monster getMonster(int menuIndex){
        menuIndex--;
        return monsters.get(menuIndex);
    }


    //returns next unfainted monster
    public Monster nextAvailableMonster(){
        if(allFainted)
            return null;
        //get next unfainted monster's index
        while(monsters.get(currentMonsterIndex).isFaint())
            currentMonsterIndex = (currentMonsterIndex + 1) % monsters.size();
        return monsters.get(currentMonsterIndex);
    }
}
