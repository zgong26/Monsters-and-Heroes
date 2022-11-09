import java.util.*;

public class World extends Board{
    private double inaccessiblePercent;
    private double commonPercent;
    private double marketPercent;

    private int[] playerPos;

    public World(int size, int inaccessiblePercent, int commonPercent, int marketPercent){
        super(size);
        this.inaccessiblePercent = 0.01 * inaccessiblePercent;
        this.commonPercent = 0.01 * commonPercent;
        this.marketPercent = 0.01 * marketPercent;
        playerPos = new int[2];
        playerPos[0] = 0;
        playerPos[1] = 0;
    }

    public World(int size){
        this(size, 20, 50, 30);
    }

    //default world
    public World(){
        this(8);
    }

    public int[] getPlayerPos(){
        return playerPos;
    }

    //this method is used to generate a random world
    public void generateWorld(){
        int numCell = getNumOfSquares();
        int inaccNum = (int) (numCell * inaccessiblePercent);
        int marketNum = (int)(numCell * marketPercent);
        int commonNum = numCell - inaccNum - marketNum;

        //make sure the player doesn't get blocked at the first place
        board[0][0] = new Cell("common");
        board[0][1] = new Cell("common");
        board[1][0] = new Cell("common");
        commonNum -= 3;

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
                if((board[i][j] == null))
                    board[i][j] = cellList.get(index++);
            }
        }

        //place the player onto the top left corner
        board[playerPos[0]][playerPos[1]].setPlayer(true);
    }

    public void moveTo(int i, int j){
        board[playerPos[0]][playerPos[1]].setPlayer(false);//remove player on the board
        playerPos[0] = i;//reassign pos
        playerPos[1] = j;
        board[playerPos[0]][playerPos[1]].setPlayer(true);//place player on new pos
    }
}
