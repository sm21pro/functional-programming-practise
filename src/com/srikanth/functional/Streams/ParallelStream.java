package com.srikanth.functional.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStream {

    public static void main(String[] args) {
        String[] words = {"Hello", "Srikanth", "Prasanth", "Srikanth", "Srika", "also", "Nani"};
        List<String> wordsList = Arrays.asList(words);

        List<String> parallelStream = wordsList
                .parallelStream()
                .map((word) -> {
                    System.out.println("Converting case " + word);
                    return word.toUpperCase();
                })
                .map((word) -> {
                    System.out.println("Adding exclamation " + word);
                    return word + "!";
                })
                .collect(Collectors.toList());

        System.out.println(parallelStream);

    }
}
