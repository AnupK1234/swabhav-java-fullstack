package com.aurionpro.model;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Q6 {
	public static void main(String[] args) {
		List<Tx> txs = Arrays.asList(new Tx(2023, "Alice", 500), new Tx(2023, "Bob", 300), new Tx(2023, "Alice", 200),
				new Tx(2023, "Charlie", 400), new Tx(2023, "David", 400), new Tx(2024, "Eve", 700),
				new Tx(2024, "Frank", 300), new Tx(2024, "Eve", 100), new Tx(2024, "Grace", 500),
				new Tx(2024, "Bob", 400));

		Map<Object, Object> result = txs.stream().collect(Collectors.groupingBy(tx -> tx.getYear(), // group by year
				Collectors.collectingAndThen(
						Collectors.groupingBy(tx -> tx.getTrader(), Collectors.summingInt(tx -> tx.getValue())),
						traderToValueMap -> traderToValueMap.entrySet().stream()
								.sorted(Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed()
										.thenComparing(Map.Entry::getKey))
								.limit(3).map(Map.Entry::getKey) // onlyy get the name
								.collect(Collectors.toList()))));

		result.forEach((year, topTraders) -> {
			System.out.println(year + " → " + topTraders);
		});
	}
}
