import java.util.*;
public class Game {
    private HeroCollection heroes;
    private MonsterCollection monsters;
    private World world;
    private String state;//The state of the game(map, battle, market)
    Scanner in = new Scanner(System.in);

    public Game(){
        heroes = new HeroCollection();
        MonsterCollection monsters = new MonsterCollection();
        state = "map";
    }

    public void start(){
        displayWelcome();
        System.out.println("Please enter the world size(between 5 to 10), default is 8");
        int size = ErrorControl.integerInput(5, 10);
        world = new World(size);
        world.generateWorld();
        while(!state.equals("exit")){
            switch (state){
                case "map":
                    mapState();
                    break;
                case "battle":
                    battleState();
                    break;
                case "market":
                    marketState();
                    break;
                default:
                    break;
            }
        }
    }

    private void mapState(){
        System.out.println(world);
        boolean marketOption = false;
        System.out.println("Enter 'w s a d' to move");
        System.out.println("'i' to display heroes' inventory");
        if(world.getPlayerCell().getType().equals("market")){
            marketOption = true;
            System.out.println("'m' to open market");
        }
        System.out.println("'quit' to exit the game");
        String[] validInput = {"w", "s", "a", "d", "m", "i", "quit"};
        String choice = ErrorControl.StringInput(validInput).toLowerCase();
        boolean validMove = true;
        boolean moveChoice = false;//track whether player makes a move
        switch (choice){
            case "w":
                validMove = Move.UP(world);
                moveChoice = true;
                break;
            case "s":
                validMove = Move.DOWN(world);
                moveChoice = true;
                break;
            case "a":
                validMove = Move.LEFT(world);
                moveChoice = true;
                break;
            case "d":
                validMove = Move.RIGHT(world);
                moveChoice = true;
                break;
            case "m":
                if(!marketOption){
                    System.out.println("You can only go to market when you are on the market cell!");
                }
                else{
                    state = "market";
                }
                break;
            case "i":
                inventoryState();
                break;
            case "quit":
                state = "exit";
            default:
                break;
        }
        if(!validMove)
            System.out.println("Invalid move");
        if(moveChoice && validMove && world.getPlayerCell().getType().equals("common")){
            //only when met these three conditions, calculate if next move will encounter monsters
            //16% chance to encounter monsters
            double rand = Math.random() * 100;
            if(rand <= 16)
                state = "battle";
        }
    }

    private void battleState(){
        System.out.println("battle");
    }

    private void marketState(){
        System.out.println("market");
    }

    private void inventoryState(){
        System.out.println("inventory");
    }

    private void displayWelcome(){
        System.out.println("Welcome");
    }
}
