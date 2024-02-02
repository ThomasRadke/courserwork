package edu.coe.cs245.exceptions;

abstract public class Square {
    protected String Type;



    public Square(){
        this.Type = "NULL";
    }
    public String getType() {
        return Type;
    }
    public abstract void TakeAction(PlayerTurn player,DeckOfCards d,Board b);

    public abstract void setSquareType(String go);
    public abstract void setColor(String color);
    public abstract String getColor();
    public abstract String getSquareType();
    public abstract void setIndex(int index);
    public abstract int getIndex();
}

