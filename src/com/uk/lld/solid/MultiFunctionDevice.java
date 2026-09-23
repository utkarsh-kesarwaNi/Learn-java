package com.uk.lld.solid;

public interface MultiFunctionDevice {
    void print(String document);

    void scan(String document);

    void fax(String document);
}

/*
* Interface Segregation Principle (ISP) states that clients should not be forced to depend upon interfaces that they do not use.
* Interfaces should belong to the clients that invoke them, not to the implementations that execute them.
*
* public class BasicPrinter implements MultiFunctionDevice {
    @Override
    public void print(String document) {
        System.out.println("Printing: " + document);
    }

    @Override
    public void scan(String document) {
        // Violates ISP (forced to implement) AND LSP (throws unexpected exception)
        throw new UnsupportedOperationException("Scanner not supported");
    }

    @Override
    public void fax(String document) {
        throw new UnsupportedOperationException("Fax not supported");
    }
}
*
* SOLUTION
*
* Segregate based on the client
* Printer only exhibits print(String document) functionality
* Xerox exhibits both print(String document) and scan(String document) functionality.
*
* public interface Printer {
    void print(String document);
}

public interface Scanner {
    void scan(String document);
}

public interface Fax {
    void fax(String document);
}
*
* public class BasicPrinter implements Printer {
    @Override
    public void print(String document) {
        System.out.println("Printing: " + document);
    }
}
*
* public class Photocopier implements Printer, Scanner {
    @Override
    public void print(String document) {
        System.out.println("Printing: " + document);
    }

    @Override
    public void scan(String document) {
        System.out.println("Scanning: " + document);
    }
}
* */