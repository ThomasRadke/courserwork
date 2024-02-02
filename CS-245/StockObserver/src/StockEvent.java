public class StockEvent {
    private double price;
    private String advice;
    public static String BUY = "BUY!";
    public static String SELL = "SELL!";
    public static String Hold = "Hold!";
    public StockEvent(double p){
        this.price = p;
        this.advice = "";
    }
    public StockEvent(double p,String Advice){
        this.price = p;
        this.advice = Advice;
    }

    public double getPrice() {
        return price;
    }

    public String getAdvice() {
        return advice;
    }
}
