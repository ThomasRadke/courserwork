package edu.coe.cs245.exceptions;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Board {
    private final Square[] board = new Square[32];
    private int tax = 0;

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public Board(){
        board[0] = new SpecialSquare();
        board[0].setSquareType("Go");
        board[1] = new Chance();
        board[2] = new Property();
        board[2].setSquareType("Mediterranean Avenue");
        board[2].setColor("Purple");
        board[2].setIndex(2);
        board[3] = new Property();
        board[3].setSquareType("Baltic Avenue");
        board[3].setColor("Purple");
        board[3].setIndex(3);
        board[4] = new Chance();
        board[5] = new SpecialSquare();
        board[5].setSquareType("Short Line");
        board[5].setColor("Railroad");
        board[6] = new Property();
        board[6].setSquareType("Vermont Avenue");
        board[6].setColor("White");
        board[6].setIndex(6);
        board[7] = new Property();
        board[7].setSquareType("Connecticut Avenue");
        board[7].setColor("White");
        board[7].setIndex(7);
        board[8] = new SpecialSquare();
        board[8].setSquareType("Tax");
        board[9] = new Chance();
        board[10] = new SpecialSquare();
        board[10].setSquareType("RestRoom");
        board[11] = new Property();
        board[11].setSquareType("St. Charles Place");
        board[11].setColor("Pink");
        board[11].setIndex(11);
        board[12] = new Property();
        board[12].setSquareType("States Avenue");
        board[12].setColor("Pink");
        board[12].setIndex(12);
        board[13] = new SpecialSquare();
        board[13].setSquareType("B. & O. Railroad");
        board[13].setColor("Railroad");
        board[14] = new Property();
        board[14].setSquareType("St. James Place");
        board[14].setColor("Orange");
        board[14].setIndex(14);
        board[15] = new Property();
        board[15].setSquareType("Tennessee Avenue");
        board[15].setColor("Orange");
        board[15].setIndex(15);
        board[16] = new SpecialSquare();
        board[16].setSquareType("LooseChange");
        board[17] = new Chance();
        board[18] = new Property();
        board[18].setSquareType("New York Avenue");
        board[18].setColor("Red");
        board[18].setIndex(18);
        board[19] = new Property();
        board[19].setSquareType("Kentucky Avenue");
        board[19].setColor("Red");
        board[19].setIndex(19);
        board[20] = new Chance();
        board[21] = new SpecialSquare();
        board[21].setSquareType("Reading Railroad");
        board[21].setColor("Railroad");
        board[21].setIndex(21);
        board[22] = new Property();
        board[22].setSquareType("Illinois Avenue");
        board[22].setColor("Yellow");
        board[22].setIndex(22);
        board[23] = new Property();
        board[23].setSquareType("Atlantic Avenue");
        board[23].setColor("Yellow");
        board[23].setIndex(23);
        board[24] = new SpecialSquare();
        board[24].setSquareType("Tax");
        board[25] = new Chance();
        board[26] = new SpecialSquare();
        board[26].setSquareType("GoToRestroom");
        board[27] = new Property();
        board[27].setSquareType("Ventor Avenue");
        board[27].setColor("Green");
        board[27].setIndex(27);
        board[28] = new Property();
        board[28].setSquareType("Marvin Gardens");
        board[28].setColor("Green");
        board[28].setIndex(28);
        board[29] = new SpecialSquare();
        board[29].setSquareType("Pennsylvania Railroad");
        board[29].setColor("Railroad");
        board[30] = new Property();
        board[30].setSquareType("Park Place");
        board[30].setColor("Blue");
        board[30].setIndex(30);
        board[31] = new Property();
        board[31].setSquareType("Boardwalk");
        board[31].setColor("Blue");
        board[31].setIndex(31);
    }
    public Square getTile(int n) {
        return board[n];
    }
}