package com.uk.intstream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ProblemStatement {

    static void main(String[] args) {
        /*
        We are providing int type values to the Stream but the Java compiler automatically converts primitive type
        to the corresponding object wrapper class. This is called autoboxing.

        This is a performance overhead as compiler has to do a lot of autoboxing
        */
        Stream<Integer> integerStream = Stream.of(2, 3, 5, 7, 11, 13, 17, 19);
        System.out.println("Stream of Integer");
        integerStream.forEach(System.out::println); // This println method accepts Object as argument

//        To overcome this we have IntStream
        IntStream intStreamOne = IntStream.of(2, 3, 5, 7, 11, 13, 17, 19);
        System.out.println("IntStream of int");
        intStreamOne.forEach(System.out::println); // This println method accepts int as argument, the primitive type

//        How this is useful ?
        int a = 10; // Primitive int value occupies 4 bytes of memory
        Integer b = 10; // Integer object occupies 16 bytes of memory, this depends on your machine configuration(32 bit or 64 bit)

//        Terminal operations in IntStream
        IntStream intStreamTwo = IntStream.of(2, 3, 5, 7, 11, 13, 17, 19);
        int sum = intStreamTwo.sum();
        System.out.println("Sum of elements in intStreamTwo : " + sum);

        IntStream intStreamThree = IntStream.of(2, 83, 5, 7, 11, 13, 17, 19);
        int min = intStreamThree.min().orElse(-1);
        System.out.println("Minimum in intStreamThree : " + min);

        IntStream intStreamFour = IntStream.of(2, 83, 5, 7, 11, 13, 17, 19);
        int max = intStreamFour.max().orElse(-1);
        System.out.println("Minimum in intStreamThree : " + max);
    }
}
