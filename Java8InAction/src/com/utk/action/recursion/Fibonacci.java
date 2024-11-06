package com.utk.action.recursion;

/*
 * if n==0 return 0
 * if n==1 or n==2 return 1
 * f(n) = f(n-1)+f(n-2)
 * */

public class Fibonacci {

	public static void main(String[] args) {
		int fibSeries = 5;
		for (int i = 0; i < fibSeries; i++) {
			System.out.print(fib(i) + " ");
		}
	}

	public static int fib(int n) {
		if (n == 0)
			return 0;
		if (n == 1 || n == 2)
			return 1;
		return fib(n - 1) + fib(n - 2);
	}

}
