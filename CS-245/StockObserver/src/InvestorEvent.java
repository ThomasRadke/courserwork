import java.util.ArrayList;

public class InvestorEvent implements InvestorSource{
    private int sharesOwned;
    private double investedAmt;
    private double stockPrice;

    public double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
    }

    private ArrayList<InvestorPanel> observers = new ArrayList<InvestorPanel>();;
    public InvestorEvent(int shrow, double invtam){
        this.investedAmt = invtam;
        this.sharesOwned = shrow;
    }

//    public void setSharesOwned(int sharesOwned) {
//        this.sharesOwned = sharesOwned;
//    }
//
//    public void setInvestedAmt(double investedAmt) {
//        this.investedAmt = investedAmt;
//    }

    public void Event(int shrom, double invtam){
        this.investedAmt = invtam;
        this.sharesOwned = shrom;
    }

    public int getSharesOwned() {
        return sharesOwned;
    }

    public double getInvestedAmt() {
        return investedAmt;
    }

    @Override
    public void AddStockSource(InvestorPanel i) {
        observers.add(i);
    }

    @Override
    public void RemoveStockSource(InvestorPanel i) {
        observers.remove(i);
    }

    @Override
    public void alert() {
        for(InvestorPanel i:observers)
            i.update(this);
    }
}
