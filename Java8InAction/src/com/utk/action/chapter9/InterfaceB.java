package com.utk.action.chapter9;

public interface InterfaceB extends InterfaceA {
	
	default void hello() {
		System.out.println("Hello from interface B!!!!!!!!!!!!");
	}

}
