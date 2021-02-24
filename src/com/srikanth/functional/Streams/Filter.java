package com.srikanth.functional.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filter {

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        List<Integer> intList = Arrays.asList(intArray);

        // Get even numbers

        Predicate<Integer> isEven = x -> x % 2 == 0;

        List<Integer> evenList = intList
                .stream()
                .filter(isEven) // can be written as .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(intList);
        System.out.println(evenList);


        // Get String longer than 5 chars
        String[] words = {"Hello", "Srikanth", "Srika", "also", "Nani"};
        List<String> wordsList = Arrays.asList(words);

        Predicate<String> isLonger = word -> word.length() > 5;

        System.out.println(wordsList);

        System.out.println(wordsList.stream().filter(isLonger).collect(Collectors.toList()));

        // what if the length must be dynamic
        // Create a Function that takes Integer and returns the predicate
        Function<Integer, Predicate<String>> createLengthPredicate = (length) -> word -> word.length() > length;

        // Create predicate for 3
        Predicate<String> isLongerThan4 = createLengthPredicate.apply(4);

        System.out.println(wordsList.stream().filter(isLongerThan4).collect(Collectors.toList()));

    }
}
