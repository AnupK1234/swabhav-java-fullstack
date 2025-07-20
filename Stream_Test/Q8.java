package com.aurionpro.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q8 {
	public static void main(String[] args) {
		List<String> sentences = Arrays.asList("Hello guys", "Welcome to my youtube channel", "Hello world");

		List<List<String>> wordsPerSentence = sentences.stream().map(sentence -> Arrays.asList(sentence.split("\\s+")))
				.collect(Collectors.toList());

		wordsPerSentence.forEach(System.out::println);
	}
}
