package com.srikanth.functional.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Map {

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        Function<Integer, Integer> timesTwo = x -> x * 2;

        List<Integer> intList = Arrays.asList(intArray);
        List<Integer> doubledList = intList
                .stream()
                .map(timesTwo) // also .map(x -> x * 2)
                .collect(Collectors.toList());

        System.out.println(intList);
        System.out.println(doubledList);
    }
}
