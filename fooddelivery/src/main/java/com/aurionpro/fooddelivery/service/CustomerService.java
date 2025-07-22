package com.aurionpro.fooddelivery.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.aurionpro.fooddelivery.datastore.MenuRepository;
import com.aurionpro.fooddelivery.datastore.OrderRepository;
import com.aurionpro.fooddelivery.enums.PaymentMode;
import com.aurionpro.fooddelivery.exception.MenuItemNotFoundException;
import com.aurionpro.fooddelivery.model.DeliveryPartner;
import com.aurionpro.fooddelivery.model.MenuItem;
import com.aurionpro.fooddelivery.model.Order;
import com.aurionpro.fooddelivery.model.OrderItem;

public class CustomerService {
	private List<MenuItem> items;
	private List<Order> orderHistory;
	private List<OrderItem> cart = new ArrayList<>();

	private Scanner sc = new Scanner(System.in);
	PaymentService pay;

	public CustomerService() {
		this.items = MenuRepository.loadMenuItems();
		this.orderHistory = OrderRepository.loadOrderHistory();
	}

	public void displayMenu() {
		int choice = -1;
		do {
			try {
				System.out.println("\n--- Customer Menu ---");
				System.out.println("1. View Menu");
				System.out.println("2. Add Item to Cart");
				System.out.println("3. View Cart");
				System.out.println("4. Remove Item from Cart");
				System.out.println("5. Place Order");
				System.out.println("6. View order history");
				System.out.println("0. Exit");
				System.out.print("Enter choice: ");
				choice = sc.nextInt();
				sc.nextLine(); // consume newline

				switch (choice) {
				case 1 -> viewAllProducts();
				case 2 -> addItemToCart();
				case 3 -> viewCart();
				case 4 -> removeItemFromCart();
				case 5 -> placeOrder();
				case 6 -> viewOrderHistory();
				case 0 -> System.out.println("Thank you for shopping!");
				default -> System.out.println("Invalid choice.");
				}
			} catch (Exception e) {
				System.out.println("Invalid input. Please enter numbers only.");
				sc.nextLine();
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

	private void viewOrderHistory() {
		if (orderHistory.isEmpty()) {
			System.out.println("No previous order found");
		} else {
			System.out.println(
					"\n------------------------------------------------------------------------------------------");
			System.out.printf("| %-20s | %-10s | %-20s | %-30s |\n", "Order ID", "Amount", "Payment Mode", "Timestamp");
			System.out.println(
					"------------------------------------------------------------------------------------------");

			for (Order order : orderHistory) {
				System.out.printf("| %-20d | %-10.2f | %-20s | %-30s |\n", order.getId(), order.getFinalAmt(),
						order.getPaymentMode(),
						order.getTimestamp().toLocalDate() + " " + order.getTimestamp().toLocalTime());
			}

			System.out.println(
					"------------------------------------------------------------------------------------------");
		}
	}

	private void addItemToCart() {
		try {
			System.out.print("Enter Item ID to add: ");
			long id = sc.nextLong();

			Optional<MenuItem> itemOpt = items.stream().filter(p -> p.getId() == id).findFirst();

			if (itemOpt.isPresent()) {
				System.out.print("Enter quantity: ");
				int qty = sc.nextInt();

				if (qty <= 0) {
					System.out.println("Quantity must be greater than 0.");
					return;
				}

				if (!ifMenuItemInCartIncQty(id, qty)) {
					OrderItem orderItem = new OrderItem(itemOpt.get(), qty);
					cart.add(orderItem);
				}
				System.out.println("Item added to cart.");
			} else {
				throw new MenuItemNotFoundException("Item not present in menu");
			}
		} catch (MenuItemNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (Exception e) {
			System.out.println("Invalid input. Please enter valid item ID and quantity.");
			sc.nextLine(); // clear buffer
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
		try {
			System.out.print("Enter ID to remove: ");
			long id = sc.nextLong();
			sc.nextLine();

			boolean removed = cart.removeIf(item -> item.getItem().getId() == id);
			System.out.println(removed ? "Item removed." : "Item not found in cart.");
		} catch (Exception e) {
			System.out.println("Invalid input. Please enter a valid ID.");
			sc.nextLine();
		}
	}

	private void placeOrder() {
		if (cart.isEmpty()) {
			System.out.println("Cart is empty. Add items before placing order.");
			return;
		}

		System.out.print("Enter your delivery address: ");
		String deliveryAdd = sc.nextLine().trim();

		if (deliveryAdd.isEmpty()) {
			System.out.println("Delivery address cannot be empty.");
			return;
		}

		System.out.println("Choose Payment Mode: 1. UPI  2. Cash");
		int paymentChoice;
		try {
			paymentChoice = sc.nextInt();
		} catch (Exception e) {
			System.out.println("Invalid input for payment mode.");
			sc.nextLine();
			return;
		}

		Order order;
		if (paymentChoice == 1) {
			order = new Order(cart, PaymentMode.UPI, deliveryAdd);
			pay = new PaymentService();
			pay.processPayment(order);
		} else if (paymentChoice == 2) {
			order = new Order(cart, PaymentMode.CASH, deliveryAdd);
			System.out.println("Payment mode selected: CASH. Please pay at your door step.");
		} else {
			System.out.println("Invalid payment choice.");
			return;
		}

		// print invoice
		InvoicePrinter.printInvoice(order);

		// assign delivery partner
		DeliveryPartner partner = DeliveryService.assignPartner();
		order.setDeliveryPartner(partner);
		orderHistory.add(order);
		OrderRepository.saveOrderHistory(orderHistory);

		// Clear cart
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
