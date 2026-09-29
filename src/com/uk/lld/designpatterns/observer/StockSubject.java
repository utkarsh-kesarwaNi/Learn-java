package com.uk.lld.designpatterns.observer;

public interface StockSubject {
    void registerObserver(StockObserver observer);

    void unregisterObserver(StockObserver observer);

    void notifyObservers();
}