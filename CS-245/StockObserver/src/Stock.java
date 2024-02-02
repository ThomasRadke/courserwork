import java.util.ArrayList;

public class Stock implements StockSource{
    private double price;
    private ArrayList<StockObserver> observers = new ArrayList<StockObserver>();

    public Stock() {
        price = 0;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void addObserver(StockObserver o) {
        observers.add(o);

    }

    @Override
    public void removeObserver(StockObserver o) {
        observers.add(o);

    }

    @Override
    public void alert() {
        StockEvent stonk = new StockEvent(price);
        for (StockObserver o: observers){
            o.Update(price);
            o.Stockevent(stonk);
        }

    }
}