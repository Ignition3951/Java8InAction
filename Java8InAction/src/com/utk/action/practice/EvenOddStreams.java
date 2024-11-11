package com.utk.action.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import static java.util.stream.Collectors.toList;

import static java.util.stream.Collectors.partitioningBy;

public class EvenOddStreams {

	public static void main(String[] args) {
		System.out.println("-------------First Attempt to get even numbers only---------------------");

		List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);

		List<Integer> listOfEvenNumbers = listOfIntegers.stream().filter(number -> number % 2 == 0)
				.peek(number -> System.out.print(number + " ")).collect(toList());// Only fetches the even or odd
																					// numbers for that matter
		System.out.println();
		System.out.println("-------------Second Attempt using partitioning---------------------");

		Map<Boolean, List<Integer>> mapOfEvenAndOdd = listOfIntegers.stream().collect(partitioningBy(i -> i % 2 == 0));

		for (Entry<Boolean, List<Integer>> entry : mapOfEvenAndOdd.entrySet()) {
			if (entry.getKey()) {
				System.out.println("Even Numbers are :");
			} else {
				System.out.println("Odd Numbers are :");
			}
			List<Integer> numbers = entry.getValue();
			for (Integer number : numbers) {
				System.out.println(number);
			}
		}

	}

}
