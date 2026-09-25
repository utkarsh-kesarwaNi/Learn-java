package com.uk.lld.designpatterns;

public interface PaymentStrategy {
    void pay(int amount);
}
/*
* Strategy Design Pattern is a behavioural design pattern that allows you to define a family of algorithms/functionality/capability,
* encapsulate each one as an object, and make them interchangeable at runtime.
* It lets the algorithm vary independently of the clients that use it.
*
* This pattern relies on three key components:
* 1. Strategy (Interface): Defines the common operations that all supported algorithms must implement.
*                          The context uses this interface to call the algorithm defined by a Concrete Strategy.
* 2. Concrete Strategy (Classes): Implements the algorithm defined by the Strategy interface.
* 3. Context (Class): Maintains a reference to a Strategy object. It may define an interface that lets Strategy access its data.
*
*
* Now one such behaviour is payment, i.e, you simply pass the amount.
* It can be done via Credit card or PayPal or UPI etc. Each one of these exhibit payment behaviour but internally work in different manner.
*
* public class CreditCardStrategy implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public CreditCardStrategy(String name, String ccNum, String cvv, String expiryDate) {
        this.name = name;
        this.cardNumber = ccNum;
        this.cvv = cvv;
        this.dateOfExpiry = expiryDate;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid with credit/debit card.");
        // Complex card processing logic here...
    }
}
*
* public class PaypalStrategy implements PaymentStrategy {
    private String emailId;
    private String password;

    public PaypalStrategy(String email, String pwd) {
        this.emailId = email;
        this.password = pwd;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using PayPal.");
        // Complex PayPal routing logic here...
    }
}
*
* So here PayPalStrategy and CreditCardStrategy are concrete classes(strategies) having their own implementation of pay() method.
*
* Using Runtime polymorphism, we will invoke the required pay() method based on whatever strategy is called.
*
* public class ShoppingCart {
    // Context maintains a reference to the strategy interface
    private PaymentStrategy paymentMethod;

    // Strategy can be injected via constructor or setter
    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentMethod = strategy;
    }

    public void checkout(int amount) {
        if (paymentMethod == null) {
            throw new IllegalStateException("Payment strategy not set");
        }
        paymentMethod.pay(amount);
    }
}
*
* public class ShoppingCartTest {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Pay by credit card
        cart.setPaymentStrategy(new CreditCardStrategy("Utkarsh", "1234567890123456", "786", "12/26"));
        cart.checkout(100);

        // Change strategy at runtime to PayPal
        cart.setPaymentStrategy(new PaypalStrategy("utkarsh@example.com", "mypwd"));
        cart.checkout(50);
    }
* */