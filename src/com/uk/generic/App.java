package com.uk.generic;

public class App {

    static void main(String[] args) {

//        INITIALIZATION & AUTOMATIC CASTING
        Aquarium<Goldfish> goldfishAquarium = new Aquarium<>();
        goldfishAquarium.addFish(new Goldfish());
        Goldfish goldfish = goldfishAquarium.getFish();
        swim(goldfish);

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
//        Type witness
        App.<Arowana>swim(arowana);

        Aquarium<Koi> koiAquarium = new Aquarium<>();
        koiAquarium.addFish(new Koi());
        Koi koi = koiAquarium.getFish();
        swim(koi);

        Aquarium<Flowerhorn> flowerhornAquarium = new Aquarium<>();
        flowerhornAquarium.addFish(new Flowerhorn());
        Flowerhorn flowerhorn = flowerhornAquarium.getFish();
        swim(flowerhorn);

        bunch(new String[]{"Goldfish", "Koi", "Arowana"});
        bunch(new Float[]{10.23f, 11.23412f});

        String status = canShareAquarium(goldfish, koi) ? "can" : "cannot";
        System.out.printf("Goldfish and koi %s share aquarium\n", status);

        Aquarium.printClassName(goldfish);
    }

    public static <T> void swim(T t) {
        System.out.println(t.getClass().getName() + " is swimming");
    }

    /*
     * Generic functions, helps us in avoiding multiple overloaded functions i.e. swim(Goldfish goldfish), swim(Koi koi),...
     * SYNTAX RULE: The type parameter `<T>` MUST be placed BEFORE the return type.
     *
     * Just like generic classes, generic methods undergo type erasure, the compiler converts the function to:
     * public static void swim(Object t) {
     * System.out.println(t.getClass().getName() + " is swimming");
     * }
     */

    public static <T> void bunch(T[] t) {
        for(T current : t) {
            System.out.println(current);
        }
    }

    public static <T, U> boolean canShareAquarium(T fishOne, U fishTwo) {
        return !fishOne.getClass().getName().contains("Shark") && !fishTwo.getClass().getName().contains("Shark");
    }
}