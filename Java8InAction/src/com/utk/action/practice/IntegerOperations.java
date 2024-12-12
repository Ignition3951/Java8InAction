package com.utk.action.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class IntegerOperations {

	public static void main(String[] args) {
		
		List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
		
		listOfIntegers.stream().filter(number-> number %5==0).forEach(number-> System.out.println(number));//multiples of 5
		
		Integer maxNumber = listOfIntegers.stream().max(Comparator.naturalOrder()).get();
		
		Integer minNumber = listOfIntegers.stream().min(Comparator.naturalOrder()).get();
		
		System.out.println("Maximum number is : "+maxNumber+" minimum number is : "+minNumber);
		
		int[] listOfIntegersOne = {45, 12, 56, 15, 24, 75, 31, 89};
		
		int[] listOfIntegersTwo = {45, 12, 56, 15, 24, 75, 31, 89};
		
		int[] concatList = IntStream.concat(Arrays.stream(listOfIntegersOne), Arrays.stream(listOfIntegersTwo)).toArray();
		
		System.out.println("Concatenated string with duplicates is : "+Arrays.toString(concatList));
		
		int[] concatListWithoutDuplicates = IntStream.concat(Arrays.stream(listOfIntegersOne), Arrays.stream(listOfIntegersTwo)).sorted().distinct().toArray();
		
		System.out.println("Concatenated string without duplicates is : "+Arrays.toString(concatListWithoutDuplicates));

	}

}
