public class BrokerStrategy implements InvestmentStrategy{

    @Override
    public int buyOrSell(StockEvent e) {
        int numberofShares = 0;
        String advice = e.getAdvice();
        if(advice.equals(e.BUY)){
            numberofShares = 20;
        }
        if(advice.equals(e.SELL))
            numberofShares = -20;
        if(advice.equals(e.Hold))
            numberofShares = 0;
        return numberofShares;
    }
}
