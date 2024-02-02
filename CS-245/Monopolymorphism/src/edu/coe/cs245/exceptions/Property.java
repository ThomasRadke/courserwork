package edu.coe.cs245.exceptions;

public class Property extends Square{
    private String SquareType;
    private String Color;
    private int value;
    private boolean isOwned = false;
    private boolean isMonopoly = false;
    private int Index;

    public boolean isMonopoly() {
        return isMonopoly;
    }

    public void setMonopoly(boolean monopoly) {
        isMonopoly = monopoly;
    }

    public PlayerTurn getOwner() {
        return owner;
    }

    public void setOwner(PlayerTurn owner) {
        this.owner = owner;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    private PlayerTurn owner = new PlayerTurn();

    public void setOwned(boolean owned) {
        isOwned = owned;
    }

    @Override
    public void TakeAction(PlayerTurn player,DeckOfCards d, Board b) {
        if(isOwned)
            player.Pay(this);
        if(!isOwned)
            player.Buy(this);
    }

    public int getValue() {
        return value;
    }

    public void SetWorth(){
        if(Color.equals("Purple")){
            this.value = 1;
        }
        else if(Color.equals("White")){
            this.value = 2;
        }
        else if(Color.equals("Pink")){
            this.value = 2;
        }
        else if(Color.equals("Orange")){
            this.value = 3;
        }
        else if(Color.equals("Red")){
            this.value = 3;
        }
        else if(Color.equals("Yellow")){
            this.value = 4;
        }
        else if(Color.equals("Green")){
            this.value = 4;
        }
        else if(Color.equals("Blue")){
            this.value = 5;
        }
    }

    @Override
    public void setSquareType(String squareType) {
        SquareType = squareType;
    }

    public String getSquareType() {
        return SquareType;
    }

    @Override
    public void setIndex(int index) {
        Index = index;
    }

    @Override
    public int getIndex() {
        return 0;
    }
}
