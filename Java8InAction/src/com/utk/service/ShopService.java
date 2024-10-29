package com.utk.service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

import com.utk.model.Shop;

public interface ShopService {

	String productName = "My Favorite Product";

	List<Shop> shops = Arrays.asList(new Shop("BestPrice", productName), new Shop("LetsSaveBig", productName),
			new Shop("MyFavoriteShop", productName), new Shop("BuyItAll", productName),new Shop("TakeItAll", productName));

	final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), new ThreadFactory() {

		@Override
		public Thread newThread(Runnable r) {
			Thread t = new Thread(r);
			t.setDaemon(true);
			return t;
		}
	});

	public static void delay() {
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static double calculatePrice(String product) {
		delay();
		return Math.random() * product.charAt(0) + product.charAt(1);
	}

	public static Future<Double> getPriceAsync(String product) {
		CompletableFuture<Double> futurePrice = new CompletableFuture<Double>();
		new Thread(() -> {
			double price = calculatePrice(product);
			futurePrice.complete(price);
		}).start();
		return futurePrice;
	}

	public static double getPrice(String product) {
		double price = calculatePrice(product);
		return price;
	}

	public static long getTimeDuration(long start) {
		return (System.nanoTime() - start) / 1000000;
	}

	public static List<String> findPrices(String product) {
		// Normal stream takes just over four sec to execute as the call is sequential
		// trying with parallel stream may shorten the time and reduce it to just over 1
		// sec
		return shops.parallelStream().map(shop -> {
			try {
				return String.format("%s price is %.2f", shop.getName(), (double) getPriceAsync(product).get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
			return null;
		}).collect(toList());
	}

	// method using completable future interface to achieve the same result
	public static List<String> findPricesUsingCompletableFuture(String product) {
		List<CompletableFuture<String>> futurePrices = shops
				.stream().map(shop -> CompletableFuture
						.supplyAsync(() -> shop.getName() + " price is " + getPrice(product), executor))
				.collect(Collectors.toList());
		return futurePrices.stream().map(CompletableFuture::join).collect(toList());
	}

}
