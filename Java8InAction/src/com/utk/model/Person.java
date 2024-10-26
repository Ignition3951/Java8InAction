package com.utk.model;

import java.util.Optional;

public class Person {

	//To clarify the code means that a person may or may not have a car
	private Optional<Car> car;

	public Optional<Car> getCar() {
		return car;
	}

	public void setCar(Optional<Car> car) {
		this.car = car;
	}

}
