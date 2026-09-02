package com.uk.generic.upperbound;

import com.uk.datasource.Animal;
import com.uk.datasource.Cat;
import com.uk.datasource.Dog;
import com.uk.datasource.GingerCat;

public class UpperBound {

    static void main(String[] args) {

//        Logically Shelter was created for Creatures or Animal
        Shelter<Cat> catShelter = new Shelter<>(new Cat(), new GingerCat());
        Shelter<Dog> dogShelter = new Shelter<>(new Dog(), new Dog());
        Shelter<Animal> animalShelter = new Shelter<>(new Animal(), new Animal());

        Cat catTwo = catShelter.getPetTwo();
        System.out.println(catTwo);

        /*
        String/BigInteger is not an Animal

        Shelter<String> stringShelter = new Shelter<>("Spot", "Rex");
        Shelter<BigInteger> bigIntegerShelter = new Shelter<>(BigInteger.ONE, BigInteger.TWO);

        Upper Bounds prevents these logical errors at compile time

        Converts Shelter<T> to Shelter<T extends Animal>
      * By defining the class as "class Home<T extends Animal>", we set an UPPER BOUND.
      * T can be Animal, or any subclass of Animal. It cannot be anything else.
        */
    }
}

/*
 *                          +-----------------+
 *                          |    Creature     |
 *                          +-----------------+
 *                                   ^
 *                                   |
 *                          +-----------------+
 *                          |     Animal      |
 *                          +-----------------+
 *                                   ^
 *                                   |
 *                  +----------------+----------------+
 *                  |                                 |
 *         +-----------------+               +-----------------+
 *         |       Cat       |               |       Dog       |
 *         +-----------------+               +-----------------+
 *                  ^                                 ^
 *                  |                                 |
 *         +-----------------+               +-----------------+
 *         |    GingerCat    |               |      Husky      |
 *         +-----------------+               +-----------------+
 */