package com.aurionpro.fooddelivery.datastore;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.aurionpro.fooddelivery.model.MenuItem;

public class MenuRepository {
	private static final String FILE_NAME = "menulist.ser";

	public static List<MenuItem> loadMenuItems() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
			return (List<MenuItem>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			return new ArrayList<MenuItem>();
		}
	}

	public static void saveMenuItems(List<MenuItem> menuItem) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
			oos.writeObject(menuItem);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
