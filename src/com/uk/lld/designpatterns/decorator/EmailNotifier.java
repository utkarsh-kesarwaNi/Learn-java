package com.uk.lld.designpatterns.decorator;

public class EmailNotifier implements Notifier {
    private final String adminEmail;

    public EmailNotifier(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    @Override
    public void send(String message) {
        System.out.println("Sending email to " + adminEmail + ": " + message);
    }
}