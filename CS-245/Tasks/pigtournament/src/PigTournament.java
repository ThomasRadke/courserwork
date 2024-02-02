import java.util.LinkedList;
import java.util.Queue;

public class PigTournament {
    Queue<PigPlayer> players;

    public PigTournament() {
        // Tournament has 4 players:
        players = new LinkedList<PigPlayer>();    // WHAT IS THIS VOODOO!!!!!!
        players.add(new HumanPlayer("Porky"));
        players.add(new HumanPlayer("Wilbur"));
        players.add(new HumanPlayer("Napolean"));
        players.add(new HumanPlayer("Waddles"));
    }

    public PigPlayer runTournament(){
        while (players.size()>1){
            PigPlayer p1 = players.remove();
            PigPlayer p2 = players.remove();
            PigGame g = new PigGame(p1,p2);
            PigPlayer winner = g.playGame();
            System.out.println(winner.getName()+ " Advances!");
            players.add(winner);
        }
        return players.remove();
    }

    public static void main(String[] args) {
        PigTournament pt = new PigTournament();
        PigPlayer winner = pt.runTournament();
        System.out.println("Tournament champ: " + winner.getName());
    }
}