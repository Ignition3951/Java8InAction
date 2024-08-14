package com.utk.action;

import java.util.ArrayList;
import java.util.List;

import com.utk.model.Apple;
import com.utk.service.AppleComparator;

public class Chapter3 {
	
	public static void main(String[] args) {
		
		Apple apple1 = new Apple("Green", 130);
		Apple apple2 = new Apple("Red", 40);
		Apple apple3 = new Apple("Blue", 50);
		Apple apple4 = new Apple("Green", 160);
		Apple apple5 = new Apple("Red", 70);
		Apple apple6 = new Apple("Blue", 80);
		Apple apple7 = new Apple("Green", 190);
		Apple apple8 = new Apple("Green", 100);
		List<Apple> apples = new ArrayList<Apple>();
		apples.add(apple1);
		apples.add(apple2);
		apples.add(apple3);
		apples.add(apple4);
		apples.add(apple5);
		apples.add(apple6);
		apples.add(apple7);
		apples.add(apple8);
		//Step 1 for behaviour sorting
		apples.sort(new AppleComparator());
		System.out.println(apples.toString());
	}

}