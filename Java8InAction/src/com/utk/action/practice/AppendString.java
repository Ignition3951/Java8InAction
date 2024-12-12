package com.utk.action.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AppendString {

	public static void main(String[] args) {

		List<String> listOfString = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");

		String joinedString = listOfString.stream().collect(Collectors.joining(",", "[", "]"));

		System.out.println(joinedString);

	}

}
