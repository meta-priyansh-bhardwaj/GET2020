package dao;

import model.Product;

import java.util.*;

/**
 *	Function to implement stock of the Shop 
 *
 */
public class Stock {
	private static Map<String, Product> stock = new HashMap<String, Product>();
	
	/**
	 * Helper function that fills the stock if found empty
	 */
	private static void fillStock() {
		if(stock.size() != 0){
			return;
		}
		stock.put("Mobile", new Product("Mobile", "Electronics", 8000.0));
		stock.put("Earphones", new Product("Earphones", "Electronics", 1000.0));
		stock.put("Laptop", new Product("Laptop", "Electronics", 70000.0));
		stock.put("Shirt", new Product("Shirt", "Clothes", 400.0));
		stock.put("Shoes", new Product("Shoes", "Footwear", 3000.0));
		stock.put("Slippers", new Product("Slippers", "Footwear", 200.0));
		stock.put("Coke", new Product("Coke", "Baverages", 40.0));
	}
	
	/**
	 * Function to return the stock
	 * @return stock
	 */
	public static Map<String, Product> getStock() {
		fillStock();
		return stock;
	}
	
	/**
	 * Function to return product by its name
	 * @param name of product to find
	 * @return product if found or null otherwise
	 */
	public static Product getProduct(String name){
		fillStock();
		Product product = stock.get(name);
		if(product == null){
			System.out.println("Enter name of product correctly");
		}
		return product;
	}
}