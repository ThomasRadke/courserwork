public class zenMoMethod implements PaymentMethod{

    private String acct;

    public zenMoMethod() {
        this.acct = "555874";
    }

    public boolean pay(double amt) {
        System.out.println("Confirming with ZenMo Server");
        System.out.println("Paid "+ amt);
        System.out.println("Using Zenmo account# "+ acct);
        return true;
    }
}
