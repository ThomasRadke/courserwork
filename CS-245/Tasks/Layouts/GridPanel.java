import javax.swing.*;
import java.awt.*;

public class GridPanel extends JPanel {
    public GridPanel() {
        JTextArea display = new JTextArea();
        display.setEditable(false);
        add(display);
        setLayout(new GridLayout(4,4));
        setBackground(Color.LIGHT_GRAY);

        JButton b1 = new JButton ("1");
        JButton b2 = new JButton ("2");
        JButton b3 = new JButton ("3");
        JButton b4 = new JButton ("4");
        JButton b5 = new JButton ("5");
        JButton b6 = new JButton ("6");
        JButton b7 = new JButton ("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JButton b0 = new JButton("0");
        JButton be = new JButton("=");
        JButton ba = new JButton("+");
        JButton bs = new JButton("-");
        JButton bd = new JButton("/");
        JButton bm = new JButton("*");



        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        add(b0);
        add(ba);
        add(bs);
        add(bd);
        add(bm);
        add(be);
    }
}