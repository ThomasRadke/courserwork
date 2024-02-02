import java.util.ArrayList;

public class Broker  implements StockObserver,StockSource{
    private ArrayList<StockObserver> observers = new ArrayList<StockObserver>();
    public int IncStreak = 0;
    public int DecStreak = 0;
    public double TempPrice = 0;
    public int buy = 0;
    public String advices = StockEvent.Hold;
    public void Decision(int decision){
        if(decision == 1){
            advices = StockEvent.BUY;
        }
        if(decision == 0){
            advices = StockEvent.SELL;
        }
        if(decision == 2){
            advices = StockEvent.Hold;
        }
    }

    @Override
    public void Update(double price) {
//        System.out.println("Broker");
//        System.out.println(price);
        if(price >= TempPrice && DecStreak >=5){
            DecStreak = 0;
            buy = 1;
            Decision(buy);
        }
        else if(price <= TempPrice && IncStreak >= 5){
            IncStreak = 0;
            buy = 0;
            Decision(buy);
        }
        else if(price >= TempPrice){
            IncStreak += 1;
            buy = 2;
            Decision(buy);
        }
        else if(price <= TempPrice){
            buy = 2;
            DecStreak += 1;
            Decision(buy);
        }
        else
            advices = StockEvent.Hold;
        TempPrice = price;
    }

    @Override
    public void Stockevent(StockEvent stonk) {

    }

    @Override
    public void addObserver(StockObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(StockObserver o) {
        observers.remove(o);

    }

    @Override
    public void alert() {
        StockEvent event = new StockEvent(TempPrice, advices);
        for(StockObserver observer: observers)
            observer.Stockevent(event);
    }
}