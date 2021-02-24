package com.srikanth.functional.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class Reduce {

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> intList = Arrays.asList(intArray);

        // Get sum of the elements

        // Binary Operator
        BinaryOperator<Integer> getSum = (acc, x) -> {
            Integer result = acc + x;
            // Just to understand what's happening inside the reduce
            System.out.println("acc: " + acc + ", " + "x: " + x + ", " + "result: " + result);
            return result;
        };

        // Note not using collect.
        System.out.println("Sum: " + intList.stream().reduce(0, getSum));

    }
}
