package com.metacube.shoppingcart.model;

/**
 * Product class Represents Product attributes and is a bean
 *
 */
public class Product
{
	private int productCode;
	private String type;
	private String name;
	private double price;

	/**
	 * @param productCode
	 * @param type
	 * @param name
	 * @param price
	 * Constructor to initialise Product instances
	 */
	public Product(int productCode, String type, String name, double price)
	{
		this.productCode = productCode;
		this.type = type;
		this.name = name;
		this.price = price;
	}

	/**
	 * @return productCode
	 */
	public int getProductCode()
	{
		return productCode;
	}

	/**
	 * @return type
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * @return name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @return price
	 */
	public double getPrice()
	{
		return price;
	}

	/**
	 * @param productCode
	 * method to set productCode
	 */
	public void setProductCode(int productCode)
	{

		try
		{
			if (productCode > 0)
			{
				this.productCode = productCode;
			}
			else
			{
				throw new Exception("productCode should be greater than zero");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	/**
	 * @param type
	 * method to set type
	 */
	public void setType(String type)
	{
		try
		{
			if (type != null)
			{
				this.type = type;
			}
			else
			{
				throw new NullPointerException("null type is not accepted");
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
	 * @param name
	 * method to set name
	 */
	public void setName(String name)
	{
		try
		{
			if (name != null)
			{
				this.name = name;
			}
			else
			{
				throw new NullPointerException("null name is not accepted");
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
	 * @param price
	 * method to set price
	 */
	public void setPrice(double price)
	{

		try
		{
			if (price > 0)
			{
				this.price = price;
			}
			else
			{
				throw new Exception("price should be greater than zero");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}