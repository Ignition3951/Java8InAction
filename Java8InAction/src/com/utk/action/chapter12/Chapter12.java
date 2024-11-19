package com.utk.action.chapter12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

import com.utk.model.NextWorkingDay;

public class Chapter12 {

	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2024, 11, 01);
		date = date.with(new NextWorkingDay());
		System.out.println(date);
		
		LocalDate today = LocalDate.now();
		LocalDate firstSaturdayOfMonth = today.with(TemporalAdjusters.firstInMonth(DayOfWeek.TUESDAY));
		LocalDate thirdSaturdayOfMonth = firstSaturdayOfMonth.plusDays(14);
		System.out.println(firstSaturdayOfMonth+"    "+thirdSaturdayOfMonth);
		if(today.equals(firstSaturdayOfMonth) || today.equals(thirdSaturdayOfMonth)) {
			System.out.println("True");
		}
	}

}
