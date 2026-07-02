package com.uk.asynchronous;

public class TaskOneUsingRunnable implements Runnable {
    /*
     * Runnable is a functional interface with one abstract method void run()
     */

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("std output inside Task One run method, execution done by Thread with name " + Thread.currentThread().getName());
        }
    }

    /*
    * One disadvantage is a Runnable, however, does not return a result and cannot throw a checked exception.
    * To overcome this we have Callable interface.
    * */
}
