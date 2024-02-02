package edu.coe.cs245.exceptions;

public class GotoCard extends Card{
    private Square property;
    private String Color;
    private String cardType;

    GotoCard(){

    }

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
        int index = property.getIndex();
        int index2 = player.getBoardPosition();
        int br = player.getBankroll();
        if(index > index2){
            br += 2;
            player.setBankroll(br);
            System.out.println(player.getName() + " Passed go Collect $2");
        }
        player.setBoardPosition(index);
        Square s = b.getTile(index);
        s.TakeAction(player,null,b);

        System.out.println(player.getName() + " Move's to " + property.getSquareType());
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
