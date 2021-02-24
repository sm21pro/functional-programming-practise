package com.srikanth.functional.Advanced;

import java.util.function.Function;

public class Composition {

    public static void main(String[] args) {
        Function<Integer, Integer> timesTwo = x -> 2 * x;
        Function<Integer, Integer> minusOne = x -> x - 1;

        // Compose/combine the two function = 2x - 1 i.e. 2 times x computed followed by 2x result passed as x in x-1 function
        // compose method allows that - observe that compose has to be in reverse order
        Function<Integer, Integer> timeTwoMinusOne = minusOne.compose(timesTwo);
        Integer result1 = timeTwoMinusOne.apply(10);

        // Other way is to use andThen
        timeTwoMinusOne = timesTwo.andThen(minusOne);
        Integer result2 = timeTwoMinusOne.apply(10);

        System.out.println(result1 + " == " + result2);
    }
}
