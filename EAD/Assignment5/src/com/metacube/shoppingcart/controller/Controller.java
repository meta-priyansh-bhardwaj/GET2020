package com.metacube.shoppingcart.controller;

import java.util.List;
import java.util.Map;
import com.metacube.shoppingcart.facade.PerformCartOperations;
import com.metacube.shoppingcart.model.Product;
import com.metacube.shoppingcart.model.User;

/**
 * Controller to perform Cart operations
 */
public class Controller
{

	/**
	 * @return stock
	 * Displays Stock
	 */
	public static List<Product> showStock()
	{
		return PerformCartOperations.showStock();
	}

	/**
	 * @param productName
	 * @param quantity
	 *  Adds Product to Cart
	 */
	public static void addProductToCart(String productName, int quantity)
	{

		try
		{
			if (productName != null && quantity > 0)
			{
				PerformCartOperations.addProductToCart(productName, quantity);
			}
			else
			{
				throw new Exception("Inputs are not Invalid");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	/**
	 * Deletes product from Cart
	 * @param productName
	 * @param quantity
	 */
	public static void deleteProductFromCart(String productName, int quantity)
	{
		try
		{
			if (productName != null && quantity > 0)
			{
				PerformCartOperations.deleteProductFromCart(productName, quantity);
			}
			else
			{
				throw new Exception("Inputs are not Invalid");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	/**
	 * @return Cart Items
	 * Displays Cart
	 */
	public static Map<Product, Integer> showCart()
	{
		return PerformCartOperations.showCart();
	}

	/**
	 * @return total Bill
	 * Displays Bill
	 */
	public static double showBill()
	{
		return PerformCartOperations.showBill();
	}

	/**
	 * @return user
	 * Displays User of a Cart
	 */
	public static User showUser()
	{
		return PerformCartOperations.showUser();
	}

	/**
	 * @param user
	 * Adds User 
	 */
	public static void setUser(User user)
	{

		try
		{
			if (user != null)
			{
				PerformCartOperations.setUser(user);
			}
			else
			{
				throw new NullPointerException("null user is not accepted");
			}
		}
		catch (NullPointerException npe)
		{
			npe.getMessage();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}