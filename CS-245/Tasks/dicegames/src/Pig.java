import java.util.Random;
import java.util.Scanner;

public class Pig {
    private static int P1 = 1;
    private static int P2 = 2;
    private static int Bench = 100;

    private int PTurn;
    private int P1P;
    private int P2P;

    private String Scores(){
        return "It is " + PTurn + "'s turn. Player 1 has " + P1P + " points and Player 2 has " + P2P + " Points.";
    }

    private void Turn(int Points){
        System.out.println("Input 0 to roll and 1 to hold");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        if (choice == 0){
            Random rand = new Random();
            int roll = rand.nextInt(6)+1;
            if (roll == 1){
                System.out.println("Player " + PTurn + " Has rolled 1 :(");
            }
            else {
                System.out.println("Player " + PTurn + " Has Rolled " + roll);
                int Score = Points + roll;
                Turn(Score);
            }
        }
        else {
            if (PTurn == 1){
                P1P = P1P + Points;
            }
            else {
                P2P = P2P + Points;
            }
        }
    }
    private void WhosTurn(){
        System.out.println(Scores());
        Turn(0);
        PTurn = 2;
        System.out.println("Player 2 Go!");
        Turn(0);
        PTurn = 1;
        System.out.println("Player 1 Go!");
    }

    private boolean IsOver(){
        boolean p1wins = P1P >= Bench;
        boolean p2wins = P2P >= Bench;
        if(p1wins)
            System.out.println("Player 1 Wins!");
        if(p2wins)
            System.out.println("Player 2 Wins!");
        return p1wins || p2wins;
    }

    public void Game(){
        PTurn = 1;
        P1P = 0;
        P2P = 0;

        while(!IsOver())
            WhosTurn();
    }

}
