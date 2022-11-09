public class Move {
    public static boolean UP(World w){
        //new position
        int i = w.getPlayerPos()[0] - 1;
        int j = w.getPlayerPos()[1];
        if(!validMove(i, j, w))
            return false;
        w.moveTo(i, j);
        return true;
    }
    public static boolean DOWN(World w){
        int i = w.getPlayerPos()[0] + 1;
        int j = w.getPlayerPos()[1];
        if(!validMove(i, j, w))
            return false;
        w.moveTo(i, j);
        return true;
    }
    public static boolean RIGHT(World w){
        int i = w.getPlayerPos()[0];
        int j = w.getPlayerPos()[1] + 1;
        if(!validMove(i, j, w))
            return false;
        w.moveTo(i, j);
        return true;
    }
    public static boolean LEFT(World w){
        int i = w.getPlayerPos()[0];
        int j = w.getPlayerPos()[1] - 1;
        if(!validMove(i, j, w))
            return false;
        w.moveTo(i, j);
        return true;
    }
    private static boolean validMove(int i, int j, World w){
        if(i < 0 || i >= w.getWidth() || j < 0 || j >= w.getLength())
            return false;
        if(w.getCell(i, j).getType().equals("inaccessible"))
            return false;
        return true;
    }
}
