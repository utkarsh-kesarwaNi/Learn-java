package com.uk.lld.designpatterns.observer;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * CONCRETE SUBJECT: Apple Stock Ticker
 * Tracks price changes and notifies all registered downstream systems.
 */
public class AppleStockTicker implements StockSubject {
    private final String symbol = "AAPL";
    private final List<WeakReference<StockObserver>> observers = new ArrayList<>();
    private double currentPrice;

    @Override
    public void registerObserver(StockObserver observer) {
        observers.add(new WeakReference<>(observer));
    }

    @Override
    public void unregisterObserver(StockObserver observer) {
        observers.removeIf(ref -> {
            StockObserver current = ref.get();
            return current == null || current == observer;
        });
    }

    @Override
    public void notifyObservers() {
        Iterator<WeakReference<StockObserver>> iterator = observers.iterator();
        while (iterator.hasNext()) {
            StockObserver observer = iterator.next().get();
            if (observer == null) {
                iterator.remove();
            } else {
                observer.onPriceUpdate(this.symbol, this.currentPrice);
            }
        }
    }

    public void setPrice(double newPrice) {
        if (Double.compare(this.currentPrice, newPrice) != 0) {
            this.currentPrice = newPrice;
            notifyObservers();
        }
    }
}