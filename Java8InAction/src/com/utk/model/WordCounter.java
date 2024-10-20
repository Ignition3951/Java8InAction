package com.utk.model;

public class WordCounter {

	private final int counter;
	private final boolean lastChar;

	public WordCounter(int counter, boolean lastChar) {
		this.counter = counter;
		this.lastChar = lastChar;
	}

	public WordCounter accumulate(Character alphabet) {
		if (Character.isWhitespace(alphabet)) {
			return lastChar ? this : new WordCounter(counter, true);
		} else {
			return lastChar ? new WordCounter(counter + 1, false) : this;
		}
	}

	public WordCounter combine(WordCounter wordCounter) {
		return new WordCounter(counter + wordCounter.counter, wordCounter.lastChar);
	}

	public int getCounter() {
		return this.counter;
	}

}
