package com.utk.action;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.*;

import com.utk.model.Dish;

public class Chapter6 {

	public static void main(String[] args) {
		List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER), new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH));
		
		Comparator<Dish> dishCaloriesComparator = 
				Comparator.comparingInt(Dish::getCalories);
		
		Optional<Dish> mostCalorieDish=
				menu.stream().collect(maxBy(dishCaloriesComparator));
		
		if(mostCalorieDish.isPresent()) {
			System.out.println("mostCalorieDish : "+mostCalorieDish);
		}
	}

}
