public abstract class Item {
    int price;
    int level;
    String name;

    public int getPrice() {
        return price;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
