public class PayBuddy implements PaymentMethod{

    private String acct;

    public PayBuddy() {
        this.acct = "123456789";
    }

    public boolean pay(double amt) {
        System.out.println("Confirming with PayBuddy Server");
        System.out.println("Paid "+ amt);
        System.out.println("Using PayBuddy account# "+ acct);
        return true;
    } //changes
}
