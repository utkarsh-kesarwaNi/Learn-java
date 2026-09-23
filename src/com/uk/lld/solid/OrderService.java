package com.uk.lld.solid;

public class OrderService {
    private final AwsEmailClient emailClient = new AwsEmailClient();

    public void checkout(String orderId) {
        emailClient.send(orderId);
    }
}

class AwsEmailClient {
    void send(String orderId) { }
}

/*
* Dependency Inversion Principle (DIP) states two critical rules:
* 1. High-level modules (business rules) should not depend on low-level modules (I/O, database, UI).
     Both should depend on abstractions (interfaces).
* 2. Abstractions should not depend on details. Details (concrete implementations) should depend on abstractions.
*
* SOLUTION
* public record Order(String id, double amount) {}

public interface NotificationSender {
    void sendNotification(Order order, String message);
}

public class AwsEmailSender implements NotificationSender {
    @Override
    public void sendNotification(Order order, String message) {
        System.out.println("Emailing receipt for order: " + order.id());
    }
}

public class TwilioSmsSender implements NotificationSender {
    @Override
    public void sendNotification(Order order, String message) {
        System.out.println("Texting receipt for order: " + order.id());
    }
}

public class OrderService {
    private final NotificationSender notificationSender;

    public OrderService(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }

    public void processOrder(Order order) {
        System.out.println("Order processed successfully.");
        notificationSender.sendNotification(order, "Order Confirmed!");
    }
}
* */