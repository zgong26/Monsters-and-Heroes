import java.util.ArrayList;

/*
This class contains all heroes in the game
 */
public class HeroCollection {
    private static ArrayList<Hero> heroes;

    public HeroCollection() {
        heroes = new ArrayList<>();
        addAll();
    }

    private static void addAll() {
        //warriors
        heroes.add(new Warrior("Gaerdal_Ironhand", 1, 100, 700, 500, 600, 1354, 7));
        heroes.add(new Warrior("Sehanine_Monnbow", 1, 600, 700, 800, 500, 2500, 8));
        heroes.add(new Warrior("Muamman_Duathall", 1, 300, 900, 500, 750, 2546, 6));
        heroes.add(new Warrior("Flandal_Steelskin", 1, 200, 750, 650, 700, 2500, 7));
        heroes.add(new Warrior("Undefeated_Yoj", 1, 400, 800, 400, 700, 2500, 7));
        heroes.add(new Warrior("Eunoia_Cyn", 1, 400, 700, 800, 600, 2500, 6));

        //sorcerers
        heroes.add(new Sorcerer("Segojan_Earthcaller", 1, 900, 800, 500, 650, 2500, 5));
        heroes.add(new Sorcerer("Reign_Havoc", 1, 800, 800, 800, 800, 2500, 8));
        heroes.add(new Sorcerer("Reverie_Ashels", 1, 900, 800, 700, 400, 2500, 7));
        heroes.add(new Sorcerer("Kalabar", 1, 800, 850, 400, 600, 2500, 6));
        heroes.add(new Sorcerer("Skye_Soar", 1, 1000, 700, 400, 500, 2500, 5));

        //Paladin
        heroes.add(new Paladin("Parzival", 1, 300, 750, 650, 700, 2500, 7));
        heroes.add(new Paladin("Sehanine_Moonbow", 1, 300, 750, 700, 700, 2500, 7));
        heroes.add(new Paladin("Skoraeus_Stonebones", 1, 250, 650, 600, 350, 2500, 4));
        heroes.add(new Paladin("Garl_Glittergold", 1, 100, 600, 500, 400, 2500, 5));
        heroes.add(new Paladin("Amaryllis_Astra", 1, 500, 500, 500, 500, 2500, 5));
        heroes.add(new Paladin("Caliber_Heist", 1, 400, 400, 400, 400, 2500, 8));
    }
}
