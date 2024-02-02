package edu.coe.cs245.exceptions;

public class Chance extends Square{
    String color = "Chance";
    private int Index;
    public void Do(PlayerTurn player, Card c,Board b){
        String type = c.GetcardType();
        c.TakeAction(player,b);
        }
    public Card RecieveDeck(DeckOfCards d,Board board){
        try{
            d.count();
        }
        catch (DeckEmptyException e) {
            System.out.println(e);
            d = new DeckOfCards(board);
        }
        //deck.setRemainingCards(deck.getRemainingCards()+1);
        Card card = d.Draw();
        return card;
    }

    @Override
    public void TakeAction(PlayerTurn player, DeckOfCards d,Board b) {
        System.out.println(player.getName() + " Landed on Chance draw a card. ");
        Card c = RecieveDeck(d,b);
        Do(player,c,b);
    }

    @Override
    public void setSquareType(String go) {

    }

    @Override
    public void setColor(String color) {

    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getSquareType() {
        return "Chance";
    }

    @Override
    public void setIndex(int index) {
        Index = index;
    }

    @Override
    public int getIndex() {
        return Index;
    }
}
