import javax.swing.*;

public class MessagePanel extends CoePanel{

    JLabel label;

    public MessagePanel() {
        super();
        label = new JLabel("Hello World");

        add(label);
    }
}
