package com.utk.action.chapter13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Chapter13 {

	public static void main(String[] args) {

		List<Integer> set = Arrays.asList(1, 4, 9);
		List<List<Integer>> subsets = subsets(set);
	}

	public static  List<List<Integer>> subsets(List<Integer> set){
		if(set.isEmpty()) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			result.add(Collections.emptyList());
			return result;
		}
		Integer first = set.get(0);
		List<Integer> subset = set.subList(1, set.size());
		List<List<Integer>> subsets=subsets(subset);
		
		return null;
	}

	public static List<List<Integer>> insertAll() {
		return null;
	}

	public static List<List<Integer>> concat() {
		return null;
	}

}
