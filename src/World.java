import java.util.*;

public class World extends Board{
    private double inaccessiblePercent;
    private double commonPercent;
    private double marketPercent;

    public World(int size, int inaccessiblePercent, int commonPercent, int marketPercent){
        super(size);
        this.inaccessiblePercent = 0.01 * inaccessiblePercent;
        this.commonPercent = 0.01 * commonPercent;
        this.marketPercent = 0.01 * marketPercent;
    }

    public World(int size){
        this(size, 20, 50, 30);
    }

    //default world
    public World(){
        this(8);
    }

    //this method is used to generate a random world
    public void generateWorld(){
        int numCell = getNumOfSquares();
        int inaccNum = (int) (numCell * inaccessiblePercent);
        int marketNum = (int)(numCell * marketPercent);
        int commonNum = numCell - inaccNum - marketNum;

        ArrayList<Cell> cellList = new ArrayList<>();//create a list of cell which has same size of board, and shuffle it
        for(int i = 0; i < inaccNum; i++){
            cellList.add(new Cell("inaccessible"));
        }
        for(int i = 0; i < marketNum; i++){
            cellList.add(new Cell("market"));
        }
        for(int i = 0; i < commonNum; i++){
            cellList.add(new Cell("common"));
        }

        Collections.shuffle(cellList);
        int index = 0;
        for(int i = 0; i < getWidth(); i++){
            for(int j = 0; j < getLength(); j++){
                board[i][j] = cellList.get(index++);
            }
        }
    }
}
