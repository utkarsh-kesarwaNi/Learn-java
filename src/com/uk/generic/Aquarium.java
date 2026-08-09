package com.uk.generic;

public class Aquarium<T> {

    private final T fish;

    public Aquarium(T fish) {
        this.fish = fish;
    }

    public T getFish() {
        return fish;
    }
}

/*
* Generics provide a facility for parametric polymorphism for class, interface and methods.
*/
