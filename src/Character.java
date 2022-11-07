/*
Interface of a game character
 */
public interface Character {
    public String getName();
    public int getHP();
    public int getLevel();

    public void setName(String name);
    public void setHP(int HP);
    public void setLevel(int level);
}
