package com.utk.service;

import java.util.Comparator;

import com.utk.model.Apple;

public class AppleComparator implements Comparator<Apple> {

	@Override
	public int compare(Apple o1, Apple o2) {
		if(o1.getWeight()>o2.getWeight())
			return 0;
		return -1;
	}

}
