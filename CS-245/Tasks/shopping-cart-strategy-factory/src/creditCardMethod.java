public class creditCardMethod implements PaymentMethod {

    private CreditCard c;

    public creditCardMethod() {
        c = new CreditCard("Steve", "4883739939332832", "3-24:", "555");
    }

    @Override
    public boolean pay(double amt) {
        System.out.println("Validating Credit Card");
        System.out.println("Total: "+ amt);
        System.out.println("Paid with: "+ c);
        return true;
    }
}
