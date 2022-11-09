
/*
 * for handling errors that might occur during a game
 */
import java.util.Scanner;

public class ErrorControl {
    static Scanner in = new Scanner(System.in);

    public static int integerInput(int low, int high) {
        int num = 0;
        boolean valid = false;
        do {
            String str = in.nextLine();
            try {
                num = Integer.parseInt(str);

            } catch (Exception e) {
                System.out.println("Invalid input. \nPlease enter a valid integer between " + low + " and " + high);
                continue;
            }
            if (num >= low && num <= high)
                valid = true;
            else {
                valid = false;
                System.out.printf("Invalid input. \nPlease enter a valid integer between %d and %d\n", low, high);
            }
        } while (!valid);
        return num;
    }


    public static String StringInput(String[] allowed){
        boolean valid = false;
        String str;
        do {
            str = in.nextLine().toLowerCase();
            for(String s : allowed){
                if(s.equals(str))
                    valid = true;
            }
            if(!valid){
                System.out.println("Invalid input, please re-enter: ");
            }
        } while (!valid);
        return str;
    }
}