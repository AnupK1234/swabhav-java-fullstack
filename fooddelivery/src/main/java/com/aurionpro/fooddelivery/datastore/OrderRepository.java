package com.aurionpro.fooddelivery.datastore;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.aurionpro.fooddelivery.model.Order;

public class OrderRepository {
	private static final String FILE_NAME = "orderhistory.ser";

	public static List<Order> loadOrderHistory() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
			return (List<Order>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			return new ArrayList<Order>();
		}
	}

	public static void saveOrderHistory(List<Order> order) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
			oos.writeObject(order);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
