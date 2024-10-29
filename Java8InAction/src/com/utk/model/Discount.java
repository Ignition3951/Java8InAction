package com.utk.model;

import com.utk.service.ShopService;

public class Discount {

	public enum Code {
		NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);

		private int percentage;

		Code(int percentage) {
			this.percentage = percentage;
		}
	}

	public static String applyDiscount(Quote quote) {
		return quote.getShopName() + " price is " + apply(quote.getPrice(), quote.getCode());
	}

	public static double apply(double price, Code code) {
		ShopService.delay();
		return price * (100 - code.percentage) / 100;
	}

}
