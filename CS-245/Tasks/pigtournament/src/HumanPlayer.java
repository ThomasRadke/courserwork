import java.util.Scanner;

public class HumanPlayer extends PigPlayer{

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    void takeTurn() {
        boolean rolling = true;
        Scanner scan = new Scanner(System.in);
        System.out.println(name+"'s turn");
        turnTotal = 0;
        lastRoll = d.roll();
        while (lastRoll != 1 && rolling){
            turnTotal += lastRoll;
            printTurnStats();
            System.out.print("\t Roll Again (y/n)");
            rolling = scan.next().equals("y");
            if(rolling){
                lastRoll = d.roll();
            }
        }
        if (lastRoll == 1){
            turnTotal = 0;
            System.out.println("\t Rolled 1; no points");
        }
        score += turnTotal;
    }
}
