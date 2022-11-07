/*
A Hand class that can equip weapon(s)
 */
public class Hand {
    private String name;
    private Weapon weapon;
    public Hand(String name){
        this.name = name;
        weapon = null;
    }
    public boolean isEmpty(){
        if(weapon == null)
            return true;
        return false;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
