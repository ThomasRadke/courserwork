public class PigGame {
    private PigPlayer p1;
    private PigPlayer p2;
    private PigPlayer winner;
    static private int WIN_SCORE =50;

    public PigGame(){
        p1 = new HumanPlayer("Stan");
        p2 = new BotPlayer("Ollie");
    }

    public PigGame(PigPlayer p1, PigPlayer p2){
        this.p1 = p1;
        this.p2 = p2;
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("New Game!");
        System.out.println(p1.getName() +" vs. " + p2.getName());
        System.out.println("Let's get that bacon shakin\'");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=\n");
        p1.reset();
        p2.reset();
    }

    private void setWinner(PigPlayer p1, PigPlayer p2){
        if (p1.getScore() > p2.getScore()){
            winner = p1;
        }
        else{
            winner = p2;
        }
    }

    private void gameStats(){
        System.out.println("\n************************");
        System.out.print(p1.getName() + ": " + p1.getScore()+ "\t");
        System.out.println(p2.getName() + ": " + p2.getScore());
        System.out.println("************************\n");
    }

    public PigPlayer playGame(){
        while (p1.getScore() < WIN_SCORE && p2.getScore() < WIN_SCORE){
            p1.takeTurn();
            gameStats();
            p2.takeTurn();
            gameStats();
        }
        setWinner(p1,p2);

        return winner;
    }

    public static void main(String[] args) {
        PigGame p = new PigGame();
        PigPlayer  champ = p.playGame();
        System.out.println("Winner: " + champ.getName());
    }
}
