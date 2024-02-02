import java.awt.*;

public abstract class  MovingDecorator extends MovingDot{
    private MovingDot md;

    public MovingDecorator(MovingDot m) {
        super();
        this.md = m;
    }

    @Override
    public double getDx() {
        return md.getDx();
    }

    @Override
    public double getDy() {
        return md.getDy();
    }

    @Override
    public void setDx(double dx) {
        md.setDx(dx);
    }

    @Override
    public void setDy(double dy) {
        md.setDy(dy);
    }

    @Override
    public void setSpeed(double speed) {
        md.setSpeed(speed);
    }

    @Override
    public void setDirection(Point direction) {
        md.setDirection(direction);
    }

    @Override
    public double getSpeed() {
        return md.getSpeed();
    }

    @Override
    public Point getDirection() {
        return md.getDirection();
    }

    @Override
    public void setMotion(double x, double y) {
        md.setMotion(x, y);
    }

    @Override
    public void move() {
        md.move();
    }

    @Override
    void paint(Graphics g) {
        md.paint(g);
    }

    @Override
    public double getAng() {
        return md.getAng();
    }

    @Override
    public void setAng(double ang) {
        md.setAng(ang);
    }

    @Override
    public void setImg(String fname) {
        md.setImg(fname);
    }

    @Override
    public int getTop() {
        return md.getTop();
    }

    @Override
    public int getBottom() {
        return md.getBottom();
    }

    @Override
    public int getLeft() {
        return md.getLeft();
    }

    @Override
    public int getRight() {
        return md.getRight();
    }

    @Override
    public Point getCenter() {
        return md.getCenter();
    }

    @Override
    public boolean isInside(Point p) {
        return md.isInside(p);
    }
}
