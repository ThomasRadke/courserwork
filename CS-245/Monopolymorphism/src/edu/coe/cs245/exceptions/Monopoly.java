package edu.coe.cs245.exceptions;

public class Monopoly {
    public void PlayGame(){
        Board board = new Board();
        DeckOfCards deck = new DeckOfCards(board);
        PlayerTurn player1 = new PlayerTurn();
        PlayerTurn player2 = new PlayerTurn();
        player1.setName("Player 1");
        player2.setName("Player 2");
        while(player1.getBankroll() >=0 && player2.getBankroll() >=0) {
            player1.TakeTurn();
            int r = player1.getRoll();
            System.out.println(player1.getName() +" rolled " + r);
            int p1index = player1.getBoardPosition();
            Square p1tile = board.getTile(p1index);
//            if(p1tile.getColor().equals("Railroad")){
//                System.out.println(player1.getName() + " Landed on " + p1tile.getSquareType());
//                continue;}
            p1tile.TakeAction(player1,deck,board);
            try{
                player1.CheckBalance();
            }
            catch (BankruptException e){
                System.out.println(player1.getName() + " is " + e + " , " + player2.getName() + " Wins.");
                break;
            }

            System.out.println(player1.getName() + " Ended their turn with " + player1.getBankroll() +"$ and " + player1.getownedProperties() + " properties");
            player2.TakeTurn();
            int r1 = player2.getRoll();
            System.out.println(player2.getName() +" rolled " + r1);
            int p2index = player2.getBoardPosition();
            Square p2tile = board.getTile(p2index);
            p2tile.TakeAction(player2,deck,board);
            try{
                player2.CheckBalance();
            }
            catch (BankruptException e){
                System.out.println(player2.getName() + " is " + e + " , " + player1.getName() + " Wins.");
                break;
            }
            System.out.println(player2.getName() + " Ended their turn with " + player2.getBankroll() +"$ and " + player2.getownedProperties() + " properties");
        }
    }


}
