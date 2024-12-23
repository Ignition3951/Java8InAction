package com.utk.service;

import java.util.function.Supplier;

public class LazyList<T> implements MyList<T> {

	final T head;
	final Supplier<MyList<T>> tail;

	public LazyList(T head, Supplier<MyList<T>> tail) {
		this.head = head;
		this.tail = tail;
	}

	@Override
	public T head() {
		return head;
	}

	@Override
	public MyList<T> tail() {
		return tail.get();
	}

	public boolean isEmpty() {
		return false;
	}

}
