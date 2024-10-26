package com.utk.action.chapter10;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

import com.utk.model.Car;
import com.utk.model.Insurance;
import com.utk.model.Person;

public class Chapter10 {

	public static void main(String[] args) {
		// Creating empty object using optional which wont throw null pointer when used
		Optional<Person> dummy = Optional.empty();

		Optional<Person> dummy2 = Optional.ofNullable(null);
		System.out.println(getCarInsuranceName(dummy2));
		
		Map<String, String> dummy3 = new HashMap<String, String>();
		dummy3.put("a", "1");
		
		//before using optional
		System.out.println(dummy3.get("b"));
		
		Optional<Object> optionalDummy3= Optional.ofNullable(dummy3.get("b"));
		//After using optional on legacy java API
		System.out.println(optionalDummy3);
		
		Properties props=new Properties();
		props.setProperty("a", "5");
		props.setProperty("b", "true");
		props.setProperty("c", "-23");
		
		System.out.println(readDuration(props,"a"));
		System.out.println(readDuration(props, "b"));
		System.out.println(readDuration(props, "c"));
		
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
	
	//Read only positive values modified with the help of Optional class
	public static int readDuration(Properties props,String name) {
		return Optional.ofNullable(props.getProperty(name))
				.flatMap(Chapter10::stringToInt)
				.filter(i->i>0)
				.orElse(0);
		
	}
	
	//Legacy Integer.parseInt is modified with the help of Optional
	public static Optional<Integer> stringToInt(String s) {
		try {
			return Optional.of(Integer.parseInt(s));
		} catch (NumberFormatException e) {
			return Optional.empty();
		}
	}
}
