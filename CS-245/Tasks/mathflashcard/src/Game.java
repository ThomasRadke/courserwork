import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private ArrayList<FlashCard> cards = new ArrayList<>();
    private int answer;
    private int score;
    private String equation;
    private Scanner guess = new Scanner(System.in);
    public void Game(){
        int i = 10;
        Generate_Cards();
        while (i >= 0){
            cards.get(i).GenerateProblem();
            cards.get(i).GenerateAnswer();
            answer = cards.get(i).getAnswer();
            equation = cards.get(i).getEquation();
            System.out.println(equation);
            int playeranswer = guess.nextInt();
            if(playeranswer == answer){
                System.out.println("Correct!");
                score++;
            }
            else{
                System.out.println("Incorrect!");
            }
            System.out.println("Player has " + score + " points");
            i--;
            }
        System.out.println("Player finished with " + score + " points");

    }

    public void Generate_Cards(){
        int i = 0;
        while(i <= 10){
            Random operatorindex = new Random();
            int index = operatorindex.nextInt(4);
            index += 1;
            if(index == 1){
                cards.add(new AddFlashcard());
                cards.get(i).GenerateProblem();
                cards.get(i).GenerateProblem();
            }
            if(index == 2){
                cards.add(new DivideFlashcard());
                cards.get(i).GenerateProblem();
                cards.get(i).GenerateProblem();
            }
            if(index == 3){
                cards.add(new MultiplyFlashcard());
                cards.get(i).GenerateProblem();
                cards.get(i).GenerateProblem();
            }
            if(index == 4){
                cards.add(new subtractFlashcard());
                cards.get(i).GenerateProblem();
                cards.get(i).GenerateProblem();
            }
            i++;
        }


    }
}
