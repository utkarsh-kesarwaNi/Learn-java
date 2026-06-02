package com.uk.stream;

import java.util.function.BinaryOperator;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReduceFunction {

    static void main(String[] args) {
        Stream<Integer> integerStreamOne = Stream.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34);

//        reduce() performs a reduction on the elements of this stream using provided functiom
        Integer sumUsingBiFunction = integerStreamOne.reduce(new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer1, Integer integer2) {
                return integer1 + integer2;
            }
        }).orElse(0);
        System.out.println(sumUsingBiFunction);

        Stream<Integer> integerStreamTwo = Stream.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34);
        Integer sum = integerStreamTwo.reduce(Integer::sum).orElse(0);
        System.out.println(sum);

//        Convert Stream<Integer> to IntStream
        Stream<Integer> integerStreamThree = Stream.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34);
//        mapToInt returns an IntStream
        IntStream intStream = integerStreamThree.mapToInt(new ToIntFunction<Integer>() {
            @Override
            public int applyAsInt(Integer value) {
                return value;
            }
        });
//        IntStream intStream = integerStreamThree.mapToInt(value -> value);
//        IntStream intStream = integerStreamThree.mapToInt(Integer::intValue);
        System.out.println(intStream.sum());
    }
}
