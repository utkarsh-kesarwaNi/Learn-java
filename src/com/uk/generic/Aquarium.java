package com.uk.generic;

public class Aquarium<T> {

    private T fish;

    public void addFish(T fish) {
        this.fish = fish;
    }

    public T getFish() {
        return fish;
    }
}

/*
 * Generics provide a facility for parametric polymorphism for class, interface and methods.
 */

/*
 * BEHIND THE SCENES (TYPE ERASURE): The Java Virtual Machine (JVM) knows absolutely NOTHING about generics.
 * Generics are a COMPILE-TIME FICTION.
 *
 * When the Java compiler compiles `Aquarium<T>`, it performs "Type Erasure".
 * It replaces all generic parameters (T) with their lowest bound (Object, if unbounded).
 *
 * The actual bytecode produced for Aquarium.class looks exactly like this:
 * public class Aquarium {
 *     private Object fish;
 *     public void setItem(Object fish) { this.fish = fish; }
 *     public Object getFish() { return fish; }
 * }
 */
