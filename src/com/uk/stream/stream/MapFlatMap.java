package com.uk.stream.stream;

import java.util.ArrayList;
import java.util.List;

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
    }

    public static <T> List<T> flatten(List<List<T>> nestedLists) {
        List<T> result = new ArrayList<>();
        for (List<T> currentList : nestedLists) {
            result.addAll(currentList);
        }
        return result;
    }
}