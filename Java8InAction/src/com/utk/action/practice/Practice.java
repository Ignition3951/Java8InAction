package com.utk.action.practice;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Practice {

    static void main() {

        /*
         * Java Program to convert a List to map in Java 8.
         * This example shows a trick to preserve order of element
         * in the list while converting to Map using LinkedHashMap.
         */

        List<String> hostingProviders = Arrays.asList("Bluehost",
                "GoDaddy", "Amazon AWS", "LiquidWeb", "FatCow");
        System.out.println("list: " + hostingProviders);

        LinkedHashMap<String, Integer> collect = hostingProviders.stream()
                .collect(Collectors.toMap(Function.identity(), String::length, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println("map: " + collect);
    }

}
