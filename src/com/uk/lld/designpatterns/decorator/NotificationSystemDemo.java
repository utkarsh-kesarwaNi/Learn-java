package com.uk.lld.designpatterns.decorator;

public class NotificationSystemDemo {
    static void main(String[] args) {
        String alertMessage = "CRITICAL: Database connection lost!";

        /*
         * SCENARIO 1: Base behaviour only
         * We just want an email. No decorators needed.
         */
        Notifier simpleNotifier = new EmailNotifier("admin@company.com");
        simpleNotifier.send(alertMessage);

        /*
         * SCENARIO 2: Stacking Decorators
         * We are composing the object dynamically at runtime without creating a monolithic
         * `EmailAndSMSAndSlackNotifier` class.
         *
         * 1. Create the base component (EmailNotifier).
         * 2. Wrap it in an SMSDecorator.
         * 3. Wrap that result in a SlackDecorator.
         *
         * Object Graph: SlackDecorator -> SMSDecorator -> EmailNotifier
         */
        Notifier criticalNotifier = new SlackDecorator(
                new SMSDecorator(
                        new EmailNotifier("admin@company.com"),
                        "+1-555-0199"
                ),
                "#alerts-critical"
        );

        /*
         * THE CALL STACK FOR send():
         * 1. SlackDecorator.send() is called.
         *      -> It immediately calls super.send(), passing control to SMSDecorator.
         * 2. SMSDecorator.send() is called.
         *      -> It immediately calls super.send(), passing control to EmailNotifier.
         * 3. EmailNotifier.send() executes.
         *      -> [OUTPUT] "Sending Email..."
         *      -> Method finishes, returns control back to SMSDecorator.
         * 4. SMSDecorator resumes.
         *      -> Executes sendSMS().
         *      -> [OUTPUT] "Sending SMS..."
         *      -> Method finishes, returns control back to SlackDecorator.
         * 5. SlackDecorator resumes.
         *      -> Executes sendSlackMessage().
         *      -> [OUTPUT] "Sending Slack message..."
         */
        criticalNotifier.send(alertMessage);
    }
}