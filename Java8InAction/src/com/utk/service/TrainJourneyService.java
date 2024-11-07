package com.utk.service;

import com.utk.model.TrainJourney;

public class TrainJourneyService {

	public static TrainJourney link(TrainJourney a, TrainJourney b) {
		if (a == null)
			return b;
		TrainJourney t = a;
		while (t.onward != null) {
			t = t.onward;
		}
		t.onward = b;
		return a;
	}

	public static TrainJourney appendLink(TrainJourney a, TrainJourney b) {
		return a == null ? b : new TrainJourney(a.price, appendLink(a.onward, b));
	}
}
