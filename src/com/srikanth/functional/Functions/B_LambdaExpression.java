package com.srikanth.functional.Functions;

import java.util.function.Function;

public class B_LambdaExpression {

    public static void main(String[] args) {

        // Define a lambda function as
        Function<Integer, Integer> doubleUp =
                (Integer x) -> {    // Taking integer
                    return x * 2;   // returning integer
                };

        // Can be written as
        doubleUp = x -> x * 2;

        System.out.println(doubleUp.apply(3));
    }
}
