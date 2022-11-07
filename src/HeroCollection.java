/*
This hero collection class is used to contain all hero instance objects.
 */
import java.util.*;
public class HeroCollection {
    private ArrayList<Hero> heroes;
    private int currentHeroIndex;
    private boolean allFainted;

    public HeroCollection(){
        heroes = new ArrayList<>();
        currentHeroIndex = 0;
        allFainted = false;
    }

    public void addHero(Hero h){
        heroes.add(h);
    }

    public boolean isAllFainted(){
        for(Hero h : heroes){
            if(!h.isFaint())
                return false;
        }
        allFainted = true;
        return true;
    }

    public void displayHeroes(){
        for(int i = 0; i < heroes.size(); i++){
            System.out.println("" + (i + 1) + ". " + heroes.get(i).getName());
        }
    }

    public void displayUnfaintedHeroes(){
        for(int i = 0; i < heroes.size(); i++){
            if(!heroes.get(i).isFaint())
                System.out.println("" + (i + 1) + ". " + heroes.get(i).getName());
        }
    }

    public Hero getHero(int menuIndex){
        menuIndex--;
        return heroes.get(menuIndex);
    }

    public void updateLevelAll(){
        for(int i = 0; i < heroes.size(); i++){
            Hero h = heroes.get(i);
            boolean updated = h.updateLevel();
            if(updated){
                System.out.printf("Hero %s level up! Now level %d\n", h.getName(), h.getLevel());
            }
        }
    }

    //returns next unfainted hero
    public Hero nextAvailableHero(){
        if(allFainted)
            return null;
        //get next unfainted hero's index
        while(heroes.get(currentHeroIndex).isFaint())
            currentHeroIndex = (currentHeroIndex + 1) % heroes.size();
        return heroes.get(currentHeroIndex);
    }
}
