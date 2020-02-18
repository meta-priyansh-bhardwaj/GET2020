package controller;

import model.*;
import dao.Stock;

import java.util.*;

import javax.json.JsonObject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;

/**
 *	Class to implement Shopping Cart Controller
 *	that provides end-points for REST-API 
 *
 */
@Path("/shopping-cart/")
public class ShoppingCartController {
	private static Cart cart = new Cart();
	
	/**
	 * Function the contents of the cart as a Map of Products to its Quantity
	 * @return contents of cart
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Map<Product, Integer> getCart() {
		return cart.getProducts();
	}
	
	/**
	 * Function the stock as a Map of name to Products
	 * @return stock
	 */
	@GET
	@Path("/stock")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Map<String, Product> getStock() {
		return Stock.getStock();
	}
	
	/**
	 * Function to add a product to the cart
	 * @param json contains name and quantity of product to add
	 * name should be present in stock
	 * @return the cart
	 */
	@POST
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Map<Product,Integer> addProduct(JsonObject json){
		String name = json.getString("name");
		int quantity = json.getInt("quantity");
		try {
			cart.addProduct(Stock.getProduct(name), quantity);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return cart.getProducts();
	}
	
	/**
	 * Function to generate bill
	 * @return bill
	 */
	@GET
	@Path("/bill")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public double getBill() {
		return cart.getBill();
	}
	
	/**
	 * Function to delete some quantity of a product from cart
	 * @param name should be present in stock
	 * @param json contains quantity to delete and should be positive
	 * @return the cart
	 */
	@DELETE
	@Path("/{product-name}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Map<Product,Integer> deleteProduct(@PathParam("product-name") String name, JsonObject json){
		int quantity = json.getInt("quantity");
		try{
			cart.deleteProduct(Stock.getProduct(name), quantity);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return cart.getProducts();
	}
	
	/**
	 * Function to set quantity of a product
	 * @param name should be present in stock
	 * @param json contains new quantity of product
	 * @return the cart
	 */
	@PUT
	@Path("/{product-name}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Map<Product,Integer> setQuantity(@PathParam("product-name") String name, JsonObject json) {
		int quantity = json.getInt("quantity");
		cart.setQuantity(Stock.getProduct(name), quantity);
		return cart.getProducts();
	}
}
