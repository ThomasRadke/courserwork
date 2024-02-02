public class BotPlayer extends PigPlayer{

    public BotPlayer(String name) {
        super(name);
    }

    @Override
    void takeTurn() {
        turnTotal = 0;
        int i = 3;
        while(i != 0){
            lastRoll = d.roll();
            turnTotal += lastRoll;
            printTurnStats();
            if (lastRoll == 1){
                turnTotal = 0;
                System.out.println("\t Rolled 1; no points");
                break;
            }

            i--;
        }
        score += turnTotal;
    }
}
