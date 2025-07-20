package com.aurionpro.fooddelivery.test;

import java.util.Scanner;

import com.aurionpro.fooddelivery.service.AdminService;

public class FoodDeliveryMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Sasta Zomato! We don't charge processing fees ;) 😉");
		System.out.print("Login as (admin/user): ");
		String role = sc.nextLine();

		switch (role.toLowerCase()) {
		case "admin" -> {
			AdminService admin = new AdminService();
			admin.displayMenu();
		}
		case "user" -> {
//			CustomerService customer = new CustomerService();
//			customer.displayMenu();
		}
		default -> System.out.println("Invalid role.");
		}
	}

}
