import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StrategyPanel extends JPanel{
    private Investor investor;
    private JRadioButton growthRB;
    private JRadioButton traderRB;
    private JRadioButton brokerRB;
    private ButtonGroup bg;
    private JPanel buttonPanel;
    private JButton strategyBtn;

    public StrategyPanel(Investor investor) {

        this.investor = investor;
        setPreferredSize(new Dimension(400,150));
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setAlignmentX(LEFT_ALIGNMENT);
        growthRB = new JRadioButton("Growth");
        traderRB = new JRadioButton("Trader");
        brokerRB = new JRadioButton("Broker");
        bg = new ButtonGroup();
        bg.add(growthRB);
        bg.add(traderRB);
        bg.add(brokerRB);
        growthRB.setSelected(true);

        strategyBtn = new JButton("Set Strategy");
        StrategyPanel.ButtonListener bl = new StrategyPanel.ButtonListener();
        strategyBtn.addActionListener(bl);
        strategyBtn.setAlignmentX(LEFT_ALIGNMENT);

        buttonPanel.add(growthRB);
        buttonPanel.add(traderRB);
        buttonPanel.add(brokerRB);
        add(buttonPanel);
        add(strategyBtn);
    }

    private class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            GrowthStrategy growth = new GrowthStrategy();
            TraderStrategy trader = new TraderStrategy();
            BrokerStrategy broker = new BrokerStrategy();
            if (growthRB.isSelected()) {
                investor.setStrategy(growth);
            }
            if (traderRB.isSelected())
                investor.setStrategy(trader);
            if(brokerRB.isSelected())
                investor.setStrategy(broker);

        }
    }
}
