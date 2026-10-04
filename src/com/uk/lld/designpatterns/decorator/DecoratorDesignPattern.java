package com.uk.lld.designpatterns.decorator;

public class DecoratorDesignPattern { }

/*
* Decorator Design Pattern is a structural behavioural pattern that allows you to dynamically attach new behaviours
* to objects by placing them inside special wrapper objects (decorators).
* It provides a flexible alternative to subclassing for extending functionality, strictly adhering to the Open-Closed Principle (classes should be open for extension but closed for modification).
*
*
* CASE
* For a notification system, initially you just have an EmailNotifier and later product requires SMS notification, then slack and then Teams.
* If we use inheritance, we will suffer Class explosion with too many classes to maintain like EmailNotifier, EmailAndSMSNotifier, EmailAndSlackNotifier, EmailSMSAndSlackNotifier etc.
*
* SOLUTION
* Instead of inheriting, you wrap.
* You create a base EmailNotifier, and then pass it into an SMSDecorator, which can then be passed into a SlackDecorator.
* The decorators have the exact same interface as the base object, meaning the client code doesn't even know it's interacting with a wrapped object.
* */