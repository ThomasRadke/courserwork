import java.util.Random;
abstract public class FlashCard {
    private Random operand;
    private Random operee;
    private char operator;
    private int answer;
    private String equation;

    public void FlashCard(){
        this.operand = new Random();
        this.operee = new Random();
    }
    public abstract void GenerateAnswer();
    public abstract void GenerateProblem();

    public abstract int getAnswer();

    public abstract String getEquation();
}
