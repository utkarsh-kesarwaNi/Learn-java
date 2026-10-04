package com.uk.lld.designpatterns.decorator;

public class SlackDecorator extends NotifierDecorator {
    private final String slackChannel;

    public SlackDecorator(Notifier wrappee, String slackChannel) {
        super(wrappee);
        this.slackChannel = slackChannel;
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSlackMessage(message);
    }

    private void sendSlackMessage(String message) {
        System.out.println("Sending slack message to channel [" + slackChannel + "]: " + message);
    }
}