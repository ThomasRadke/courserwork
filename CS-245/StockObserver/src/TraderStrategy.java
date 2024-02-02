public class TraderStrategy implements InvestmentStrategy{
    private int numberofStonks = 0;
    private double avg = 0;
    @Override
    public int buyOrSell(StockEvent e) {
        int numberOfShares = 0;
        double i = e.getPrice();
        double start = 100;
        if(numberofStonks == 0) {
            while (start >= i) {
                numberOfShares++;
                start -= i;
            }
            avg = i;
        }
        else {
            if(e.getPrice() >= 1.1 * avg){
                numberOfShares = (int) ((int) numberofStonks - 1.1 * numberofStonks);
                avg = (avg + e.getPrice())/2;
            }
            else {
                double add = 500;
                while (add >= e.getPrice()){
                    numberOfShares++;
                    add -= e.getPrice();
                }
                avg = (avg + e.getPrice())/2;
            }
        }
        numberofStonks = numberOfShares;

        return numberOfShares;
    }
}
