import java.util.Scanner;

abstract public class PigPlayer {
    protected int score;
    protected String name;
    protected int turnTotal;
    protected Die d;
    int lastRoll;

    public PigPlayer(String name) {
        this.name = name;
        d = new Die();
        turnTotal = 0;
        score = 0;
    }
    public void reset(){
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    abstract void takeTurn ();

    protected void printTurnStats(){
        System.out.print("\t Last Roll: "+lastRoll);
        System.out.print("\t Turn Total: "+ turnTotal);
        System.out.println("\t Score: "+ (score + turnTotal));
    }
}
