package com.uk.stream;

import java.util.Arrays;
import java.util.stream.Stream;

// Demonstrates: filter() + map() + forEach() pipeline
// filter() -> intermediate operation, keeps elements matching the predicate
// map()    -> intermediate operation, transforms each element to another type/value
// forEach()-> terminal operation, consumes the stream
public class FilterAndMap {

    public static void main(String[] args) {

        Integer[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        // Arrays.stream() -> creates a sequential Stream from the array
        Stream<Integer> integerStream = Arrays.stream(nums);

        integerStream
            .filter(number -> number > 5)        // keeps: 6, 7, 8, 9
            .map(FilterAndMap::toWord)            // transforms: 6 -> "Six", etc.
            .forEach(System.out::println);        // terminal: prints each word
    }

    // Extracted to a method for re-usability and cleaner pipeline
    private static String toWord(int number) {
        return switch (number) {
            case 1 -> "One";
            case 2 -> "Two";
            case 3 -> "Three";
            case 4 -> "Four";
            case 5 -> "Five";
            case 6 -> "Six";
            case 7 -> "Seven";
            case 8 -> "Eight";
            case 9 -> "Nine";
            default -> "NA";
        };
    }
}