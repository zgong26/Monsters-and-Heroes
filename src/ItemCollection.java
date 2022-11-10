import java.util.ArrayList;

/*
This class contains all items in the game
 */
public class ItemCollection {
    private static ArrayList<Item> items;

    public ItemCollection() {
        items = new ArrayList<Item>();
        addAll();
    }

    public static ArrayList<Item> getItems() {
        return items;
    }

    public static void addItem(Item i) {
        items.add(i);
    }

    private static void addAll() {
        items.add(new Weapon("Sword", 500, 1, 800, 1));
        items.add(new Weapon("Bow", 300, 2, 500, 2));
        items.add(new Weapon("Scythe", 1000, 6, 1100, 2));
        items.add(new Weapon("Axe", 550, 5, 850, 1));
        items.add(new Weapon("TSwords", 1400, 8, 1600, 2));
        items.add(new Weapon("Dagger", 200, 1, 250, 1));

        items.add(new Armor("Platinum_Shield", 150, 1, 200));
        items.add(new Armor("Breastplate", 350, 3, 600));
        items.add(new Armor("Full_Body_Armor", 1000, 8, 1100));
        items.add(new Armor("Wizard_Shield", 1200, 10, 1500));
        items.add(new Armor("Guardian_Angel", 1000, 10, 1000));

        items.add(new Potion("Healing_Potion",  250    , 1   ,100		,"Health"));
        items.add(new Potion("Strength_Potion", 200 ,    1   ,75	,	"Strength"));
        items.add(new Potion("Magic_Potion",    350   ,  2  , 100	,	"Mana"));
        items.add(new Potion("Luck_Elixir",     500   ,  4   ,65  ,	"Agility"));
        items.add(new Potion("Mermaid_Tears",   850  ,   5  , 100  	,"Health/Mana/Strength/Agility"));

        items.add(new FireSpell("Flame_Tornado", 700, 4, 850, 300));
        items.add(new FireSpell("Breath_of_Fire", 350, 1, 450, 100));
        items.add(new FireSpell("Heat_Wave", 450, 2, 600, 150));
        items.add(new FireSpell("Lava_Comet", 800, 7, 1000, 550));
        items.add(new FireSpell("Hell_Storm", 600, 3, 950, 600));

        items.add(new IceSpell("Snow_Cannon", 500, 2, 650, 250));
        items.add(new IceSpell("Ice_Blade", 250, 1, 450, 100));
        items.add(new IceSpell("Frost_Blizzard", 750, 5, 850, 350));
        items.add(new IceSpell("Arctic_Storm", 700, 6, 800, 300));

        items.add(new LightningSpell("Lightning_Dagger", 400, 1, 500, 150));
        items.add(new LightningSpell("Thunder_Blast", 750, 4, 950, 400));
        items.add(new LightningSpell("Electric_Arrows", 550, 5, 650, 200));
        items.add(new LightningSpell("Spark_Needles", 500, 2, 600, 200));
    }
}
