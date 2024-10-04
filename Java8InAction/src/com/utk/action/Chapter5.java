package com.utk.action;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.utk.model.Trader;
import com.utk.model.Transaction;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.joining;
import static java.util.Comparator.comparing;

public class Chapter5 {

	public static void main(String[] args) {
		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(4, 5);

		// Create a output {i,j} having mapped both the lists
		List<int[]> mapped12 = numbers1.stream().flatMap(list -> numbers2.stream()// to move inside a list of list
				.map(j -> new int[] { list, j })).collect(toList());

		for (int i = 0; i < mapped12.size(); i++) {
			System.out.println("(" + mapped12.get(i)[0] + "," + mapped12.get(i)[1] + ")");
		}

		// Introduction of reduce function in java8
		Optional<Integer> sum = numbers1.stream().reduce((a, b) -> a + b);
		System.out.println(sum);

		// Problems to solve in chapter 5
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

		// Problem1
		List<Transaction> sortedTransactionsByYear = transactions.stream().filter(d -> d.getYear() == 2011)
				.sorted(comparing(Transaction::getValue))// used comparing static method of Comparator
				// to compare the vales which need to be sorted
				.collect(toList());

		System.out.println(sortedTransactionsByYear.toString());

		// Problem2
		List<String> uniqueCities = transactions.stream().map(d -> d.getTrader().getCity()).distinct()
				.collect(toList());

		System.out.println(uniqueCities.toString());

		// Problem3
		List<Trader> tradersFromCambridgeByName = transactions.stream().map(d -> d.getTrader())
				.filter(d -> d.getCity().equals("Cambridge")).distinct().sorted(comparing(Trader::getName))
				.collect(toList());

		System.out.println(tradersFromCambridgeByName.toString());

		// Problem4
		String sortedStringOfTradersByName = transactions.stream().map(d -> d.getTrader().getName()).distinct().sorted()
				.collect(joining());

		System.out.println("sortedTradersByName : " + sortedStringOfTradersByName.toString());

		// Problem5
		List<Trader> tradersBasedInMilan = transactions.stream().map(d -> d.getTrader())
				.filter(d -> d.getCity().equals("Milan")).distinct().collect(toList());

		System.out.println("tradersBasedInMilan : " + tradersBasedInMilan.toString());

		Boolean areTradersBasedInMilan = transactions.stream()
				.anyMatch(trader -> trader.getTrader().getCity().equals("Milan"));

		System.out.println("areTradersBasedInMilan : " + areTradersBasedInMilan.toString());

		// Problem6

		List<Transaction> transactionsByCity = transactions.stream()
				.filter(city -> city.getTrader().getCity().equals("Cambridge")).collect(toList());

		System.out.println("transactionsByCity : " + transactionsByCity.toString());

		transactions.stream().filter(city -> city.getTrader().getCity().equals("Cambridge"))
				.map(value -> value.getValue()).forEach(System.out::println);

		// Problem7
		Optional<Integer> maxTransactionByPassingValue = transactions.stream().map(value -> value.getValue())
				.reduce((a, b) -> a > b ? a : b);

		if (maxTransactionByPassingValue.isPresent()) {
			System.out.println("reduce maxTransactionByPassingValue : " + maxTransactionByPassingValue.get());
		}

		Optional<Integer> maxTransactionByUsingFunction = transactions.stream().map(value -> value.getValue())
				.reduce(Integer::max);

		if (maxTransactionByUsingFunction.isPresent()) {
			System.out.println("reduce maxTransactionByUsingFunction : " + maxTransactionByUsingFunction.get());
		}

		// Problem8
		Optional<Integer> minTransactionByUsingFunction = transactions.stream().map(value -> value.getValue())
				.reduce(Integer::min);

		if (minTransactionByUsingFunction.isPresent()) {
			System.out.println("reduce minTransactionByUsingFunction : " + minTransactionByUsingFunction.get());
		}

	}

}
