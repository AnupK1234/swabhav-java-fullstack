package com.aurionpro.model;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Q5 {

	public static Optional<Character> firstUnique(String s) {
		return s.codePoints().mapToObj(cp -> (char) cp)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey).findFirst();
	}

	public static void main(String[] args) {
		String input = "swiss";
		Optional<Character> result = firstUnique(input);

		result.ifPresentOrElse(ch -> System.out.println("First non-repeating character: " + ch),
				() -> System.out.println("No unique character found."));
	}
}
