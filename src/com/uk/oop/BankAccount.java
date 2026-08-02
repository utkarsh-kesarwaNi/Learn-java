package com.uk.oop;

import java.math.BigDecimal;

/*
 * Object-Oriented Programming (OOP) ?
 * Object-Oriented Programming is a programming paradigm that organizes software design around objects rather than functions and logic.
 * It bundles state (attributes) and behaviour (methods) into cohesive units.
 */
public class BankAccount {

    //    Class Variable (Static): Shared across all instances
    private static final String BANK_NAME = "Global Tech Bank";

    //    Instance Variables (State): Unique to each object
    private String accountId;   // Mutable identity
    private BigDecimal balance; // Mutable state
}

/*
 * Class : A compile time construct, user defined blueprint, template or prototype that defines the structure(attribute/fields/state) and behaviour(methods/logic) that its instance will possess.
 * i.e. this is how something will look like, it has this property(attributes/data members) and this is what it can do(behaviour/member functions)
 *
 * Object : A run time construct, an actual, concrete instance of a class allocated in memory.
 * Every object has three essential properties :
 * 1. State(represented by attributes/fields),
 * 2. Behaviour(represented by methods),
 * 3. Identity(a unique memory location/reference that distinguishes it from all other objects, even it state is identical)
 * */

/*
 * Where does the Class live?
 * When the JVM loads your application, the ClassLoader reads the .class bytecode file.
 * It stores the Class Metadata (method code, static variables like BANK_NAME, constant pool, and field layouts) in a
 * native memory region called the Metaspace.
 * */