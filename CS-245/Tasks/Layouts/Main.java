import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300,400));

        GridPanel tp = new GridPanel();
        frame.getContentPane().add(tp);
        frame.pack();
        frame.setVisible(true);
    }
}
