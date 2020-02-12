package com.metacube.shoppingcart.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Cart class Represents cart operations
 *
 */
public class Cart
{
	private Map<Product, Integer> products = new HashMap<Product, Integer>();
	private User user = new User();
	private static Cart cart = new Cart();

	/**
	 * @return the instance of cart
	 */
	public static Cart getInstance()
	{
		return cart;
	}

	/**
	 * @param products
	 * method to set products
	 */
	public void setProducts(Map<Product, Integer> products)
	{
		try
		{
			if (products != null)
			{
				this.products = products;
			}
			else
			{
				throw new NullPointerException("null products map is not accepted");
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

	/**
	 * @param user
	 * method to set user
	 */
	public void setUser(User user)
	{
		try
		{
			if (user != null)
			{
				this.user = user;
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

	/**
	 * @return products map
	 */
	public Map<Product, Integer> getProducts()
	{
		return products;
	}

	/**
	 * @return user
	 */
	public User getUser()
	{
		return user;
	}
}