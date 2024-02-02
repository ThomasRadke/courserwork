import com.sun.java.swing.plaf.windows.WindowsFileChooserUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReaderPanel extends JPanel {
    private JTextField Infile;
    private JButton open;
    private JTextField line;
    private JButton read;
    private Scanner scan;

    public FileReaderPanel() {
        super();
        setPreferredSize(new Dimension(500,100));
        Infile = new JTextField();
        Infile.setColumns(25);
        open = new JButton("Open");
        line = new JTextField();
        line.setColumns(25);
        read = new JButton("Read");
        read.setEnabled(false);
        ButtonListener bl = new ButtonListener();
        open.addActionListener(bl);
        read.addActionListener(bl);
        add(Infile);
        add(open);
        add(line);
        add(read);

    }


    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String p = "";
            if (e.getSource() == open) {
                try {
                    String filename = Infile.getText();
                    scan = new Scanner(new File(filename));
                    read.setEnabled(true);
                    p = scan.next();

                } catch (FileNotFoundException ex) {
                    System.out.println("Invalid");
                }
            }
            if (e.getSource() == read){
                p = scan.next();
            }
            line.setText(p);
        }
    }
}
