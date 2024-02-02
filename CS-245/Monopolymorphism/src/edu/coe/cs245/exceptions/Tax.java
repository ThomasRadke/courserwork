package edu.coe.cs245.exceptions;

public class Tax extends Square{
    @Override
    public void TakeAction(PlayerTurn player, DeckOfCards d, Board b) {
        System.out.println(player.getName() + " landed on a tax square, pay $2 to Uncle Sam");
        int m = b.getTax();
        int f = player.getBankroll();
        f -= 2;
        player.setBankroll(f);
        b.setTax(m+3);
    }

    @Override
    public void setSquareType(String go) {

    }

    @Override
    public void setColor(String color) {

    }

    @Override
    public String getColor() {
        return null;
    }

    @Override
    public String getSquareType() {
        return null;
    }

    @Override
    public void setIndex(int index) {

    }

    @Override
    public int getIndex() {
        return 0;
    }
}
