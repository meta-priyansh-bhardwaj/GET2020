package model;

import java.util.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *	Class To implement a cart that stores products 
 *
 */
@XmlRootElement
public class Cart {
	private Map<Product, Integer> products;
	private double bill;
	
	/**
	 * Default constructor to initialize products and bill
	 */
	public Cart(){
		 this.products = new HashMap<Product, Integer>();
		 this.bill = 0.0;
	}

	/**
	 * It returns a map of products to its quantity
	 * @return products
	 */
	public Map<Product, Integer> getProducts() {
		return products;
	}
	
	/**
	 * Sets quantity of a product
	 * @param product should not be null
	 * @param quantity should be non-negative
	 */
	public void setQuantity(Product product, int quantity){
		if (product != null) {
			if(quantity < 0) {
				quantity = 0;
			}
			Integer oldQuantity = this.products.get(product);
			if(oldQuantity==null){
				oldQuantity = 0;
			}
			this.bill += (quantity-oldQuantity)*product.getPrice();
			if(quantity>0){
				this.products.put(product, quantity);
			} else {
				this.products.remove(product);
			}
		} else {
			throw new NullPointerException("null product is not accepted");
		}
	}
	
	/**
	 * FUnction to add quantity to product
	 * @param product should not be null
	 * @param quantity should be positive
	 * @throws Exception if product is null
	 */
	public void addProduct(Product product, int quantity) throws Exception{
		if(product==null){
			throw new NullPointerException("null product is not accepted");
		}
		Integer oldQuantity = this.products.get(product);
		if(oldQuantity == null){
			oldQuantity = 0;
		}
		this.bill += product.getPrice()*quantity;
		this.products.put(product, oldQuantity+quantity);
	}
	
	/**
	 * Function to delete some quantity of product
	 * @param product should not be null
	 * @param quantity should be positive
	 * @throws Exception if product is null
	 */
	public void deleteProduct(Product product, int quantity) throws Exception{
		if(product==null){
			throw new NullPointerException("null product is not accepted");
		}
		Integer oldQuantity = this.products.get(product);
		if(oldQuantity == null){
			this.products.put(product,0);
			oldQuantity = 0;
		}
		if(oldQuantity-quantity > 0){
			this.products.put(product, oldQuantity-quantity);
			this.bill -= product.getPrice()*quantity;
		} else {
			this.products.remove(product);
			this.bill -= product.getPrice()*oldQuantity;
		}		
	}
	
	/**
	 * Function to get bill of cart
	 * @return bill	
	 */
	public double getBill() {
		return bill;
	}
}