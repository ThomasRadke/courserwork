import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class BugPanel extends JPanel {

	private Point location;
	private ArrayList<MovingDot> dotList;

	public BugPanel() {
		setPreferredSize(new Dimension(800,600));
		dotList = new ArrayList<MovingDot>();
		MousePlay mp = new MousePlay();
		addMouseListener(mp);
		addMouseMotionListener(mp);
	}

	private void addBug(Point p) {
		Point origin = new Point(getWidth() / 2, getHeight() / 2);
		MovingDot d = new MovingDot(p,origin, 2);
		d.setImg("BugImg/redbug64.png");
		d = new BoundedDotDecorator(d, new Point(getWidth(), getHeight()));
		d = new GravityDotDecorator(d);
		dotList.add(d);
	}

	@Override
	protected synchronized void paintComponent(Graphics g) {
		super.paintComponent(g);
		/*if (location != null) {
			Dot d = new Dot(location);
			d.setColor(Color.RED);
			d.paint(g);
 		}*/
		for (MovingDot d:dotList){
			d.move();
			d.paint(g);
		}
		try {
			//Go to sleep for a bit to delay updates from happening too fast.
			Thread.sleep(5);
		}
		catch (InterruptedException e){
		}
		repaint();
	}



	private class MousePlay implements MouseListener, MouseMotionListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.isMetaDown()){
				System.out.println("MEta");
				Dot removeD = null;
				for (Dot d : dotList){
					System.out.println(d.radius);
					if (d.isInside(e.getPoint())){
						removeD = d;
					}
				}
				if (removeD != null){
					dotList.remove(removeD);
					System.out.println("Squish!");
				}
			}
			else{
				System.out.println("MouseClicked");
				addBug(e.getPoint());
			}
		repaint();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			System.out.println("MousePressed");
			location=e.getPoint();
			repaint();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			//Dot d = new Dot(e.getPoint());
			//dotList.add(d);
			//repaint();
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			//System.out.println("MouseEntered");
		}

		@Override
		public void mouseExited(MouseEvent e) {
			//System.out.println("MouseExited");
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			//location  =e.getPoint();
			//repaint();
		}

		@Override
		public void mouseMoved(MouseEvent e) {

		}
	}
}
