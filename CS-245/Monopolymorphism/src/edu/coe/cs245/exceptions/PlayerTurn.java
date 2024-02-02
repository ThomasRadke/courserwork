package edu.coe.cs245.exceptions;

import java.util.Random;

public class PlayerTurn {
    boolean won = false;
    private int Bankroll;
    private Property[] OwnedProperties = new Property[20];
    private int BoardPosition = 0;
    private int ownedProperties = 0;
    private String name;
    private Die die = new Die();
    int roll;

    public PlayerTurn(){
        this.Bankroll = 31;
        // this.OwnedProperties[0] = "Nothing";
    }

    public int getRoll() {
        return roll;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void TakeTurn(){
        roll = die.roll();
        BoardPosition += roll;
        if (BoardPosition >= 31){
            BoardPosition = BoardPosition%32;
            System.out.println(name + " passed go collect 2$");
            Bankroll += 2;
        }
    }
    public void CheckMonopoly(Property sqr, PlayerTurn player){
        Property[] props = player.getOwnedProperties();
        String col = sqr.getColor();
        for(int i = 0; i < props.length; i++){
            if (props[i].getColor().equals(col));
            sqr.setMonopoly(true);
        }
    }

    public void Buy(Property property){
        property.SetWorth();
        int val = property.getValue();
        this.Bankroll -= val;
        OwnedProperties[ownedProperties] = property;
        ownedProperties++;
        property.setOwner(this);
        property.setOwned(true);
        System.out.println( name + " landed on " + property.getSquareType() + " and buys it for " + val + " dollars");
    }

    public void Pay(Property property){
        property.SetWorth();
        int val = property.getValue();
        PlayerTurn owner = property.getOwner();
        if (property.isMonopoly())
            val *= 2;
        this.Bankroll -= val;
        owner.Bankroll += val;
        System.out.println(name + " landed on " + property.getSquareType() + " and must pay " + val + " dollars to " + owner.getName());

    }
    public void CheckBalance(){
        if(Bankroll <= 0){
            throw new BankruptException("Out of cash");
        }
    }

    public int getBankroll() {
        return Bankroll;
    }

    public void setBankroll(int bankroll) {
        Bankroll = bankroll;
    }

    public Property[] getOwnedProperties() {
        return OwnedProperties;
    }

    public int getBoardPosition() {
        return BoardPosition;
    }

    public void setBoardPosition(int boardPosition) {
        BoardPosition = boardPosition;
    }

    public String getName() {
        return name;
    }

    public int getownedProperties(){
        return ownedProperties;
    }
}