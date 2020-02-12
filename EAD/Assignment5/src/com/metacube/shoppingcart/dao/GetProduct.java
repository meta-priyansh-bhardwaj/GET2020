package com.metacube.shoppingcart.dao;

import java.util.ArrayList;
import java.util.List;
import com.metacube.shoppingcart.model.Product;

/**
 * class GetProduct has list of products and getter method for getting particular product
 *
 */
public class GetProduct
{

	static List<Product> stock = new ArrayList<Product>();

	/**
	 * @return stock
	 * Adds and Displays Stock
	 */
	public static List<Product> showStock()
	{
		stock.add(new Product(1, "Electronics", "Mobile", 15000));
		stock.add(new Product(1, "Electronics", "Laptop", 55000));
		stock.add(new Product(1, "Clothing", "Pant", 1500));
		stock.add(new Product(1, "Clothing", "Jean", 3500));
		stock.add(new Product(1, "Clothing", "Shirt", 1200));
		return stock;
	}

	/**
	 * @param name
	 * @return product
	 * Returns Product according to name of Product
	 */
	public static Product getProduct(String name)
	{
		try
		{
			if (name != null)
			{
				switch (name)
				{
				case "Mobile":
					return stock.get(0);
				case "Laptop":
					return stock.get(1);
				case "Pant":
					return stock.get(2);
				case "Jean":
					return stock.get(3);
				case "Shirt":
					return stock.get(4);
				default:
					System.out.println("Enter name of product correctly!");
					return null;
				}
			}
			else
			{
				throw new NullPointerException("null name is not accepted");
			}
		}
		catch (NullPointerException e)
		{
			e.getMessage();
		}

		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}