package com.uk.lld.designpatterns.observer;

public class MobileAppAlerts implements StockObserver {
    private final String userId;

    public MobileAppAlerts(String userId) {
        this.userId = userId;
    }

    @Override
    public void onPriceUpdate(String symbol, double price) {
        System.out.println("[Push Notification to " + userId + "] " + symbol + " traded at $" + price);
    }
}