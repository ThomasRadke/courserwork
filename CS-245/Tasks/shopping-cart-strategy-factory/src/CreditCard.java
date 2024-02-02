public class CreditCard {
    private String name;
    private String cardnum;
    private String expDate;
    private String cvv;

    public CreditCard(String name, String cardnum, String expDate, String cvv) {
        this.name = name;
        this.cardnum = cardnum;
        this.expDate = expDate;
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "name='" + name + '\'' +
                ", cardnum='" + cardnum + '\'' +
                ", expDate='" + expDate + '\'' +
                ", cvv='" + cvv + '\'' +
                '}';
    }
}
