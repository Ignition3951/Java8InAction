package com.utk.action.prospring6.chapter2.decoupled;

public class HelloWorldMessageProvider implements MessageProvider {

	@Override
	public String getMessage() {
		return "Hello World!!!!!!!!!";
	}

}
