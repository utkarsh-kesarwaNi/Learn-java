package com.uk.lld.designpatterns.observer;

public class ObserverDesignPattern { }
/*
* Observer Pattern defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
*
* CORE ACTORS:
* 1. Subject (Observable): The source of truth. Keeps track of observers and provides interfaces to attach or detach them dynamically at runtime.
* 2. Observer: The subscriber interface with an update() callback method.
* 3. ConcreteSubject: Maintains the state and the list of Observers, triggers notification on state change.
* 4. ConcreteObserver: Implements the update contract to synchronize internal state.
*
*
* USE case examples include
*   Stock exchange ticker: Thousands of traders, bots or apps are tracking live price updates of a particular stock.
*   Newsletter or YouTube subscription: Whenever a new video drops, all subscribers are notified.
* */