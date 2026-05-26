package com.uk.stream;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamOf {

	public static void main(String[] args) {

//		Stream.of(T.. values) returns a sequential ordered stream whose elements are the specified values.
		Stream<Integer> streamOfIntegers = Stream.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47);
		Consumer<Integer> consumerAnonymousClass = new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
		};
		Consumer<Integer> consumerLambda = (t) -> System.out.println(t);
		
		streamOfIntegers.forEach(consumerLambda);
	}

}
