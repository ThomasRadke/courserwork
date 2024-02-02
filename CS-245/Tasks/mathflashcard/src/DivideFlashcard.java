import java.util.Random;

public class DivideFlashcard extends FlashCard{

    private Random number = new Random();
    private int Operand;
    private int Operee;
    private int answer;
    private String equation;

    @Override
    public void GenerateAnswer() {
        GenerateProblem();
        answer = Operee / Operand;
        equation = Operee + " / " + Operand;
    }

    @Override
    public void GenerateProblem() {
        int multiplier = number.nextInt(10);
        multiplier += 1;
        Operand = number.nextInt(10);
        Operee = Operand * multiplier;
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
