package com.utk.model;

import com.utk.model.Discount.Code;

public class Quote {

	private final String shopName;
	private final double price;
	private final Discount.Code code;

	public Quote(String shopName, double price, Code code) {
		this.shopName = shopName;
		this.price = price;
		this.code = code;
	}

	public static Quote parse(String s) {
		String[] split = s.split(":");
		String shopName = split[0];
		double price = Double.parseDouble(split[1]);
		Discount.Code discountCode = Discount.Code.valueOf(split[2]);
		return new Quote(shopName, price, discountCode);
	}

	public String getShopName() {
		return shopName;
	}

	public double getPrice() {
		return price;
	}

	public Discount.Code getCode() {
		return code;
	}

}
