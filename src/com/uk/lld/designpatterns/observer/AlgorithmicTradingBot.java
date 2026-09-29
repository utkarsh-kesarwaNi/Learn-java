package com.uk.lld.designpatterns.observer;

public class AlgorithmicTradingBot implements StockObserver {
    private final double buyThreshold;

    public AlgorithmicTradingBot(double buyThreshold) {
        this.buyThreshold = buyThreshold;
    }

    @Override
    public void onPriceUpdate(String symbol, double price) {
        if (price <= buyThreshold) {
            System.out.println("[Auto-Trader] Triggering BUY order for " + symbol + " at $" + price);
        }
    }
}