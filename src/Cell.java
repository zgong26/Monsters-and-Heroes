/*
A Cell class that represents a cell on the world board
 */
public class Cell {
    private String type;
    private boolean hasPlayer;//indicate whether player is on it
    private int id;
    public Cell(String type, int id){
        this.type = type;
        hasPlayer = false;
        this.id = id;
    }
    public void setPlayer(boolean b){
        hasPlayer = b;
    }

    public String getType(){
        return type;
    }
    public int getId(){
        return id;
    }

    public String toString(){
        if(hasPlayer)
            return "P";
        if(type == "inaccessible")
            return "X";
        if(type == "market")
            return "m";
        return " ";
    }
}
