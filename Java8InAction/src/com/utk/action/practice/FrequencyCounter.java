package com.utk.action.practice;

import static java.util.stream.Collectors.groupingBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyCounter {

	public static void main(String[] args) {

		String inputString = "Java Concept Of The Day";

		Map<Character, Long> charCounter = inputString.chars().mapToObj(c -> (char) c)
				.collect(groupingBy(Function.identity(), Collectors.counting()));// Function.identity return the input
																					// argument as output of the
																					// function
		// Collectors.counting returns the number of input as output

		System.out.println(charCounter);
		
		/**
		 * Second example of frequency counter
		 */
		
		List<String> listOfStationary = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");
		
		Map<String, Long> frequencyOfStationary = listOfStationary.stream()
		.collect(groupingBy(Function.identity(), Collectors.counting()));
		
		System.out.println(frequencyOfStationary);
		
	}

}
