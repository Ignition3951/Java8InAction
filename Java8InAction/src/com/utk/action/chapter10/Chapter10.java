package com.utk.action.chapter10;

import java.util.Optional;

import com.utk.model.Car;
import com.utk.model.Insurance;
import com.utk.model.Person;

public class Chapter10 {

	public static void main(String[] args) {
		// Creating empty object using optional which wont throw null pointer when used
		Optional<Person> dummy = Optional.empty();

		Optional<Person> dummy2 = Optional.ofNullable(null);
		System.out.println(getCarInsuranceName(dummy2));
	}

	// Used flatmap because map will return Optional<Optional<Person>> which wont
	// compile
	public static String getCarInsuranceName(Optional<Person> person) {
		return person.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName).orElse("Unknown");
	}

	// Null safe implementation of findCheapestInsurance
	public static Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Car> car, Optional<Person> person) {

		return person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));

	}

	public static Insurance findCheapestInsurance(Person person, Car car) {
		Insurance insurance = null;
		return insurance;
	}
}
