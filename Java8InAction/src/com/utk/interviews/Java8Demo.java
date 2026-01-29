package com.utk.interviews;

import javax.xml.stream.events.Characters;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Demo {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        long evenNumbersCount = list.stream()
                .filter(x -> x % 2 == 0)
                .count();
        System.out.println(evenNumbersCount);

        String sentence = "Hello World";
        long numberOfChar = sentence
                .chars()
                .mapToObj(x -> (char) x)
                .filter(x -> x == 'l').count();
        System.out.println(numberOfChar);

        List<String> names = Arrays.asList("hello", "world", "java", "streams", "collecting");
        System.out.println(names.stream()
                .collect(Collectors.groupingBy(String::length))
        );
        System.out.println(names.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()))
        );
        TreeMap<Integer, Long> treeMap = names.stream()
                .collect(Collectors.groupingBy(String::length,(TreeMap::new),Collectors.counting()));
        System.out.println(treeMap);

        //Example 1: Collecting names by length
        List<String> example1 = Arrays.asList("Anna","Bob","Alexander","Brian","Alice");
        System.out.println(example1.stream()
                .collect(Collectors.groupingBy(String::length)));

        //Example 2: Counting word occurrences
        String example2 = "hello world hello java world";
        Map<Object, Long> wordCount = Stream.of(example2.split(" "))
                .collect(Collectors.groupingBy(x -> x,Collectors.counting()));
        System.out.println(wordCount);

        // Example 3: Partitioning even and odd numbers
        List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, Long> evOdPartitionCount = l1.stream()
                .collect(Collectors.partitioningBy(x -> x%2==0,Collectors.counting()));
        System.out.println(evOdPartitionCount);

        Map<Boolean, List<Integer>> evOdPartitionNumbers = l1.stream()
                .collect(Collectors.partitioningBy(x -> x%2==0));
        System.out.println(evOdPartitionNumbers);

        // Example 4: Summing values in a map
        Map<String,Integer> fruits = new   HashMap<>();
        fruits.put("apple",10);
        fruits.put("orange",20);
        fruits.put("kiwi",30);
        System.out.println(fruits.values().stream()
                .reduce(Integer::sum).orElse(null)
        );

        // Example 5: Create a map from stream elements
        List<String> fruitsList = Arrays.asList("apple","orange","kiwi");
        System.out.println(fruitsList.stream()
                .collect(Collectors.toMap(String::toUpperCase, String::length))
        );

        // Example 6: In case of duplicates
        List<String> fruitsListDuplicate = Arrays.asList("apple","orange","kiwi","apple","kiwi","apple");
        System.out.println(fruitsListDuplicate.stream()
                .collect(Collectors.toMap(k->k,v->1, Integer::sum))
        );
    }
}
