package edu.coe.cs245.exceptions;

public abstract class Card {
    private Property square;
    private String color;
    private String cardType;

    public abstract String GetcardType();
    public abstract String getColor();
    public abstract void SetcardType(String CardType);
    public abstract void TakeAction(PlayerTurn player,Board b);
    public abstract Square getSquare();
    public abstract void setSquare(Square square);
    public abstract void setColor(String color);
}
