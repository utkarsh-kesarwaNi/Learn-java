package com.uk.stream;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FilterPredicate {

	public static void main(String[] args) {
		
		Integer[] nums = { 2, 3, 5, 7, 9, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47 };
		Stream<Integer> integerStream = Arrays.stream(nums);

		Stream<Integer> filteredIntegerStreamAnonymousClass = integerStream.filter(new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				return t > 15;
			}
		});
//		Stream<T> filter method returns a stream consisting of the elements of this stream that match the given predicate.
		Stream<Integer> filteredIntegerStreamLambda = integerStream.filter(x -> x > 15);

//		filteredIntegerStreamLambda.forEach(numbers -> System.out.println(numbers));

//		Method chaining
		integerStream.filter(number -> number > 5).forEach(numbers -> System.out.println(numbers));
	}

}
