package com.utk.model;

import java.util.Optional;

public class Car {

	//A car may or may not have an insurance
	private Optional<Insurance> insurance;

	public Optional<Insurance> getInsurance() {
		return insurance;
	}

	public void setInsurance(Optional<Insurance> insurance) {
		this.insurance = insurance;
	}

}
