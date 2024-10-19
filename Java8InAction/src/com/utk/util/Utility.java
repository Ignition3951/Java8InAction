package com.utk.util;

import java.util.function.Function;

public class Utility {

	public static long measureSumPerf(Function<Long,Long> adder, Long n) {
		long fastest = Long.MAX_VALUE;
		for (int i = 0; i < 10; i++) {
			long start = System.nanoTime();
			long sum = adder.apply(n);
			long duration = (System.nanoTime() - start) / 1000000;
			System.out.println("Result: " + sum);
			if (duration < fastest)
				fastest = duration;
		}
		return fastest;
	}

}
