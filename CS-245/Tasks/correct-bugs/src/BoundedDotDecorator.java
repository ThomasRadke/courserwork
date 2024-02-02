import java.awt.*;

public class BoundedDotDecorator extends MovingDecorator{
    private Point topLeft;
    private Point bottomRight;
    private MovingDot md;

    public BoundedDotDecorator(MovingDot md, Point bottomRight)
    {
        this(md, new Point(0,0), bottomRight);
    }

    public BoundedDotDecorator(MovingDot md, Point topLeft, Point bottomRight) {
        super (md);
        this.bottomRight = bottomRight;
        this.topLeft = topLeft;
        this.md = md;
    }

    @Override
    public void move() {
        if (md.getLeft() < topLeft.x || md.getRight()>bottomRight.x){
            md.setMotion(-md.getDx(),md.getDy());
        }
        if (md.getTop() < topLeft.y || md.getBottom() > bottomRight.y ){
            md.setMotion(md.getDx(),-md.getDy());
        }
        md.move();
    }
}
