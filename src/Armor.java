/*
This is the armor interface which declares some unique properties for armor items
 */
public class Armor extends Item{
    private int reduce;
    public Armor(String name, int price, int level) {
        super(name, price, level);
    }

    public Armor(String name, int price, int level, int reduce){
        this(name, price, level);
        this.reduce = reduce;
    }

    public int getReduce() {
        return (int)(reduce * 0.02);
    }

    public void setReduce(int reduce) {
        this.reduce = reduce;
    }
}
