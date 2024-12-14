package com.utk.action.prospring6.chapter2;

import com.utk.action.prospring6.chapter2.decoupled.HelloWorldMessageProvider;
import com.utk.action.prospring6.chapter2.decoupled.MessageProvider;
import com.utk.action.prospring6.chapter2.decoupled.MessageRenderer;
import com.utk.action.prospring6.chapter2.decoupled.StandardOutMessageRenderer;

public class HelloWorld {

	public static void main(String[] args) {
		MessageProvider mp = new HelloWorldMessageProvider();
		MessageRenderer mr = new StandardOutMessageRenderer();
		mr.setMessageProvider(mp);
		mr.render();

	}

}
