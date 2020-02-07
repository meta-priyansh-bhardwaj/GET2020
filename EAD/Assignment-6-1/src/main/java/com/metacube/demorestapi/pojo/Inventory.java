package com.metacube.demorestapi.pojo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class to implement an item(fruit)
 * Attributes are name and quantity 
 *
 */
@XmlRootElement
public class Inventory {
	private String name;
	private int quantity;
	
	/**
	 * Function to return name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Function to set name
	 * @param name new name of fruit
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Function to return quantity
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Function to set quantity
	 * @param quantity to set repository
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
