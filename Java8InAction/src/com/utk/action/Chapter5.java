package com.utk.action;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class Chapter5 {

	public static void main(String[] args) {
		List<Integer> numbers1 = Arrays.asList(1,2,3);
		List<Integer> numbers2 = Arrays.asList(4,5);
		
		//Create a output {i,j} having mapped both the lists
		List<int[]> mapped12=
				numbers1.stream()
				.flatMap(list-> numbers2.stream()//to move inside a list of list
						.map(j->new int[] {list,j}))
				.collect(toList());

		for(int i=0;i<mapped12.size();i++) {
				System.out.println("("+mapped12.get(i)[0]+","+mapped12.get(i)[1]+")");
		}
		
		//Introduction of reduce function in  java8
		Optional<Integer> sum = numbers1.stream().reduce((a,b)-> a+b);
		System.out.println(sum);

	}

}
