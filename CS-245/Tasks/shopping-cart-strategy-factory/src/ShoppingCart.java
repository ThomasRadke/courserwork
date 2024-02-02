
public class ShoppingCart {
    String items;
    private double total;

    private String zipcode;
    private PaymentMethod pm;
    private pmFactory factory;

    public ShoppingCart(String items, double amt) {
        this.items = items;
        this.total= amt;

        factory = new pmFactory();

        zipcode = "21015";
    }

    public void process(String pmCode){
        pm = factory.createPM(pmCode);
        pm.pay(total);
        ship(items);
    }



    private void ship(String items){
        System.out.println("Shipping: "+ items + " to " + zipcode);
    }

    public static void main(String[] args) {
        ShoppingCart c = new ShoppingCart("books", 50);
        c.process("z");
        ShoppingCart c2 = new ShoppingCart("posters", 150 );
        c2.process("c");
        ShoppingCart c3 = new ShoppingCart("Onions", 30000);
        c3.process("p");

    }
}
