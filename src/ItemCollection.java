import java.util.ArrayList;

/*
This class contains all items in the game
 */
public class ItemCollection {
    private static ArrayList<Item> items;
    public ItemCollection(){
        items = new ArrayList<Item>();
    }

    public static ArrayList<Item> getItems(){
        return items;
    }

    public static void addItem(Item i){
        items.add(i);
    }
}
