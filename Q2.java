package com.aurionpro.model;

import java.util.ArrayList;
import java.util.List;

public class Q2 {

	public static void main(String[] args) {
		List<String> words = new ArrayList<>();
		words.add("Java");
		words.add("java");
		words.add("Home");
		words.add("hello");
		words.add("world");
		words.add("home");
		words.add("something");

		long countOfDistictWords = words.stream().map(String::toLowerCase).distinct().count();
		System.out.println("The count of distinct words in the list is " + countOfDistictWords);

	}

}
