package com.utk.interviews;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> squareNumbers = numbers.stream()
                .map(s -> {
                    return s * s;
                })
                .collect(Collectors.toList());
        System.out.println(squareNumbers);

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eva");
        Integer max = names.stream()
                .map(String::length)
                .max(Integer::compare)
                .get();

        System.out.println(max.toString());

        List<String> sentences = Arrays.asList(
                "Java Stream API provides a fluent interface for processing sequences of elements.",
                "It supports functional-style operations on streams of elements, such as map-reduce transformations.",
                "In this exercise, you need to count the total number of words in all sentences."
        );
        long distinctWords = sentences.stream()
                .flatMap(word -> Arrays.stream(word.split(" ")))
                .distinct()
                .count();
        System.out.println(distinctWords);

        List<String> fruits = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");

        String concatenatedFruit = fruits.stream()
                .filter(fruit -> fruit.length() %2 ==0)
                .limit(2)
                .collect(Collectors.joining());
        System.out.println(concatenatedFruit);

        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        IntStream sumOfSquaresOfEvenNumbers = numbers1.stream()
                .filter(number -> number % 2 == 0)
                .map(i -> i * i)
                .mapToInt(value -> Integer.sum(value,0));
        System.out.println(sumOfSquaresOfEvenNumbers.sum());

        OptionalDouble average = numbers1.stream()
                .mapToDouble(value -> Double.sum(value,0))
                .average();
        System.out.println(average.orElse(0.0));

        List < Integer > removeDuplicates = Arrays.asList(10, 23, 22, 23, 24, 24, 33, 15, 26, 15);

        List<Integer> duplicatesRemoved =  removeDuplicates.stream()
                .distinct().collect(Collectors.toList());
        System.out.println(duplicatesRemoved);

        List < String > colors = Arrays.asList("Red", "Green", "Blue", "Pink", "Brown");
        Stream<String> colorStartingWithR = colors.stream()
                .filter(word -> word.startsWith("B"));
        colorStartingWithR.forEach(System.out::println);

        colors.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        List < Integer > findMax = Arrays.asList(1, 17, 589, 14, 14, 89, 45, -11);

        Optional<Integer> maxNumber = findMax.stream().max(Integer::compare);
        maxNumber.ifPresent(System.out::println);

        Optional<Integer> secondHighest = findMax.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
secondHighest.ifPresent(System.out::println);

    }
}
