import java.util.ArrayList;

public class Investor implements StockObserver{
    private InvestmentStrategy strategy;
    private String name;

    private int sharesOwned = 0;
    private double investedAmt = 0;
    private Broker broker;

    public void setStrategy(InvestmentStrategy strategy) {
        this.strategy = strategy;
    }

    private InvestorEvent event = new InvestorEvent(0,0);

    public InvestorEvent getEvent() {
        return event;
    }

    public Investor(String name) {
        this.name = name;
        this.strategy = new GrowthStrategy();
        sharesOwned = 0;
        investedAmt = 0;
    }

    public void buyShares(int numShares, double price){
    }

    public String getName() {
        return name;
    }


    public void setBroker(Broker b){
        this.broker = b;
    }

    public Broker getBroker() {
        return broker;
    }
    public void makeTransaction(int numShares, double price){
        sharesOwned += numShares;
        investedAmt += price * numShares;
        event.setStockPrice(price);
//        event.setSharesOwned(sharesOwned);
//        event.setInvestedAmt(investedAmt);
        event.Event(sharesOwned,investedAmt);
        event.alert();

    }

    public int getSharesOwned() {
        return sharesOwned;
    }

    public double getInvestedAmt() {
        return investedAmt;
    }

    @Override
    public void Update(double price) {
//        System.out.println("Investor");
//        System.out.println(price);
        //makeTransaction(10,price);
    }

    @Override
    public void Stockevent(StockEvent stonk) {
        int numshares = strategy.buyOrSell(stonk);
        makeTransaction(numshares,stonk.getPrice());
    }
}