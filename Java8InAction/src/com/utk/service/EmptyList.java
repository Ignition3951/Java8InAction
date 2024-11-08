package com.utk.service;

public class EmptyList<T> implements MyList<T> {

	@Override
	public T head() {
		throw new UnsupportedOperationException();
	}

	@Override
	public MyList<T> tail() {
		throw new UnsupportedOperationException();
	}

}
