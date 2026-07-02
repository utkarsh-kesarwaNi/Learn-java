package com.uk.asynchronous;

import java.util.concurrent.Callable;

public class TaskOneUsingCallable implements Callable<String> {

    /*
    * The Callable interface is similar to Runnable, in that both are designed for classes whose instances are potentially
    * executed by another thread.
    * A Runnable, however, does not return a result and cannot throw a checked exception.
    *
    * Callable<V> is also a Functional interface with one abstract method V call() with return type V
    * */

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println("std output inside Task One call method, execution done by Thread with name " + Thread.currentThread().getName());
        }
        return "Task completed by call method";
    }
}
