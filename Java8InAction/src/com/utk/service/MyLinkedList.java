package com.utk.service;

public class MyLinkedList<T> implements MyList<T> {

	private final T head;
	private final MyList<T> tail;

	public MyLinkedList(T head, MyList<T> tail) {
		this.head = head;
		this.tail = tail;
	}

	@Override
	public T head() {
		return head;
	}

	@Override
	public MyList<T> tail() {
		return tail;
	}

	public boolean isEmpty() {
		return false;
	}

	@Override
	public String toString() {
		return "MyLinkedList [head=" + head + ", tail=" + tail + "]";
	}

}
