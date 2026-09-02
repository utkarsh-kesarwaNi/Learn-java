package com.uk.generic.upperbound;

import com.uk.datasource.Animal;

public class Shelter<T extends Animal> {
    private final T petOne;
    private final T petTwo;

    public Shelter(T petOne, T petTwo) {
        this.petOne = petOne;
        this.petTwo = petTwo;
    }

    public T getPetOne() {
//        We can safely call makeSound() because T is guaranteed to extend Animal
        petOne.makeSound();
        return petOne;
    }

    public T getPetTwo() {
//        We can safely call makeSound() because T is guaranteed to extend Animal
        petTwo.makeSound();
        return petTwo;
    }
}

/*
 * HOW DOES TYPE ERASURE WORK WITH UPPER BOUNDS?
 * Unbounded `<T>` erases to `Object`.
 * Bounded `<T extends Animal>` erases to the bound: `Animal`.
 *
 * +---------------------------------------------------------+
 * | COMPILE-TIME PERSPECTIVE     | RUNTIME PERSPECTIVE      |
 * +---------------------------------------------------------+
 * | Home<Cat>                    | Home                     |
 * | - petOne: Cat                | - petOne: Animal         |
 * | - getPetOne(): Cat           | - getPetOne(): Animal    |
 * +---------------------------------------------------------+
 */