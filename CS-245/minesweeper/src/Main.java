import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mine Sweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setPreferredSize(new Dimension(450,600));

        MSPanelL ms = new MSPanelL(10,10,0.2);
        frame.getContentPane().add(ms);

        frame.pack();
        frame.setVisible(true);
    }
}