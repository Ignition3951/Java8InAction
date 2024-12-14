package com.utk.action.prospring6.chapter2.decoupled;

public interface MessageRenderer {

	void render();

	void setMessageProvider(MessageProvider messageProvider);

	MessageProvider getMessageProvider();
}
