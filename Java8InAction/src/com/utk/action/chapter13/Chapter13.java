package com.utk.action.chapter13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * We think in terms of what to do and not how to do it which helps us in
 * achieving this feat in a functional way of
 * programming
 * 
 * */
public class Chapter13 {

	public static void main(String[] args) {

		List<Integer> set = Arrays.asList(1, 4, 9);
		List<List<Integer>> subsets = subsets(set);
		System.out.println(subsets.toString());
	}

	public static List<List<Integer>> subsets(List<Integer> set) {
		if (set.isEmpty()) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			result.add(Collections.emptyList());
			return result;
		}
		Integer first = set.get(0);
		List<Integer> subset = set.subList(1, set.size());
		List<List<Integer>> subsets = subsets(subset);
		List<List<Integer>> partialResult = insertAll(first, subsets);
		List<List<Integer>> finalResult = concat(subsets, partialResult);
		return finalResult;
	}

	public static List<List<Integer>> insertAll(Integer first, List<List<Integer>> subset) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (List<Integer> list : subset) {
			List<Integer> copyList = new ArrayList<Integer>();
			copyList.add(first);
			copyList.addAll(list);
			result.add(copyList);
		}
		return result;
	}

	public static List<List<Integer>> concat(List<List<Integer>> subsets, List<List<Integer>> partialResult) {
		List<List<Integer>> finalList = new ArrayList<List<Integer>>(subsets);
		finalList.addAll(partialResult);
		return finalList;
	}

}
