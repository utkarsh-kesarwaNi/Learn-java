package com.uk.asynchronous;

public class ExecuteUsingRunnable {

    static void main() {
        Thread threadOne = getThread();
        threadOne.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("std output inside main method, execution done by Thread with name " + Thread.currentThread().getName());
        }

        /*
         * Both main thread and threadOne will run in parallel or not will depend on the number of cores within your CPU
         * If your CPU has only one core, operating system will switch context i.e.
         * for some time main thread run, then threadOne run, then again main thread runs and so on....
         *
         * In this way we can achieve asynchronous behaviour where more than one task is being performed at the same time.
         * We are not waiting for the main thread to complete its execution before threadOne can start its task.
         */

    }

    private static Thread getThread() {
        TaskOneUsingRunnable taskOne = new TaskOneUsingRunnable();

        /*
         * A Thread is the smallest unit of a process that can run independently within a program.
         * We can create Threads in 2 ways : Implementing the Runnable interface and Extending the Thread class
         *
         * Lifecycle states of a Thread :
         * NEW : Thread instance has been constructed but start() has not yet been executed
         * RUNNABLE : The thread is actively running or ready for resource allocation by the operating system scheduler
         * BLOCKED : The thread is waiting to acquire a monitor lock to enter a synchronized block or method
         * WAITING : The thread is suspended indefinitely until another thread signals a notification via notify() or notifyAll()
         * TIMED_WAITING : The thread is suspended for a specific period (e.g., via Thread.sleep(milliseconds))
         * TERMINATED : The execution flow within the run() block has completed or aborted via an exception
         */

        return new Thread(taskOne);
    }
}
