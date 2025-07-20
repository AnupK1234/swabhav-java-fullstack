package com.aurionpro.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q3 {

	public static void main(String[] args) {
		List<Employee> staff = new ArrayList<>();
		Map<String, Double> deptMap = new HashMap<>();
		Employee e1 = new Employee("Anup", "IT", 10000);
		Employee e2 = new Employee("Alice", "HR", 20000);
		Employee e3 = new Employee("Bob", "Finance", 30000);
		Employee e4 = new Employee("John", "Liciening", 40000);
		Employee e5 = new Employee("Roy", "HR", 40000);

		staff.add(e1);
		staff.add(e2);
		staff.add(e3);
		staff.add(e4);
		staff.add(e5);
		
		
		

	}

}
