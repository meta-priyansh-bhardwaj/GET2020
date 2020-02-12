package com.metacube.shoppingcart.dao;

import java.util.Map;

import com.metacube.shoppingcart.model.Cart;
import com.metacube.shoppingcart.model.Product;
import com.metacube.shoppingcart.model.User;

/**
 * Implements Cart Operation Interface
 *
 */
public class CartOperationsImpl implements CartOperations
{

	private static CartOperationsImpl c = new CartOperationsImpl();

	/**
	 * @return instance
	 * Returns singleton instance of class
	 */
	public static CartOperationsImpl getInstance()
	{
		return c;
	}

	/**
	 * @param productName
	 * @param quantity
	 * Adds Product to Cart
	 */
	@Override
	public void addProduct(String productName, int quantity)
	{

		try
		{
			if (productName != null && quantity > 0)
			{
				Product product = GetProduct.getProduct(productName);
				Cart.getInstance().getProducts().put(product, quantity);
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
	 * @param productName
	 * @param quantity
	 * Deletes product from Cart
	 */
	@Override
	public void deleteProduct(String productName, int quantity)
	{
		try
		{
			if (productName != null && quantity > 0)
			{
				Product product = GetProduct.getProduct(productName);
				Map<Product, Integer> products = Cart.getInstance().getProducts();
				if (quantity == 0)
				{
					products.remove(product);
				}
				else
				{
					products.replace(product, quantity);
				}
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
	@Override
	public Map<Product, Integer> showCart()
	{
		return Cart.getInstance().getProducts();
	}

	/**
	 * @return total Bill
	 * Displays Bill
	 */
	@Override
	public double showBill()
	{
		double totalBill = 0;
		Map<Product, Integer> products = Cart.getInstance().getProducts();
		for (Map.Entry<Product, Integer> map : products.entrySet())
		{
			totalBill += map.getKey().getPrice() * map.getValue();
		}

		return totalBill;
	}

	/**
	 * @return user
	 * Displays User of a Cart
	 */
	@Override
	public User showUser()
	{
		return Cart.getInstance().getUser();
	}

	/**
	 * @param user
	 * Adds User
	 */
	@Override
	public void setUser(User user)
	{
		try
		{
			if (user != null)
			{
				Cart.getInstance().setUser(user);
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