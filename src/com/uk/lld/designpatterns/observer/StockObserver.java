package com.uk.lld.designpatterns.observer;

public interface StockObserver {
    void onPriceUpdate(String symbol, double price);
}