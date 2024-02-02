public class SausageDecorator extends PizzaDecorator{
    public SausageDecorator(Pizza p) {
        super(p);
    }

    @Override
    public double getPrice() {
        return p.getPrice() + 1;
    }

    public String toString(){
        return p.toString() + "\n\t Sausage";
    }
}
