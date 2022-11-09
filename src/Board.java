/*
A Board class that is used to generate a board. Copied from TTT game, and only slight changes are made.
 */
public class Board {
    private int length;
    private int width;
    protected Cell[][] board;// use for internal board tracking

    // Initialize a rectangle board
    public Board(int length, int width) {
        this.length = length;
        this.width = width;
        board = new Cell[width][length];
        int number = 1;

    }

    // Initialize a square board
    public Board(int side) {
        this(side, side);
    }

    // default a 3X3 square
    public Board() {
        this(3);
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public Cell getCell(int row, int col){
        return board[row][col];
    }

    public void setCell(int row, int col, Cell newCell){
        board[row][col] = newCell;
    }
    // for drawing "+---+---" pattern
    private String drawLine1() {
        String str = "";
        for (int i = 0; i < length; i++) {
            str += "+---";
        }
        str += "+\n";
        return str;
    }

    // for drawing "| | " pattern
    private String drawLine2(int row) {
        String str = "";
        for (int i = 0; i < length; i++) {
            str += "| ";
            str += board[row][i];
            str += " ";
        }
        str += "|\n";
        return str;
    }

    public int getNumOfSquares() {
        return length * width;
    }

    public String toString() {
        String boardStr = "";
        for (int i = 0; i < width; i++) {
            boardStr += drawLine1();
            boardStr += drawLine2(i);
        }
        boardStr += drawLine1();
        return boardStr;
    }
}