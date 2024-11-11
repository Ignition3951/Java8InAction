package com.utk.action.practice;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class RemoveDuplicate {

	public static void main(String[] args) {

		List<String> listOfString = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");

		listOfString.stream().distinct().peek(element -> System.out.println(element)).collect(toList());// Done in first
																										// Attempt

	}

}
