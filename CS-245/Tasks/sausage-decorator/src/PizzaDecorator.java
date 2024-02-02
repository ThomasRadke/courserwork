public abstract class PizzaDecorator extends Pizza{
    Pizza p;

    public PizzaDecorator(Pizza p) {
        this.p = p;
    }

    public abstract double getPrice();

    @Override
    public String toString() {
        return p.toString();
    }

}
