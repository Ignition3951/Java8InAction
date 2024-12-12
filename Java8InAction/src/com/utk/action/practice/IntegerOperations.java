package com.utk.action.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IntegerOperations {

	public static void main(String[] args) {
		
		List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
		
		listOfIntegers.stream().filter(number-> number %5==0).forEach(number-> System.out.println(number));//multiples of 5
		
		Integer maxNumber = listOfIntegers.stream().max(Comparator.naturalOrder()).get();
		
		Integer minNumber = listOfIntegers.stream().min(Comparator.naturalOrder()).get();
		
		System.out.println("Maximum number is : "+maxNumber+" minimum number is : "+minNumber);
		
		

	}

}
