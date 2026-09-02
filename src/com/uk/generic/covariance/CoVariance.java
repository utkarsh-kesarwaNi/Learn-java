package com.uk.generic.covariance;

import java.util.Arrays;
import java.util.List;

public class CoVariance {

    /*
     * Generics are strictly invariant to prevent runtime type pollution
     *
     * Number num = new Integer(10);    Works fine in java
     *
     * List<Number> nums = new ArrayList<Integer>(); // COMPILE ERROR!
     */

    static void main() {
        List<Integer> integerList = Arrays.asList(12, 24, 48);
        System.out.println(add(integerList));

        List<Long> longList = Arrays.asList(12L, 24L, 48L);
        List<Number> numberList = Arrays.asList(12L, 2.4, 48);
//        System.out.println(add(longList));  COMPILE ERROR

        /*
         * TYPE INFERENCE IN ACTION:
         * When you pass `integerList`, the compiler infers T = Integer.
         * When you pass `longList`, the compiler infers T = Long.
         */
        System.out.println("Integer sum using addAny(): " + addAny(integerList));
        System.out.println("Long sum using addAny(): " + addAny(longList));
        System.out.println("Number sum using addWildCard(): "+ addWildcard(numberList));
    }

    /*
     * APPROACH 1: TYPE PARAMETER
     * Explicitly capture the exact subtype of Number in the variable `T`.
     */
    public static <T extends Number> Long addAny(List<T> listOfNumbers) {
        long sum = 0L;
        for (T x : listOfNumbers) {
            sum += x.longValue();
        }
        return sum;
    }

    /*
     * APPROACH 2: WILDCARD
     * We don't care what the exact subtype is, as long as it extends Number.
     */
    public static Double addWildcard(List<? extends Number> listOfNumbers) {
        double sum = 0L;
        for (Number x : listOfNumbers) {
            sum += x.doubleValue();
        }
        return sum;
    }

//    This function strictly accepts List<Integer>. It will reject List<Long>, List<Double>, List<Number>
    public static Integer add(List<Integer> integerList) {
        int sum = 0;
        for (Integer x : integerList) {
            sum += x;
        }
        return sum;
    }
}
