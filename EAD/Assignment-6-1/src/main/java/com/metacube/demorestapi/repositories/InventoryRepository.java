package com.metacube.demorestapi.repositories;

import java.util.ArrayList;
import java.util.List;

import com.metacube.demorestapi.pojo.Inventory;

/**
 *	Class that implements a repository 
 *
 */
public class InventoryRepository {
	private static List<Inventory> inventories;
	
	/**
	 * Contructor for repository that adds items as per requirement
	 */
	public InventoryRepository() {
		if(inventories!=null){
			return;
		}
		inventories = new ArrayList<Inventory>();
		Inventory first = new Inventory();
		first.setName("Apples");
		first.setQuantity(3);
		
		Inventory second = new Inventory();
		second.setName("Oranges");
		second.setQuantity(7);
		
		Inventory third = new Inventory();
		third.setName("Pomegranates");
		third.setQuantity(55);
		inventories.add(first);
		inventories.add(second);
		inventories.add(third);
		
	}
	
	/**
	 * Returns whole repository
	 * @return inventories
	 */
	public List<Inventory> getInventories() {
		return inventories;
	}
	
	/**
	 * To get an inventory
	 * @param name of item
	 * @return inventory
	 */
	public Inventory getInventory(String name) {
		for (Inventory i : inventories) {
			if (i.getName().equals(name)) {
				return i;
			}
		}
		return new Inventory();
	}
	
	/**
	 * Helper function to check if inventory exists
	 * @param inv the inventory
	 * @return index if it exists and -1 otherwise
	 */
	private int isInventoryExist(Inventory inv) {
		int numberOfInventories = inventories.size();
		for (int index = 0; index < numberOfInventories; index++) {
			if (inventories.get(index).getName().equals(inv.getName())) {
				return index;
			}
		}
		return -1;
	}
	
	/**
	 * Function that adds an inventory to the list
	 * @param inv the inventory to add
	 * @return the inventory after addition
	 */
	public Inventory addInventory(Inventory inv) {
		int index = isInventoryExist(inv);
		if (index == -1) {
			inventories.add(inv);
			return inv;
		}
		Inventory currentInventory = inventories.get(index);
		int currentQuantity = currentInventory.getQuantity();
		int newQuantity = inv.getQuantity();
		currentInventory.setQuantity(currentQuantity + newQuantity);
		return currentInventory;
	}
	
	/**
	 * Function to delete all inventories
	 * @return the cleared inventories
	 */
	public List<Inventory> deleteInventories() {
		inventories.clear();
		return inventories;
	}

	/**
	 * Delete an inventory from the list if it exists
	 * @param inventoryName name of the inventory
	 * @return the inventory that has been removed
	 */
	public Inventory deleteInventory(String inventoryName) {
		Inventory inv = new Inventory();
		inv.setName(inventoryName);
		int index = isInventoryExist(inv);
		if (index == -1) {
			System.out.println("InventoryNotFound.");
			return new Inventory();
		}
		inventories.remove(index);
		return inv;
	}
	
	/**
	 * Update an inventory
	 * @param inventoryName name of the inventory
	 * @param inv contains data for update
	 * @return the inventory after update
	 */
	public Inventory updateInventory(String inventoryName, Inventory inv) {
		Inventory tempInventory = new Inventory();
		tempInventory.setName(inventoryName);
		int index = isInventoryExist(tempInventory);
		if (index == -1) {
			return new Inventory();
		}
		inventories.set(index, inv);
		return inventories.get(index);
	}
	
	public List<Inventory> updateInventories(List<Inventory> newInventories) {
		inventories = newInventories;
		return inventories;
	}
}
