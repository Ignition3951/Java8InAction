package com.utk.action.prospring6.chapter2.decoupled;

import java.util.Optional;
import java.util.Properties;

public class MessageSupportFactory {

	private static MessageSupportFactory instance;
	private Properties properties;
	private MessageProvider messageProvider;
	private MessageRenderer messageRenderer;

	private MessageSupportFactory() {
		properties = new Properties();
		try {
			properties.load(this.getClass().getResourceAsStream("/msf.properties"));
			String rendererClass = properties.getProperty("renderer.class");
			String providerClass = properties.getProperty("provider.class");
			messageRenderer = (MessageRenderer) Class.forName(rendererClass).getDeclaredConstructor().newInstance();
			messageProvider = (MessageProvider) Class.forName(providerClass).getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static {
		instance = new MessageSupportFactory();
	}

	public static MessageSupportFactory getInstance() {
		return instance;
	}

	public Optional<MessageRenderer> getMessageRenderer() {
		return messageRenderer != null ? Optional.of(messageRenderer) : Optional.empty();
	}

	public Optional<MessageProvider> getMessageProvider() {
		return messageProvider != null ? Optional.of(messageProvider) : Optional.empty();
	}

}
