/*
This is a concrete potion class that extends from Item, which represents a potion object in the game
 */
public class Potion extends Item{
    private int increase;
    private String attributesStr;
    private String[] attributes;
    public Potion(String name, int price, int level) {
        super(name, price, level);
    }

    public Potion(String name, int price, int level, int increase, String attributes){
        this(name, price, level);
        this.increase = increase;
        this.attributesStr = attributes;
        this.attributes = attributes.split("/");
    }

    public int getIncrease() {
        return increase;
    }

    public void setIncrease(int increase) {
        this.increase = increase;
    }

    public String[] getAttributes() {
        return attributes;
    }

    public String getAttributesStr() {
        return attributesStr;
    }

    public void setAttributes(String[] attributes) {
        this.attributes = attributes;
    }
}
