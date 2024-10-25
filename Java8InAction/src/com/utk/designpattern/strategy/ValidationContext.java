package com.utk.designpattern.strategy;

/**
 * 
 */
public class ValidationContext {

	private ValidationStrategy validationStrategy;

	public ValidationContext(ValidationStrategy validationStrategy) {
		this.validationStrategy = validationStrategy;
	}

	public boolean validate(String s) {
		return validationStrategy.validate(s);
	}

}
