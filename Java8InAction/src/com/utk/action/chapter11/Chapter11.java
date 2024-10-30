package com.utk.action.chapter11;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import com.utk.service.ShopService;

public class Chapter11 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		Future<Double> futurePrice = ShopService.getPriceAsync("My Favorite Product");
		long invocationTime = ShopService.getTimeDuration(startTime);
		System.out.println("Invocation time returned after :" + invocationTime + " msec!!!");
		// Do some more tasks meanwhile while process is getting executed
		ShopService.delay();
		try {
			double price = futurePrice.get();
			System.out.println("Price is : " + price);
		} catch (Exception e) {
			throw new RuntimeException();
		}
		long retrievalTime = ShopService.getTimeDuration(startTime);
		System.out.println("Price returned after :" + retrievalTime + " msec!!!");

		long startTimeFindPrices = System.nanoTime();
		List<String> output = ShopService.findPricesUsingCompletableFuture("My Favorite Product");
		System.out.println(output.toString());
		long executionTime = ShopService.getTimeDuration(startTimeFindPrices);
		System.out.println("Got done in :" + executionTime + " msec!!!");

		long startTimeFindDiscountedPrices = System.nanoTime();
		List<String> discountedPricesStream = ShopService
				.findDiscountedPricesUsingCompletableFutureAsync("My Favorite Product");
		System.out.println(discountedPricesStream.toString());
		long executionTimeDiscountedPrices = ShopService.getTimeDuration(startTimeFindDiscountedPrices);
		System.out.println("Got done in :" + executionTimeDiscountedPrices + " msec!!!");

		long startTimeForRandomDelay = System.nanoTime();
		CompletableFuture[] futureList = ShopService.findPricesUsingStreams("Iphone16promax")
				.map(f -> f.thenAccept(s -> System.out.println(
						s + " (done in " + ((System.nanoTime() - startTimeForRandomDelay) / 1000000) + " msec)")))
				.toArray(size -> new CompletableFuture[size]);
		CompletableFuture.allOf(futureList).join();
		System.out.println("All shops have now responded in "
				+ ((System.nanoTime() - startTimeForRandomDelay) / 1000000) + " msecs");

	}

}
