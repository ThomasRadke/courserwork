import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StockPanel extends JPanel {

	private Stock s;
	private Investor i1;
	private Investor i2;
	private Investor i3;
	private JTextField fname;
	private JButton openButton;
	private JTextField line;
	private JButton readButton;
	private Scanner scan;
	private Broker b = new Broker();

	public void setB(Broker b) {
		this.b = b;
	}

	public void setI1(Investor i1) {
		this.i1 = i1;
	}

	public void setI2(Investor i2) {
		this.i2 = i2;
	}

	public void setI3(Investor i3) {
		this.i3 = i3;
	}

	public StockPanel() {
		super();
		setPreferredSize(new Dimension(450,80));
		setBackground(new Color(255, 138, 19));
		fname = new JTextField();
		fname.setColumns(25);
		fname.setText("StockPrices.txt");
		openButton = new JButton("Open");
		line = new JTextField();
		line.setColumns(25);
		readButton = new JButton("Read");
		readButton.setEnabled(false);
		ButtonListener bl = new ButtonListener();
		openButton.addActionListener(bl);
		readButton.addActionListener(bl);
		s = new Stock();

		add(fname);
		add(openButton);
		add(line);
		add(readButton);
	}
	public void addInvestors(){
		s.addObserver(i1);
		s.addObserver(i2);
		s.addObserver(i3);
	}


	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String p = "";
			if (e.getSource() == openButton) {
				try {
					String filename = fname.getText();
					scan = new Scanner(new File(filename));
					readButton.setEnabled(true);
					p = scan.next();
					s.setPrice(Double.valueOf(p));
					s.addObserver(b);

				} catch (FileNotFoundException ex) {
					System.out.println("Oops");
				}
			}
			if (e.getSource() == readButton){
				p = scan.next();

				if (scan.hasNext()){
					StockEvent event = new StockEvent(Double.valueOf(p));
					double price = event.getPrice();
					s.setPrice(Double.valueOf(p));
					s.alert();
					b.alert();
				}
				else{
					readButton.setEnabled(false);
				}
			}
			line.setText(p);
		}
	}
}
