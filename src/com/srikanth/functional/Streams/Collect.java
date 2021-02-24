package com.srikanth.functional.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Collect {

    public static void main(String[] args) {
        String[] words = {"Hello", "Srikanth", "Prasanth", "Srikanth", "Srika", "also", "Nani"};
        List<String> wordsList = Arrays.asList(words);

        List<String> longWords = wordsList
                .stream()
                .filter(word -> word.length() > 5)
                .collect(Collectors.toList());
        System.out.println(longWords);

        Set<String> longWordsSet = wordsList
                .stream()
                .filter(word -> word.length() > 5)
                .collect(Collectors.toSet());
        System.out.println(longWordsSet);

        String longWordsString = wordsList
                .stream()
                .filter(word -> word.length() > 5)
                .collect(Collectors.joining(", "));
        System.out.println(longWordsString);

        Long countOfLongerWords = wordsList
                .stream()
                .filter(word -> word.length() > 5)
                .collect(Collectors.counting());
        System.out.println(countOfLongerWords);

        // Grouping by how many characters strings have
        Map<Integer, List<String>> groupedWords = wordsList
                .stream()
                .collect(Collectors.groupingBy(word -> word.length()));
        System.out.println(groupedWords);

        // Partitioning by - Similar to Grouping but its a Predicate to split up the list
        Map<Boolean, List<String>> partitionedList = wordsList
                .stream()
                .collect(Collectors.partitioningBy(word -> word.length() > 5));
        System.out.println(partitionedList);

    }
}
