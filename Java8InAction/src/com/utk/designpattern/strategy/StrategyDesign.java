package com.utk.designpattern.strategy;

/**
 * @author UTKARSH
 * You can add any regex match strategy on the string in lambda function
 * i.e the strategy for checking the validations is dependant on your arguments in the lambda function
 */
public class StrategyDesign {

	public static void main(String[] args) {
		
		ValidationContext isNumericValidator= new ValidationContext((String s)-> s.matches("\\d+"));
		boolean isNumeric=isNumericValidator.validate("1274619");
		System.out.println("The result of isNumericValidator is :: "+isNumeric);
		
		ValidationContext isLowerCaseValidator= new ValidationContext((String s)-> s.matches("[a-z]+"));
		boolean isLowerCase=isLowerCaseValidator.validate("asdasd");
		System.out.println("The result of isLowerCaseValidator is :: "+isLowerCase);

	}

}
