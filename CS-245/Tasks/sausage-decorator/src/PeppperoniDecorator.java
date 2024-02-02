public class PeppperoniDecorator extends PizzaDecorator{

    public PeppperoniDecorator(Pizza p) {
        super(p);
    }

    @Override
    public double getPrice() {
        return p.getPrice() + 1.5;
    }

    @Override
    public String toString() {
        return p.toString() +"\n\t Pepperoni";
    }
}
