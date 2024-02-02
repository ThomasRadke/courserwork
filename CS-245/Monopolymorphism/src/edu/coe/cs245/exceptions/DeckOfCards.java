package edu.coe.cs245.exceptions;

import java.util.ArrayList;
import java.util.Random;

public class DeckOfCards{
    private ArrayList<Card> card = new ArrayList<>();
    private int gotoindex;
    private int remainingCards = 23;

    public DeckOfCards(Board board){
        card.add(0,new GotoCard());
        card.get(0).setSquare(board.getTile(2));
        card.get(0).SetcardType("GoTo");
        card.add(1,new GotoCard());
        card.get(1).setSquare(board.getTile(3));
        card.get(1).SetcardType("GoTo");
        card.add(2,new GotoCard());
        card.get(2).setSquare(board.getTile(6));
        card.get(2).SetcardType("GoTo");
        card.add(3,new GotoCard());
        card.get(3).setSquare(board.getTile(7));
        card.get(3).SetcardType("GoTo");
        card.add(4,new GotoCard());
        card.get(4).setSquare(board.getTile(11));
        card.get(4).SetcardType("GoTo");
        card.add(5,new GotoCard());
        card.get(5).setSquare(board.getTile(12));
        card.get(5).SetcardType("GoTo");
        card.add(6,new GotoCard());
        card.get(6).setSquare(board.getTile(14));
        card.get(6).SetcardType("GoTo");
        card.add(7,new GotoCard());
        card.get(7).setSquare(board.getTile(15));
        card.get(7).SetcardType("GoTo");
        card.add(8, new GotoCard());
        card.get(8).setSquare(board.getTile(18));
        card.get(8).SetcardType("GoTo");
        card.add(9, new GotoCard());
        card.get(9).setSquare(board.getTile(19));
        card.get(9).SetcardType("GoTo");
        card.add(10,new GotoCard());
        card.get(10).setSquare(board.getTile(22));
        card.get(10).SetcardType("GoTo");
        card.add(11,new GotoCard());
        card.get(11).setSquare(board.getTile(23));
        card.get(11).SetcardType("GoTo");
        card.add(12,new GotoCard());
        card.get(12).setSquare(board.getTile(27));
        card.get(12).SetcardType("GoTo");
        card.add(13,new GotoCard());
        card.get(13).setSquare(board.getTile(28));
        card.get(13).SetcardType("GoTo");
        card.add(14,new GotoCard());
        card.get(14).setSquare(board.getTile(30));
        card.get(14).SetcardType("GoTo");
        card.add(15,new GotoCard());
        card.get(15).setSquare(board.getTile(31));
        card.get(15).SetcardType("GoTo");
        card.add(16,new FTBCard());
        card.get(16).setColor("Purple");
        card.get(16).SetcardType("FTB");
        card.add(17,new FTBCard());
        card.get(17).setColor("White");
        card.get(17).SetcardType("FTB");
        card.add(18,new FTBCard());
        card.get(18).setColor("Pink");
        card.get(18).SetcardType("FTB");
        card.add(19,new FTBCard());
        card.get(19).setColor("Orange");
        card.get(19).SetcardType("FTB");
        card.add(20,new FTBCard());
        card.get(20).setColor("Red");
        card.get(20).SetcardType("FTB");
        card.add(21,new FTBCard());
        card.get(21).setColor("Yellow");
        card.get(21).SetcardType("FTB");
        card.add(22,new FTBCard());
        card.get(22).setColor("Green");
        card.get(22).SetcardType("FTB");
        card.add(23,new FTBCard());
        card.get(23).setColor("Blue");
        card.get(23).SetcardType("FTB");
    }

    public void count(){
        if (remainingCards == 0){
            throw new DeckEmptyException("Deck is empty reshuffling");
        }
    }

    public Card Draw(){
        Random rand = new Random();
        int index = rand.nextInt(remainingCards);
        remainingCards--;
        Card draw = card.get(index);
        card.remove(index);
        return draw;
    }

    public void setRemainingCards(int remainingCards) {
        this.remainingCards = remainingCards;
    }

    public int getRemainingCards() {
        return remainingCards;
    }
}
