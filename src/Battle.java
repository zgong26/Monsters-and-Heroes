import java.util.Scanner;

public class Battle {
    private HeroTeam heroes;
    private MonsterTeam monsters;
    private boolean gameover;
    Scanner in = new Scanner(System.in);

    public Battle(HeroTeam hs, MonsterTeam ms) {
        heroes = hs;
        monsters = ms;
        gameover = false;
    }

    public void startBattle() {
        System.out.println("Encountered " + monsters.size() + " monsters!\nBattle start!\n");
        while (!gameover) {
            heroRound();
            monsterRound();
        }
    }

    private void heroRound() {
        heroes.displayHeroes();
        Hero next = heroes.nextAvailableHero();
        System.out.printf("\n%s's turn!\n");
        System.out.println("Choose an option: ");
        System.out.println("Attack(a)");
        System.out.println("Cast a spell from inventory(s)");
        System.out.println("Use a potion from inventory(p)");
        System.out.println("Equip weapon/armor(e)");
        System.out.println("Display battle info(i)");
        String choice = ErrorControl.StringInput(new String[]{"a", "s", "p", "e", "i"});
        while(choice.equals("i")){
            info();
        }
        switch (choice) {
            case "a":
                attack();
                break;
            case "s":
                spell();
            case "p":
                potion();
                break;
            case "e":
                equip();
                break;
            case "i":
                info();
                break;
            default:
                break;
        }
    }

    private void attack() {

    }

    private void spell() {
    }

    private void potion() {
    }

    private void info(){
        System.out.println("Heroes: ");
        heroes.displayStatistics();
        System.out.println("\nMonsters: ");
        monsters.displayStatistics();
    }

    private void equip() {
    }

    private void monsterRound() {
    }

}
