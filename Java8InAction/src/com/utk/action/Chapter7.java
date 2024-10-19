package com.utk.action;

import java.util.stream.LongStream;
import java.util.stream.Stream;

import com.utk.util.Utility;

public class Chapter7 {

	public static void main(String[] args) {
		
		System.out.println("Sequential sum done in: " +
			    Utility.measureSumPerf(Chapter7::parallelRangedSum, 10000000l) + "msecs");

	}
	
	public static long parallelSum(long n) {
		return Stream.iterate(1L,i->i+1)
				.limit(n)
				.parallel()
				.reduce(0L, Long::sum);
	}
	
	public static Long sequentialSum(long n) {
		return Stream.iterate(1l, i->i+1)
				.limit(n)
				.reduce(0L, Long::sum);
	}
	
	public static long rangedSum(long n) {
		return LongStream.rangeClosed(1, n)
				.reduce(0L, Long::sum);
	}
	
	public static long parallelRangedSum(long n) {
		return LongStream.rangeClosed(1, n)
				.parallel()
				.reduce(0L, Long::sum);
	}

}
