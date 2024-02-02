package edu.coe.cs245.exceptions;

public class SpecialSquare extends Square{
    private String SquareType;
    private String Color;
    private int money = 0;
    private int Index;
    @Override
    public void TakeAction(PlayerTurn player,DeckOfCards d, Board b) {
        int br = player.getBankroll();
        if (SquareType.equals("Go"))
        System.out.println(player.getName() + " Landed on go Collect $2");
        else if(SquareType.equals("RestRoom"))
            System.out.println(player.getName()+" Landed on Restroom nothing happens");
        else if(SquareType.equals("GoToRestroom")) {
            System.out.println(player.getName() + " Has to pay $3 dollars and go to the restroom");
            player.setBoardPosition(10);
            br -= 3;
            money += 3;
            player.setBankroll(br);
        }
    }

    public void setSquareType(String squareType) {
        SquareType = squareType;
    }

    @Override
    public void setColor(String color) {
        Color = color;
    }

    @Override
    public String getColor() {
        return Color;
    }

    @Override
    public String getSquareType() {
        return SquareType;
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
