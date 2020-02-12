package com.metacube.shoppingcart.dao;

import java.util.Map;
import com.metacube.shoppingcart.model.Product;
import com.metacube.shoppingcart.model.User;

/**
 * CartOperations interface has the methods of Cart Operations
 *
 */
public interface CartOperations
{

	/**
	 * @param productName
	 * @param quantity
	 * Adds Product to Cart
	 */
	public abstract void addProduct(String productName, int quantity);

	/**
	 * @param productName
	 * @param quantity
	 * Deletes product from Cart
	 */
	public void deleteProduct(String productName, int quantity);

	/**
	 * @return Items
	 * Displays Cart
	 */
	public Map<Product, Integer> showCart();

	/**
	 * @return total Bill
	 * Displays Bill
	 */
	public double showBill();

	/**
	 * @param user
	 * Adds User
	 */
	public void setUser(User user);

	/** 
	 * @return user
	 * Displays User of a Cart
	 */
	public User showUser();
}