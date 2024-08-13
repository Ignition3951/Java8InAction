package com.utk.action;

import java.util.ArrayList;
import java.util.List;

import com.utk.model.Apple;
import com.utk.service.ApplePredicate;

//2.3.3. Sixth attempt: using a lambda expression
public class SixthAttempt {
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

	}
	
	public static List<Apple> filter(List<Apple> apples,ApplePredicate applePredicate) {
		List<Apple> result = new ArrayList<Apple>();
		for(Apple apple: apples) {
			if(applePredicate.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}

}
