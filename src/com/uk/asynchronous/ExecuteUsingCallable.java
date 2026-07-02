package com.uk.asynchronous;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecuteUsingCallable {

    static void main() throws ExecutionException, InterruptedException {

        /*
         * Executors.newFixedThreadPool(1) will be creating Threads behind the scene
         *
         */

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> returnValueFromTaskOneUsingCallable = executorService.submit(new TaskOneUsingCallable());

        /*
         * If TaskOneUsingCallable class is having a long-running task, execution will not be blocked and
         * main thread will continue with its execution
         *
         *
         * A Future represents the result of an asynchronous computation.
         *
         */

        /*
         * System.out.println(returnValueFromTaskOneUsingCallable.get());  Blocking in this case here
         *
         * To overcome this we now have CompletableFuture
         */

        for (int i = 0; i < 10; i++) {
            System.out.println("std output inside main method, execution done by Thread with name " + Thread.currentThread().getName());
        }

        /*
         * get() retrieves the result when the task is completed. Hence, this is a blocking call as we are waiting for
         * this task to complete first and return the result
         *
         */
        System.out.println(returnValueFromTaskOneUsingCallable.get());  // non-blocking in this case here
    }
}
