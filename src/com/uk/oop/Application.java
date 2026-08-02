package com.uk.oop;

public class Application {
    static void main(String[] args) {

//      Object: Creating a concrete instance at runtime

//        aliceAccount is REFERENCE pointing to a BankAccount object in memory
        BankAccount aliceAccount = new BankAccount();

//        "bobAccount" points to a completely different memory location
        BankAccount bobAccount = new BankAccount();

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
