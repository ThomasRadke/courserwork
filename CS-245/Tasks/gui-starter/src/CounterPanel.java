import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterPanel extends CoePanel{
    private JLabel cnt;
    private JButton upButton;
    private JButton downButton;
    private int num;


    public CounterPanel() {
        super();
        num = 0;
        cnt = new JLabel(Integer.toString(num));
        upButton = new JButton("Up");
        downButton = new JButton("Down");

        ButtonListener bl = new ButtonListener();
        upButton.addActionListener(bl);
        downButton.addActionListener(bl);

        add(cnt);
        add(upButton);
        add(downButton);

    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == upButton) {
                num += 1;
            }
            if (e.getSource() == downButton){
                num -= 1;
            }
            cnt.setText(Integer.toString(num));
        }
    }
}
