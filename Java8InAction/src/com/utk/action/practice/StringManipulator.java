package com.utk.action.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringManipulator {

	public static void main(String[] args) {
		
		String s1 = "RaceCar";
        String s2 = "CarRace";
        
        s1 = Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        s2 = Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        
        if(s1.equals(s2)) {
        	System.out.println("Strings are anagrams!!!!!");
        }else {
        	System.out.println("Strings are not anagrams!!!!!");
        }
        
        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
        
        List<String> lengthSortedString =  listOfStrings.stream().sorted(Comparator.comparingInt(x->x.length())).collect(Collectors.toList());
        
        System.out.println(lengthSortedString.toString());

	}

}
