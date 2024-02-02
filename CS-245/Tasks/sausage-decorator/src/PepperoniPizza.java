public class PepperoniPizza extends Pizza{
    @Override
    double getPrice() {
        return super.getPrice() + 1.5;
    }

    @Override
    public String toString() {
        return super.toString()+ "\n \tPepperoni";
    }
}
