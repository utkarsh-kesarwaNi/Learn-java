package com.uk.streamapi.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class MapFlatMap {

    static void main(String[] args) {
        List<Integer> numOne = List.of(0, 1, 1, 2, 3);
        List<Integer> numTwo = List.of(5, 8, 13, 21, 34);
        List<Integer> numThree = List.of(55);

        List<List<Integer>> nestedList = new ArrayList<>();
        nestedList.add(numOne);
        nestedList.add(numTwo);
        nestedList.add(numThree);

        System.out.println("Nested list of integers: " + nestedList);

        List<Integer> result = flatten(nestedList);
        System.out.println("Flattened list: " + result);

        List<List<String>> stringLists = List.of(
                List.of("My", "name"),
                List.of("is", "Utkarsh")
        );
        System.out.println("Nested list of strings: " + stringLists);
        System.out.println("Flattened strings: " + flatten(stringLists));

//        Input : [0, 1, 1, 2, 3]
//        Output : [Value is 0, Value is 1, Value is 1, Value is 2, Value is 3]
//        For one to one transformation, we can use map
        Stream<String> streamOne = numOne.stream().map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return "Value is " + integer;
            }
        });
        System.out.println(streamOne.toList());

//        Use lambda expression
        List<String> listTwo = numTwo.stream().map((value) -> "Value is " + value).toList();
        System.out.println(listTwo);

//        Input : [Hello world, How are you doing today]
//        Output : [Hello, world, How, are, you, doing, today], "Hello world" get converted to "Hello" and "world"
//        One to many transformation, we can use flatMap
        List<String> firstGreetings = List.of("Hello world", "How are you doing today");
        Stream<String> streamOfFirstGreetings = firstGreetings.stream().flatMap(new Function<String, Stream<String>>() {
            @Override
            public Stream<String> apply(String s) {
                return Stream.of(s.split(" "));
            }
        });
        System.out.println(streamOfFirstGreetings.toList());

        List<String> secondGreetings = List.of("Welcome back", "Have a nice day");
        Stream<String> streamOfSecondGreetings = secondGreetings.stream().flatMap((currentString) -> Arrays.stream(currentString.split(" ")));
        System.out.println(streamOfSecondGreetings.toList());

//        Input : [My name, is, Damon, Salvatore]
//        Output : [7, 2, 5, 9]
        List<String> introduction = List.of("My name", "is", "Damon", "Salvatore");
        List<Integer> lengths = introduction.stream().map(String::length).toList();
        System.out.println(lengths);
    }

    public static <T> List<T> flatten(List<List<T>> nestedLists) {
        List<T> result = new ArrayList<>();
        for (List<T> currentList : nestedLists) {
            result.addAll(currentList);
        }
        return result;
    }
}