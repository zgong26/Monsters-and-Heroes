import java.util.*;
public class Market {
    private Inventory inventory;

    public Market(){
        inventory = new Inventory();
        createInventory();//generate random items
    }

    public void createInventory(){
        Random rand = new Random();
        int lower = 3;
        int upper = 8;
        int number = rand.nextInt(upper) + lower;
        ArrayList<Item> ls = ItemCollection.getItems();
        Collections.shuffle(ls);
        for(int i = 0; i < Math.min(number, ls.size()); i++){
            inventory.add(ls.get(i));
        }
        //sort inventory by types
        inventory.sortInventory();
    }

    public Item sell(int index){
        index--;
        return inventory.remove(index);
    }

    public int buy(Item i){
        int price = i.getPrice() / 2;
        inventory.add(i);
        inventory.sortInventory();
        return price;
    }

    public void displayMenu(){
        inventory.displayInventory();
    }
}
