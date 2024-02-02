import javax.swing.*;
import java.awt.*;

public class BrokerPanel extends JPanel implements StockObserver{
    private Broker b;
    private JLabel advice;

    public BrokerPanel(Broker b) {
        setPreferredSize(new Dimension(400, 40));
        this.b = b;
        advice = new JLabel("");
        add(advice);
    }
    public Broker getBroker() {
        return b;
    }

    @Override
    public void Update(double price) {

    }

    @Override
    public void Stockevent(StockEvent stonk) {
        String decision = stonk.getAdvice();
        advice.setText(decision);
    }
}
