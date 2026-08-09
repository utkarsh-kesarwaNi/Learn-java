package com.uk.oop;

import java.math.BigDecimal;

/*
 * Object-Oriented Programming (OOP) ?
 * Object-Oriented Programming is a programming paradigm that organizes software design around objects rather than functions and logic.
 * It bundles state (attributes) and behaviour (methods) into cohesive units called objects.
 */
public class Payment {
//    Attributes are strictly encapsulated and immutable where possible
//    By making fields private and exposing strictly controlled methods, you guarantee the object is never in an invalid state.
    private final BankAccount fromAccount;
    private final BankAccount toAccount;
    private final BigDecimal amount;
    private boolean isPaymentSuccessful;

    public Payment(BankAccount fromAccount, BankAccount toAccount, BigDecimal amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    public void transferAmount() {
//        Logic to transfer amount
        if (this.fromAccount.getBalance().compareTo(this.amount) < 0) {
            System.out.println("Available funds: " + this.fromAccount.getBalance() + " is less than amount to be transferred: " + this.amount);
            return;
        }
        fromAccount.withdrawAmount(amount);
        toAccount.depositAmount(amount);
        this.isPaymentSuccessful=true;
        System.out.println("Executing transfer amount logic");
    }

    public boolean isPaymentSuccessful() {
        return isPaymentSuccessful;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BankAccount getToAccount() {
        return toAccount;
    }

    public BankAccount getFromAccount() {
        return fromAccount;
    }
}

/*
 * The 4 pillars
 *
 * 1. Encapsulation (Information Hiding & Invariants): Bundling data(attributes/fields) and methods(behaviour) into one single unit and restricting direct access to the data.
 *    class Payment with its private attributes
 *
 * 2. Abstraction (Minimizing Cognitive Load): Hiding complex implementation details and showing only the essential features. It defines a CONTRACT.
 *    In Payment class, nobody cares how the transferAmount(....) function is implemented or what it uses or anything.
 *
 * 3. Inheritance: A mechanism where one class acquires the properties and behaviours of a parent class (an "IS-A" relationship).
 *
 * NOTE : Favour Composition over Inheritance (HAS-A over IS-A).
 *        Reuse code by giving objects references to other objects, rather than inheriting from them.
 *
 * 4. Polymorphism (Dynamic Dispatch): The ability of different objects to respond to the same method call in their own specific way.
 * */
