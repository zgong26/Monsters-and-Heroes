import java.util.*;
public class Main {
    public static void main(String[] args) {
        String choice = "n";
        do{
            Game g = new Game();
            g.start();
            System.out.println("Would you like to continue?(y/n)");
            choice = ErrorControl.StringInput(new String[]{"y", "n"});
        }while(choice.equals("y"));

    }
}