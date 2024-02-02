public class GrowthStrategy implements InvestmentStrategy{
    @Override
    public int buyOrSell(StockEvent e) {
        double price = e.getPrice();
        int numberofStocks = 0;
        double start = 100;
        while (start >= price) {
            numberofStocks++;
            start -= price;
        }
        return numberofStocks;
    }
}
