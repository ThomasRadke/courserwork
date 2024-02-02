import javax.naming.OperationNotSupportedException;
import java.util.Random;
import java.util.Scanner;

public class AddFlashcard extends FlashCard{
    private Random number = new Random();
    private int Operand;
    private int Operee;
    private int answer;
    private String equation;

    public AddFlashcard(){
        Operee = 0;
        Operand = 0;
        answer = 0;
    }


    @Override
    public void GenerateAnswer() {
        GenerateProblem();
        answer = Operand + Operee;
        equation = Operand + " + " + Operee;
    }

    @Override
    public void GenerateProblem() {
        Operand = number.nextInt(10);
        Operee = number.nextInt(10);

    }

    @Override
    public int getAnswer() {
        return answer;
    }

    @Override
    public String getEquation() {
        return equation;
    }
}
