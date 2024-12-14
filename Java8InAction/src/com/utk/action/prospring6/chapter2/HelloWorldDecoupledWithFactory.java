package com.utk.action.prospring6.chapter2;

import com.utk.action.prospring6.chapter2.decoupled.MessageProvider;
import com.utk.action.prospring6.chapter2.decoupled.MessageRenderer;
import com.utk.action.prospring6.chapter2.decoupled.MessageSupportFactory;

public class HelloWorldDecoupledWithFactory {

	public static void main(String[] args) {
		MessageRenderer mr = MessageSupportFactory.getInstance().getMessageRenderer()
				.orElseThrow(() -> new IllegalArgumentException("No value find in properties file for renderer class!!!!!!"));
		MessageProvider mp = MessageSupportFactory.getInstance().getMessageProvider()
				.orElseThrow(() -> new IllegalArgumentException("No value find in properties file for provider class!!!!!!"));
		mr.setMessageProvider(mp);
		mr.render();

	}

}
