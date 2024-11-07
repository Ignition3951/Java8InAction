package com.utk.action.chapter14;

import com.utk.model.TrainJourney;
import com.utk.service.TrainJourneyService;

public class Chapter14 {

	public static void main(String[] args) {

		TrainJourney thirdJourney = new TrainJourney(11, null);// Z
		TrainJourney secondJourney = new TrainJourney(12, thirdJourney);// Y to Z
		TrainJourney firstJourney = new TrainJourney(13, secondJourney);// X to Y
		System.out.println("First journey before:" + firstJourney.onward);
		System.out.println("Second journey before:" + secondJourney.onward);
		System.out.println("Third journey before:" + thirdJourney.onward);

//		TrainJourney linkedJourney = TrainJourneyService.link(firstJourney, thirdJourney);
		TrainJourney linkedJourney = TrainJourneyService.appendLink(firstJourney, thirdJourney);// by using this
																								// technique a new
																								// object is returned
																								// and the already
																								// existing objects are
																								// not modified
																								// destructively

		System.out.println("First journey :" + firstJourney.onward);
		System.out.println("Second journey :" + secondJourney.onward);
		System.out.println("Third journey :" + thirdJourney.onward);// Illustrates that the third object is also
																	// destructively modified by the link method
		System.out.println("linkedJourney journey :" + linkedJourney.onward);

	}

}
