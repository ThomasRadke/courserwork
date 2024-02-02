import java.util.Scanner;

public class PigPlayer {
    private int score;
    private String name;
    private int turnTotal;
    private Die d;
    int lastRoll;
    public PigPlayer(String name){
        this.name = name;
        d = new Die();
        turnTotal = 0;
        score = 0;
    }

    public String getName(){
        return name;
    }

    public void takeTurn(){

        boolean rolling = true;
        Scanner scan = new Scanner(System.in);

        lastRoll = d.roll();

        while(lastRoll != 1 && rolling){
            turnTotal += lastRoll;
            printTurnStats();
            System.out.println("Roll Again (y/n)");
            rolling = scan.next().equals("y");
            if(rolling){
                lastRoll = d.roll();
            }
        }
        if(lastRoll == 1){
            turnTotal = 0;
            System.out.println("\t Rolled 0; no points");
        }
        score += turnTotal;
        turnTotal = 0;
    }

    private void printTurnStats(){
        System.out.print("\t Last Roll: " + lastRoll);
        System.out.print("\t Turn Total: " + turnTotal);
        System.out.println("\t Score: " + (score + turnTotal));    }

}


