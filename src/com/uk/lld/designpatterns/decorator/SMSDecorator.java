package com.uk.lld.designpatterns.decorator;

public class SMSDecorator extends NotifierDecorator {
    private final String phoneNumber;

    public SMSDecorator(Notifier wrappee, String phoneNumber) {
        super(wrappee);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS to " + phoneNumber + ": " + message);
    }
}