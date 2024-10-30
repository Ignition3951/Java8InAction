package com.utk.action.chapter12;

import java.time.LocalDate;

import com.utk.model.NextWorkingDay;

public class Chapter12 {

	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2024, 11, 01);
		date = date.with(new NextWorkingDay());
		System.out.println(date);
	}

}
