package com.utk.action.prospring6.chapter2.decoupled;

public class StandardOutMessageRenderer implements MessageRenderer {

	private MessageProvider messageProvider;

	public StandardOutMessageRenderer() {
		System.out.println("Constructor of StandardOutMessageRenderer is called!!!!!!!!!!!!!");
	}

	@Override
	public void render() {
		if (messageProvider == null) {
			throw new RuntimeException("You must set the property of message provider class!!!!!!"
					+ StandardOutMessageRenderer.class.getName());
		}
		System.out.println(messageProvider.getMessage());

	}

	@Override
	public void setMessageProvider(MessageProvider messageProvider) {
		System.out.println("setMessageProvider has been called!!!!!!!!");
		this.messageProvider = messageProvider;

	}

	@Override
	public MessageProvider getMessageProvider() {
		return this.messageProvider;
	}

}
