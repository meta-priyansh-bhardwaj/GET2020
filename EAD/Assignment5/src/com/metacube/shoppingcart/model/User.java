
package com.metacube.shoppingcart.model;

/**
 * User class Represents User attributes and is a bean
 *
 */
public class User
{
	private static int userId = 0;
	private String name;

	public User()
	{

	}

	/**
	 * @param name
	 * Constructor to initialise user instances 
	 */
	public User(String name)
	{
		super();
		userId = userId++;
		this.name = name;
	}

	/**
	 * @return userId
	 */
	public int getUserId()
	{
		return userId;
	}

	/**
	 * @return name
	 */
	public String getName()
	{
		return name;
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
}