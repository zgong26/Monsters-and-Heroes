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
    }
}
