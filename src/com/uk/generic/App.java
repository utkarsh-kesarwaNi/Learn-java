package com.uk.generic;

public class App {

    static void main(String[] args) {

//        INITIALIZATION & AUTOMATIC CASTING
        Aquarium<Goldfish> goldfishAquarium = new Aquarium<>();
        goldfishAquarium.addFish(new Goldfish());
        Goldfish goldfish = goldfishAquarium.getFish();

        /*
         * What happens here?
         * At compile-time, the compiler ensures you only pass a Goldfish object to addFish().
         * BUT at runtime, because of Type Erasure, goldfishAquarium is just a Aquarium holding an `Object`.
         *
         * HOW DOES THE RETURN WORK WITHOUT EXPLICIT CASTING?
         * The compiler silently injects a cast byte-code (`checkcast`) for you.
         *
         * Goldfish goldfish = goldfishAquarium.getFish(); was interpreted as Goldfish goldfish = (Goldfish) goldfishAquarium.getFish();
         *
         * +---------------------------------------------------------+
         * | COMPILE-TIME PERSPECTIVE     | RUNTIME PERSPECTIVE      |
         * +---------------------------------------------------------+
         * | Aquarium<Goldfish>           | Aquarium                 |
         * | - fish: Goldfish             | - fish: Object           |
         * | - addFish(Goldfish): void    | - addFish(Object): void  |
         * | - getFish(): Goldfish        | - getFish(): Object      |
         * +---------------------------------------------------------+
         */

        Aquarium<Arowana> arowanaAquarium = new Aquarium<>();
        arowanaAquarium.addFish(new Arowana());
        Arowana arowana = arowanaAquarium.getFish();

        Aquarium<Koi> koiAquarium = new Aquarium<>();
        koiAquarium.addFish(new Koi());
        Koi koi = koiAquarium.getFish();

        Aquarium<Flowerhorn> flowerhornAquarium = new Aquarium<>();
        flowerhornAquarium.addFish(new Flowerhorn());
        Flowerhorn flowerhorn = flowerhornAquarium.getFish();
    }
}