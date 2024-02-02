package edu.coe.cs245.exceptions;

public class LooseChange extends Square{
    @Override
    public void TakeAction(PlayerTurn player, DeckOfCards d, Board b) {
        System.out.println(player.getName() + " Found some loose change, How'd that get there?");
        int m = b.getTax();
        int f = player.getBankroll();
        f += m;
        player.setBankroll(f);
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
