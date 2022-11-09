/*
A Cell class that represents a cell on the world board
 */
public class Cell {
    private String type;
    private boolean hasPlayer;//indicate whether player is on it
    public Cell(String type){
        this.type = type;
        hasPlayer = false;
    }
    public void setPlayer(boolean b){
        hasPlayer = b;
    }

    public String getType(){
        return type;
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
