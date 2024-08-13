package com.utk.service;

import com.utk.model.Apple;

public class ApplePredicateWeight implements ApplePredicate {

	@Override
	public boolean test(Apple apple) {
		return apple.getWeight()>50;
	}

}
