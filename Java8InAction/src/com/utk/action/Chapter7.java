package com.utk.action;

import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import com.utk.model.WordCounter;
import com.utk.util.Utility;

public class Chapter7 {
	
	 static final String SENTENCE =
			 " Nel   mezzo del cammin  di nostra  vita " +
			 "mi  ritrovai in una  selva oscura" +
			 " ché la  dritta via era   smarrita ";

	public static void main(String[] args) {
		
		System.out.println("Sequential sum done in: " +
			    Utility.measureSumPerf(Chapter7::parallelRangedSum, 10000000l) + "msecs");
		
		System.out.println("Words found are :"+countWordsIteratively(SENTENCE));
		
		Stream<Character> stream = IntStream.range(0, SENTENCE.length())
				.mapToObj(SENTENCE::charAt);
		
		System.out.println("Words found through countWords() are :"+countWords(stream));

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
	
	public static int countWordsIteratively(String sentence) {
		int counter=0;
		boolean spaceCharacter=true;
		for(char alphabet: sentence.toCharArray()) {
			if(Character.isWhitespace(alphabet)) {
				spaceCharacter=true;
			}else {
				if(spaceCharacter) counter++;
				spaceCharacter=false;
			}
		}
		return counter;
	}
	
	private static int countWords(Stream<Character> stream) {
		WordCounter wordCounter = stream.reduce(new WordCounter(0, true), 
				WordCounter::accumulate, WordCounter::combine);
		return wordCounter.getCounter();
	}

}
