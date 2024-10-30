package com.utk.model;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class NextWorkingDay implements TemporalAdjuster {

	@Override
	public Temporal adjustInto(Temporal temporal) {
		DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
		int daysToAdd = 1;
		if (dow == DayOfWeek.FRIDAY)
			daysToAdd = 3;
		else if (dow == DayOfWeek.SATURDAY)
			daysToAdd = 2;
		return temporal.plus(daysToAdd, ChronoUnit.DAYS);
	}

}
