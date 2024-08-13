package com.utk.service;

import com.utk.model.Apple;

public class ApplePredicateColor implements ApplePredicate {

	@Override
	public boolean test(Apple apple) {
		return "Green".equals(apple.getColor());
	}

}
