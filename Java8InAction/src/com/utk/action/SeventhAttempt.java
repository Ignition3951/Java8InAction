package com.utk.action;

import java.util.ArrayList;
import java.util.List;

import com.utk.model.Apple;
import com.utk.service.ApplePredicate;
import com.utk.service.Predicate;

//2.3.4. Seventh attempt: abstracting over List type
public class SeventhAttempt {
	public static void main(String[] args) {
		
		Apple apple1 = new Apple("Green", 30);
		Apple apple2 = new Apple("Red", 40);
		Apple apple3 = new Apple("Blue", 50);
		Apple apple4 = new Apple("Green", 60);
		Apple apple5 = new Apple("Red", 70);
		Apple apple6 = new Apple("Blue", 80);
		Apple apple7 = new Apple("Green", 90);
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
		System.out.println("Green color objects are : "+filter(apples,(Apple apple) -> "Green".equals(apple.getColor())));
		System.out.println("Even numbers are : "+filter(List.of(1,2,3),(Integer i) -> i%2==0));
	}
	
	public static <T> List<T> filter(List<T> e,Predicate<T> t) {
		List<T> result = new ArrayList<T>();
		for(T apple: e) {
			if(t.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}

}
