/*
A Cell class that represents a cell on the world board
 */
public class Cell {
    private String type;
    public Cell(String type){
        this.type = type;
    }

    public String toString(){
        if(type == "inaccessible")
            return "X";
        if(type == "market")
            return "m";
        if(type == "player")
            return "P";
        return " ";
    }
}
