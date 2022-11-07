/*
This hero collection class is used to contain all hero instance objects.
 */
import java.util.*;
public class HeroCollection {
    private ArrayList<Hero> heroes;

    public HeroCollection(){
        heroes = new ArrayList<>();
    }

    public void addHero(Hero h){
        heroes.add(h);
    }

    public boolean allFaint(){
        for(Hero h : heroes){
            if(!h.getFaint())
                return false;
        }
        return true;
    }

    public void displayHeroes(){
        for(int i = 0; i < heroes.size(); i++){
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
}
