package com.utk.action.practice;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class EvenOddStreams {

	public static void main(String[] args) {

		List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);

		List<Integer> listOfEvenNumbers = listOfIntegers.stream().filter(number -> number % 2 == 0)
				.peek(number -> System.out.print(number + " ")).collect(toList());// Only fetches the even or odd
																					// numbers for that matter

	}

}
