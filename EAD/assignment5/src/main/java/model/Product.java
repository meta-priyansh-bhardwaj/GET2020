package model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *	Class to implement a Product 
 *	that has productCode, name, type and price
 */
@XmlRootElement
public class Product {
	private static int numberOfProduct = 0;
	private int productCode;
	private String name;
	private String type;
	private double price;
	
	/**
	 * Constructor to initialize a Product
	 * @param name of the product
	 * @param type of product
	 * @param price of the product
	 */
	public Product(String name, String type, double price){
		this.productCode = ++numberOfProduct;
		this.type = type;
		this.name = name;
		this.price = price;
	}

	/**
	 * @return productCode
	 */
	public int getProductCode(){
		return productCode;
	}
	
	/**
	 * @return name of the product
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * @return price of the product
	 */
	public double getPrice(){
		return price;
	}
	
	/**
	 * @return type of the product
	 */
	public String getType(){
		return type;
	}
	
	/**
	 * Function to set type of the product
	 * @param type
	 * @throws Exception if type is nul
	 */
	public void setType(String type) throws Exception{
		if (type != null) {
			this.type = type;
		} else {
			throw new NullPointerException("null type is not accepted");
		}

	}
	
	/**
	 * Function to set name of the product
	 * @param name
	 * @throws Exception if name is null
	 */
	public void setName(String name) throws Exception{
		if (name != null) {
			this.name = name;
		} else {
			throw new NullPointerException("null name is not accepted");
		}
	}
	
	/**
	 * Function to set price of the product
	 * @param price
	 * @throws Exception if price is 0
	 */
	public void setPrice(double price) throws Exception{
		if (price > 0.0) {
			this.price = price;
		} else {
			throw new Exception("price should be greater than zero");
		}
	}

	/**
	 * Return name of
	 *  the product on sysout
	 */
	@Override
	public String toString() {
		return name;
	}
}
