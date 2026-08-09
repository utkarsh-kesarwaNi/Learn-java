package com.uk.oop;

import java.math.BigDecimal;

public class Application {
    static void main(String[] args) {

//      Object: Creating a concrete instance at runtime

//        aliceAccount is REFERENCE pointing to a BankAccount object in memory
        BankAccount aliceAccount = new BankAccount("019114ae-1080-711a-bc88-92716fed0123", BigDecimal.valueOf(5000.450));

//        "bobAccount" points to a completely different memory location
        BankAccount bobAccount = new BankAccount("019114ad-8800-7fa3-b124-7389ab4123cd", BigDecimal.valueOf(5000.450));

        System.out.println("Accounts before executing payment\n" + aliceAccount + "\n" + bobAccount);
        Payment doPayment = new Payment(aliceAccount, bobAccount, BigDecimal.valueOf(449.657));
        doPayment.transferAmount();
        System.out.println("Accounts after executing payment\n" + aliceAccount + "\n" + bobAccount);

        /*
         * Where does the Object live?
         * When the new keyword is executed:
         *
         * 1. Heap Allocation: The JVM allocates a contiguous block of memory on the Heap for the object.
         * 2. Object Header: The JVM adds a hidden header to the object (usually 12-16 bytes). This contains:
         *    Mark Word: Used for garbage collection state, hash codes, and thread synchronization (locking).
         *    Klass Pointer: A pointer back to the Class metadata in the Metaspace so the object knows what class it belongs to.
         */

        /*
         * Where does the Reference live?
         * In the code BankAccount aliceAccount = new BankAccount():
         * The actual object exists on the Heap.
         * The variable aliceAccount is merely a 32-bit or 64-bit reference (a memory address) stored on the Thread Stack (because it is a local variable in the main method).
         */
    }
}
