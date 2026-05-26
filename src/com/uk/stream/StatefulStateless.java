package com.uk.stream;

import java.util.stream.Stream;

public class StatefulStateless {

	public static void main(String[] args) {

//		sorted() is a stateful intermediate operation which returns a stream sorted according to natural order
		Stream.of(10, 21, 1, 3, 22, 99, 43, 23).sorted().forEach(number -> System.out.println(number));
		Stream.of("Elena", "Stefan", "Klaus", "Damon", "Alaric").sorted().forEach(str -> System.out.println(str));

//		filter() is stateless
//		Output : 1, 4, 9, 16, 25, 36, 49
		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).filter(num -> num < 8).map(num -> num * num)
				.forEach(number -> System.out.println(number));

//		takeWhile() is short-circuiting stateful operation, works similar to filter but exits the stream pipeline as soon as condition is false
//		Output : print 1 4 only as 31 < 8 is false, and it does not check any further element
		Stream.of(1, 2, 31, 4, 5, 6, 7, 8, 9).takeWhile(num -> num < 8).map(num -> num * num)
				.forEach(number -> System.out.println(number));

//		skip(n) returns a stream consisting of the remaining elements of this stream after discarding the first n elements of the stream. 
//		If this stream contains fewer than n elements then an empty stream will be returned.
//		Stateful intermediate operation.
//		Output : Klaus Damon Alaric
		Stream.of("Elena", "Stefan", "Klaus", "Damon", "Alaric").skip(2).forEach(str -> System.out.println(str));

//		distinct() returns a stream consisting of the distinct elements (according to Object.equals(Object)) of this stream.
		Stream.of("Elena", "Stefan", "Klaus", "Damon", "Alaric", "Damon", "Caroline", "Elijah").distinct()
				.forEach(str -> System.out.println(str));
	}
}
