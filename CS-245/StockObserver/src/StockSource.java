public interface StockSource {
    public void addObserver(StockObserver o);
    public void removeObserver(StockObserver o);
    public void alert();
}
