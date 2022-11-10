import java.util.*;

public class Game {
    private HeroTeam heroes;
    private MonsterTeam monsters;
    private World world;
    private String state;//The state of the game(map, battle, market)
    Scanner in = new Scanner(System.in);
    private HashMap<Integer, Market> marketMap;

    public Game() {
        heroes = new HeroTeam();
        monsters = new MonsterTeam();
        state = "map";
        marketMap = new HashMap<>();
    }

    public void start() {
        displayWelcome();
        new ItemCollection();
        new MonsterCollection();
        new HeroCollection();
        pickHeroes();
        System.out.println("Please enter the world size(between 5 to 10), default is 8");
        int size = ErrorControl.integerInput(5, 10);
        world = new World(size);
        world.generateWorld();
        for (int i : world.getMarketID()) {
            marketMap.put(i, new Market());
        }
        while (!state.equals("exit")) {
            switch (state) {
                case "map":
                    mapState();
                    break;
                case "battle":
                    battleState();
                    break;
                case "market":
                    marketState();
                    break;
                case "lost":
                    lostState();
                    break;
                default:
                    break;
            }
        }
    }

    private void lostState() {
    }

    private void pickHeroes() {
        HeroCollection.printAll();
        System.out.println("Please pick up to 3 heroes to join your adventure!\nEnter '0' to end pick");
        int i = 0;
        ArrayList<Integer> picked = new ArrayList<>();
        while (i < 3) {
            System.out.println("Please pick('0' to end): ");
            int pick = ErrorControl.integerInput(0, HeroCollection.size());
            if (pick == 0 && i == 0) {
                System.out.println("You must pick at least one hero!");
            } else if (pick == 0) {
                break;
            } else if (picked.contains(pick)) {
                System.out.println("You already picked this hero!");
            } else {
                Hero pickedHero = HeroCollection.get(pick);
                heroes.addHero(pickedHero);
                System.out.printf("%s picked!\n", pickedHero.getName());
                picked.add(pick);
                i++;
            }
        }
    }

    private void mapState() {
        System.out.println(world);
        boolean marketOption = false;
        System.out.println("Enter 'w s a d' to move");
        System.out.println("'i' to display heroes' inventory");
        if (world.getPlayerCell().getType().equals("market")) {
            marketOption = true;
            System.out.println("'m' to open market");
        }
        System.out.println("'exit' to exit the game");
        String[] validInput = {"w", "s", "a", "d", "m", "i", "exit"};
        String choice = ErrorControl.StringInput(validInput).toLowerCase();
        boolean validMove = true;
        boolean moveChoice = false;//track whether player makes a move
        switch (choice) {
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
                if (!marketOption) {
                    System.out.println("You can only go to market when you are on the market cell!");
                } else {
                    state = "market";
                }
                break;
            case "i":
                inventoryState();
                break;
            case "exit":
                state = "exit";
            default:
                break;
        }
        if (!validMove)
            System.out.println("Invalid move");
        if (moveChoice && validMove && world.getPlayerCell().getType().equals("common")) {
            //only when met these three conditions, calculate if next move will encounter monsters
            //20% chance to encounter monsters
            double rand = Math.random() * 100;
            if (rand <= 20)
                state = "battle";
        }
    }

    private void battleState() {
        ArrayList<Monster> allMonsters = MonsterCollection.getMonsters();
        Collections.shuffle(allMonsters);
        int index = 0;
        for (int i = 0; i < heroes.size(); i++) {
            while (true) {
                Monster m = allMonsters.get(index);
                index++;
                if (m.getLevel() <= heroes.getHighestLevel() && m.getLevel() >= Math.min(heroes.getHighestLevel() - 3, 10)) {
                    monsters.addMonster(m);
                    break;
                }
            }
        }
        Battle b = new Battle(heroes, monsters);
        boolean heroLost = b.startBattle();
        if (heroLost)
            state = "lost";
        else {
            System.out.println("Congrats! Your heroes defeated monsters!\n");
            ArrayList<Integer> unfaintedIndices = heroes.getUnfaintedIndices();
            for (int i : unfaintedIndices) {
                Hero hero = heroes.getHero(i + 1);
                hero.setHP((int) (1.1 * hero.getHP()));
                hero.setMana((int) (1.1 * hero.getMana()));
                hero.addExp(heroes.size() * 2);
                int gold = monsters.levelSum() * 100;
                hero.addGold(gold);
                System.out.println(hero.getName() + ": ");
                System.out.println("HP/Mana recovered");
                System.out.printf("Gained %d experience points\n", heroes.size() * 2);
                System.out.printf("Gained %d gold\n", gold);
                if (hero.updateLevel())
                    System.out.println("\nLevel UP!!!\nNow level " + hero.getLevel() + "\n");
                System.out.printf("");
            }
            state = "map";
        }
    }

    private void marketState() {
        Market m = marketMap.get(world.getPlayerCell().getId());
        System.out.println("Welcome to the market!\n");
        while (true) {
            m.displayMenu();
            System.out.println("\nWhich hero would like to make the trade? '0' to leave market.");
            heroes.displayHeroes();
            int choice = ErrorControl.integerInput(0, heroes.size());
            if (choice == 0)
                break;
            Hero h = heroes.getHero(choice);
            hero_market_menu(h, m);
        }
        state = "map";
    }

    private void hero_market_menu(Hero h, Market m) {
        while (true) {
            System.out.println("\nHero " + h.getName() + ", choose an option: \nbuy(b)\nsell(s)\ncheck inventory(i)\nchoose another hero(q)");
            System.out.println("Your current gold is " + h.getGold());
            String ans = ErrorControl.StringInput(new String[]{"b", "s", "i", "q"});
            if (ans.equals("q"))
                break;
            Inventory inventory = h.getInventory();
            switch (ans) {
                case "b":
                    if (m.size() == 0) {
                        System.out.println("Market is empty!");
                    } else {
                        while (true) {
                            m.displayMenu();
                            System.out.println("Which item would you like to buy? '0' to quit");
                            int choice = ErrorControl.integerInput(0, m.size());
                            if (choice == 0)
                                break;
                            Item item = m.get(choice);
                            if (h.getGold() < item.getPrice()) {
                                System.out.println("You are too poor to buy this item.\n");
                            } else {
                                h.addItem(m.sell(choice));
                                h.addGold(item.getPrice() * -1);
                                System.out.println("Success! " + item.getName() + " added to your inventory\n");
                                System.out.println("Your gold is now " + h.getGold());
                            }
                        }
                    }
                    break;
                case "s":
                    if (inventory.size() == 0) {
                        System.out.println("Your inventory is empty!");
                    } else {
                        while (true) {
                            System.out.println("Your inventory: ");
                            inventory.displayInventory();
                            System.out.println("Which item would you like to sell? '0' to quit");
                            int choice = ErrorControl.integerInput(0, inventory.size());
                            if (choice == 0)
                                break;
                            int earn = m.buy(h.getItem(choice));
                            h.addGold(earn);
                            h.removeItem(choice);
                            System.out.println("Sold! Current gold: " + h.getGold());
                        }
                    }
                    break;
                case "i":
                    if (inventory.size() == 0)
                        System.out.println("Your inventory is empty!");
                    else {
                        inventory.displayInventory();
                    }
                    break;
                default:
                    break;
            }
        }

    }

    private void inventoryState() {
        System.out.println("");
        for(int i = 1; i <= heroes.size(); i++){
            System.out.println(heroes.getHero(i).getName()+": ");
            heroes.getHero(i).getInventory().displayInventory();
        }
    }

    private void displayWelcome() {
        System.out.println("Welcome");
    }
}
