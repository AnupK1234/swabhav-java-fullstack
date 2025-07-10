package com.aurionpro.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Q1 {

	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		nums.add(4);
		nums.add(5);

		List<Integer> calculatedList = nums.stream().filter(n -> n % 2 == 0).map(n -> n * n)
				.collect(Collectors.toList());
		System.out.println("The result list is : " + calculatedList);

	}

}
