import java.util.*;
public class Main {
    public static void main(String[] args) {
        /*
        Scanner in = new Scanner(System.in);
        World w = new World();
        w.generateWorld();
        while(true){
            System.out.println(w);
            String direction = in.nextLine();
            switch (direction){
                case "w":
                    Move.UP(w);
                    break;
                case "s":
                    Move.DOWN(w);
                    break;
                case "a":
                    Move.LEFT(w);
                    break;
                case "d":
                    Move.RIGHT(w);
                    break;
                default:
                    break;
            }

        }
        */

        Game g = new Game();
        g.start();
    }
}