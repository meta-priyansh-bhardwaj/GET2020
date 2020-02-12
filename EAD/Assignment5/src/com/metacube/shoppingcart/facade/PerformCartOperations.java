package com.metacube.shoppingcart.facade;

import java.util.List;
import java.util.Map;
import com.metacube.shoppingcart.dao.CartOperationsImpl;
import com.metacube.shoppingcart.dao.GetProduct;
import com.metacube.shoppingcart.model.Product;
import com.metacube.shoppingcart.model.User;

/**
 * Class to Perform Cart Operations
 */
public class PerformCartOperations
{

	/**
	 * @return stock
	 * Displays Stock
	 */
	public static List<Product> showStock()
	{
		return GetProduct.showStock();
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
				CartOperationsImpl.getInstance().addProduct(productName, quantity);
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
	public static void deleteProductFromCart(String productName, int quantity)
	{
		try
		{
			if (productName != null && quantity > 0)
			{
				CartOperationsImpl.getInstance().deleteProduct(productName, quantity);
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
		return CartOperationsImpl.getInstance().showCart();
	}

	/**
	 * @return total Bill
	 * Displays Bill
	 */
	public static double showBill()
	{
		return CartOperationsImpl.getInstance().showBill();
	}

	/**
	 * @return user
	 * Displays User of a Cart
	 */
	public static User showUser()
	{
		return CartOperationsImpl.getInstance().showUser();
	}

	/**
	 * @param user
	 *  Adds User
	 */
	public static void setUser(User user)
	{
		CartOperationsImpl.getInstance().setUser(user);
	}
}