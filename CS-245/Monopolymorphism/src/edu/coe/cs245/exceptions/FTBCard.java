package edu.coe.cs245.exceptions;

public class FTBCard extends Card{
    private Square property;
    private String Color;
    private String cardType;

    @Override
    public String GetcardType() {
        return cardType;
    }

    @Override
    public String getColor() {
        return Color;
    }

    @Override
    public void SetcardType(String CardType) {
        cardType = CardType;
    }

    @Override
    public void TakeAction(PlayerTurn player,Board b) {
        System.out.println(player.getName() + " gets a free ticket booth");
    }

    @Override
    public Square getSquare() {
        return property;
    }

    @Override
    public void setSquare(Square square) {
        property = square;
    }

    @Override
    public void setColor(String color) {
        Color = color;
    }
}
