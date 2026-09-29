package com.uk.lld.designpatterns.observer;

public class ObserverPatternDemo {
    static void main(String[] args) {
        AppleStockTicker aapl = new AppleStockTicker();

        StockObserver traderPhone = new MobileAppAlerts("user_9921");
        StockObserver hedgeFundBot = new AlgorithmicTradingBot(180.00);

        aapl.registerObserver(traderPhone);
        aapl.registerObserver(hedgeFundBot);

        aapl.setPrice(185.50);

        aapl.setPrice(179.25);

        aapl.unregisterObserver(traderPhone);

        aapl.setPrice(178.00);
    }
}