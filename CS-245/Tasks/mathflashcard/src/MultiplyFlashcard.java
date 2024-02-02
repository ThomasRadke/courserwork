import java.util.Random;

public class MultiplyFlashcard extends FlashCard{

    private Random number = new Random();
    private int Operand;
    private int Operee;
    private int answer;
    private String equation;

    @Override
    public void GenerateAnswer() {
        GenerateProblem();
        answer = Operand * Operee;
        equation = Operand + " * " + Operee;
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
