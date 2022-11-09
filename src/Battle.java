import java.util.Scanner;

public class Battle {
    private HeroTeam heroes;
    private MonsterTeam monsters;
    private boolean gameover;
    Scanner in = new Scanner(System.in);

    public Battle(HeroTeam hs, MonsterTeam ms){
        heroes = hs;
        monsters = ms;
        gameover = false;
    }
    
    public void startBattle(){
        while(!gameover){
            heroRound();
            monsterRound();
        }
    }

    private void monsterRound() {
    }

    private void heroRound() {
    }
}
