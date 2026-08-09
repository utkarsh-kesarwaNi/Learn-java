package com.uk.generic;

public class App {

    static void main(String[] args) {
        Aquarium<Goldfish> goldfishAquarium = new Aquarium<>(new Goldfish());
        goldfishAquarium.getFish().swim();

        Aquarium<Arowana> arowanaAquarium = new Aquarium<>(new Arowana());
        arowanaAquarium.getFish().swim();

        Aquarium<Koi> koiAquarium = new Aquarium<>(new Koi());
        koiAquarium.getFish().swim();

        Aquarium<Flowerhorn> flowerhornAquarium = new Aquarium<>(new Flowerhorn());
        flowerhornAquarium.getFish().swim();
    }
}
