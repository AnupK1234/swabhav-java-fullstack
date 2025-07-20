package com.aurionpro.fooddelivery.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.aurionpro.fooddelivery.datastore.MenuRepository;
import com.aurionpro.fooddelivery.exception.MenuItemNotFoundException;
import com.aurionpro.fooddelivery.model.MenuItem;
import com.aurionpro.fooddelivery.model.OrderItem;

public class CustomerService {
	private List<MenuItem> items;
	private List<OrderItem> cart = new ArrayList<>();
	private Scanner sc = new Scanner(System.in);

	public CustomerService() {
		this.items = MenuRepository.loadMenuItems();
	}

	public void displayMenu() {
		int choice;
		do {
			System.out.println("\n--- Customer Menu ---");
			System.out.println("1. View Menu");
			System.out.println("2. Add Item to Cart");
			System.out.println("3. View Cart");
			System.out.println("4. Remove Item from Cart");
			System.out.println("5. Place Order");
			System.out.println("0. Exit");
			System.out.print("Enter choice: ");
			choice = sc.nextInt();

			try {
				switch (choice) {
				case 1 -> viewAllProducts();
				case 2 -> addItemToCart();
				case 3 -> viewCart();
				case 4 -> removeItemFromCart();
//			case 5 -> placeOrder();
				case 0 -> System.out.println("Thank you for shopping!");
				default -> System.out.println("Invalid choice.");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} while (choice != 0);
	}

	private void viewAllProducts() {
		if (items.isEmpty()) {
			System.out.println("No items found.");
		} else {
			System.out.println("\n-----------------------------------------------------------");
			System.out.printf("| %-20s | %-20s | %-10s |\n", "ID", "Name", "Price");
			System.out.println("-----------------------------------------------------------");

			for (MenuItem item : items) {
				System.out.printf("| %-20d | %-20s | %-10.2f |\n", item.getId(), item.getName(), item.getPrice());
			}

			System.out.println("-----------------------------------------------------------");
		}
	}

	private void addItemToCart() {
		System.out.print("Enter Item ID to add: ");
		long id = sc.nextLong();

		Optional<MenuItem> itemOpt = items.stream().filter(p -> p.getId() == id).findFirst();

		if (itemOpt.isPresent()) {
			System.out.print("Enter quantity: ");
			int qty = sc.nextInt();

			// first check if the item is present in cart
			// if present then just increase the qty cnt else add new item to cart

			if (!ifMenuItemInCartIncQty(id, qty)) {
				OrderItem orderItem = new OrderItem(itemOpt.get(), qty);
				cart.add(orderItem);
			}
			System.out.println("Item added to cart.");
		} else {
			throw new MenuItemNotFoundException("Item not present in menu");
		}
	}

	private void viewCart() {
		int cartValue = 0;
		if (cart.isEmpty()) {
			System.out.println("No items found in cart.");
		} else {
			System.out.println("\n------------------------------------------------------------------------");
			System.out.printf("| %-20s | %-20s | %-10s | %-10s |\n", "Item ID", "Name", "Quantity", "Price/unit");
			System.out.println("------------------------------------------------------------------------");

			for (OrderItem item : cart) {
				MenuItem mItem = item.getItem();
				System.out.printf("| %-20d | %-20s | %-10s | %-10.2f |\n", mItem.getId(), mItem.getName(),
						item.getQuantity(), mItem.getPrice());
				cartValue += item.getQuantity() * mItem.getPrice();
			}

			System.out.println("------------------------------------------------------------------------");
			System.out.println("The Cart value is : " + cartValue);
		}
	}

	private void removeItemFromCart() {
		if (cart.isEmpty()) {
			System.out.println("Cart is empty.");
			return;
		}

		System.out.print("Enter ID to remove: ");
		long id = sc.nextLong();

		boolean removed = cart.removeIf(item -> item.getItem().getId() == id);
		if (removed) {
			System.out.println("Item removed.");
		} else {
			System.out.println("Item not found.");
		}
	}

	private void placeOrder() {
		if (cart.isEmpty()) {
			System.out.println("Cart is empty. Add items before placing order.");
			return;
		}

		// create order
		
		// do payment
		
		// print invoice
		
		// assign delivery partner
		
		// Clear the cart after placing the order
		cart.clear();
	}

	public boolean ifMenuItemInCartIncQty(long itemId, int qty) {
		for (OrderItem orderItem : cart) {
			if (orderItem.getItem().getId() == itemId) {
				orderItem.setQuantity(orderItem.getQuantity() + qty);
				return true;
			}
		}
		return false;
	}
}
