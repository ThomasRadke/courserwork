import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class Dot {
	protected int radius;
	protected Color color;
	protected double x;
	protected double y;
	private int w;
	private int h;
	protected double ang;
	private ImageIcon icon;
	private Image img;

	public Dot(){
		this.x = 0;
		this.y=0;
		radius = 0;
		color = Color.BLACK;
		ang = 0;
	}

	public Dot(Point center) {
		super();
		this.x = center.x;
		this.y = center.y;
		radius = 50;
		color = Color.BLUE;
	}
	public Dot(Point center, int radius) {
		this(center);
		this.radius = radius;
	}

	public Point getCenter() {
		return new Point((int)x, (int)y);
	}

	public void setImg(String fname) {
		icon = new ImageIcon(fname);
		img = icon.getImage().getScaledInstance(radius,radius,Image.SCALE_DEFAULT);
	}

	public void setCenter(Point p){
		x = p.x;
		y = p.y;
	}

	public int getTop(){
		return (int) y -radius;
	}
	public int getBottom(){
		return (int) y + radius;
	}
	public int getLeft(){
		return (int) x - radius;
	}
	public int getRight(){
		return (int) x +radius;
	}

	public Rectangle getRegion(){
		return  new Rectangle(getTop(),getLeft(), 2*radius, 2 *radius);
	}

	void paint(Graphics g) {
		if (img == null) {
			Color old = g.getColor();
			g.setColor(color);
			g.fillOval(getLeft(), getTop(), radius * 2, radius * 2);
			g.setColor(old);
		}
		else {
			Graphics2D gr = (Graphics2D) g;
			int cx = img.getWidth(null) / 2;
			int cy = img.getHeight(null) / 2;
			AffineTransform oldAT = gr.getTransform();
			gr.translate(cx + (int) x, cy + (int) y);
			gr.rotate(ang);
			gr.translate(-cx, -cy);
			gr.drawImage(img, 0, 0, null);
			gr.setTransform(oldAT);
		}
	}

	public boolean isInside(Point p){
		Point center = new Point((int)x,(int)y);
		return p.distance(center)<radius;
	}

	public void setColor(Color c){
		this.color = c;
	}

	public double getAng() {
		return ang;
	}

	public void setAng(double ang) {
		this.ang = ang;
	}
}
