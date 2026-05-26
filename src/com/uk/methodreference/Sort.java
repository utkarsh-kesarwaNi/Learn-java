package com.uk.methodreference;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class Sort {

    public static void main(String[] args) {
        List<Integer> unsortedNums = Arrays.asList(21, 13, 8, 16, 26, 4);

//		Isort iSort = (nums) -> Collections.sort(nums);

//		Single line lambda can be replaced with method reference
//		Isort is our functional interface
        Isort iSort = Collections::sort;
        iSort.sortAList(unsortedNums);
        System.out.println(unsortedNums);

//		Using inbuilt functional interface
        Consumer<List<Integer>> sortingLogic = Collections::sort;
        sortingLogic.accept(unsortedNums);
        System.out.println(unsortedNums);
    }

}
