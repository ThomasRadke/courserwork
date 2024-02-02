import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args)
    {
    JFrame frame = new JFrame("Hello World");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel p = new CounterPanel();
    JPanel f = new FileReaderPanel();

    frame.getContentPane().add(f);
    //frame.getContentPane().add(p);
    frame.pack();
    frame.setVisible(true);

    }
}