package com.utk.action.chapter9;


/*
 * The most specific interface is B hence the hello() method of B is called
 * in this piece of code
 * 
 * */
public class ClassC implements InterfaceA, InterfaceB {

	public static void main(String[] args) {
		new ClassC().hello();
	}

}
