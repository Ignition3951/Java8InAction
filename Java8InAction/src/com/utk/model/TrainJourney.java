package com.utk.model;

public class TrainJourney {

	public int price;
	public TrainJourney onward;

	public TrainJourney(int price, TrainJourney onward) {
		this.price = price;
		this.onward = onward;
	}

//	@Override
//	public String toString() {
//		return "TrainJourney [price=" + price + ", onward=" + onward + "]";
//	}

}
