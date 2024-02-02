import java.awt.*;

public class MovingDot extends Dot {

    private double dx;
    private double dy;
    private double speed;
    private Point direction;
    //private double ang;
    private boolean running;

    public MovingDot() {
        super(new Point(0,0));
    }

    public MovingDot(Point center, Point direction, double speed) {
        super(center);
        //this.direction = direction;
        this.speed = speed;
        setDirection(direction);
        running = true;
        setMotion(dx, dy);
    }



    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setDirection(Point direction) {
        this.direction = direction;
 //       System.out.println("Moving toward: "+direction);
        double nextX = direction.getX() - this.getCenter().x;
        double nextY = direction.getY() - this.getCenter().y;
        setAng(Math.atan2(nextY, nextX));
        setDx(speed*Math.cos(getAng()));
        setDy(speed*Math.sin(getAng()));
    }



    public double getSpeed() {
        return speed;
    }

    public Point getDirection() {
        return direction;
    }

    public void setMotion(double x, double y){
        dx = x;
        dy = y;
        setAng(Math.atan2(dy,dx));
    }
    public void move(){
        x += dx;
        y += dy;
    }

}
