package com.utk.service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

import com.utk.model.Shop;

public interface ShopService {

	String productName = "My Favorite Product";

	List<Shop> shops = Arrays.asList(new Shop("BestPrice", productName), new Shop("LetsSaveBig", productName),
			new Shop("MyFavoriteShop", productName), new Shop("BuyItAll", productName));

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

	public static long getTimeDuration(long start) {
		return (System.nanoTime() - start) / 1000000;
	}

	public static List<String> findPrices(String product){
		//Normal stream takes just over four sec to execute as the call is sequential
		return shops.stream()
				.map(shop-> {
					try {
						return String.format("%s price is %.2f", shop.getName(),(double)getPriceAsync(product).get());
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (ExecutionException e) {
						e.printStackTrace();
					}
					return null;
				})
				.collect(toList());
	}

}
