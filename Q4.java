package com.aurionpro.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q4 {

	public static void main(String[] args) {
		List<List<String>> nested = new ArrayList<>();
		nested.add(Arrays.asList("Anup", "Alice"));
		nested.add(Arrays.asList("", "John", "Bob"));
		nested.add(Arrays.asList(null, "Mark"));
		// nested.add(Arrays.asList(null));

		List<String> flattenedList = nested.stream().flatMap(List::stream)
				.filter(str -> str != null && !str.trim().isEmpty()).sorted().collect(Collectors.toList());

		System.out.println("The flattened list is : " + flattenedList);
	}

}
