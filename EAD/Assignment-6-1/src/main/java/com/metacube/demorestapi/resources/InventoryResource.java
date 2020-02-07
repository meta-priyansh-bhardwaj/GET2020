package com.metacube.demorestapi.resources;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.metacube.demorestapi.pojo.Inventory;
import com.metacube.demorestapi.repositories.InventoryRepository;

@Path("inventory")
public class InventoryResource {

	private InventoryRepository repo = new InventoryRepository();
	
	/**
	 * Function to get all inventories
	 * @return list of inventories
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Inventory> getInventories() {
		System.out.println("getInventories called.");
		
		return repo.getInventories();
	}	
	
	/**
	 * Function to post an inventory to the list
	 * @param inv the inventory to be added
	 * @return inventory that has been added
	 */
	@POST
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Inventory create(Inventory inv) {
		System.out.println("inventory called.");
		return repo.addInventory(inv);
	}
	
	/**
	 * Function to delete all inventories
	 * @return inventories after deletion
	 */
	@DELETE
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Inventory> deleteInventories() {
		return repo.deleteInventories();
	}
	
	/**
	 * Function to get an inventory by name
	 * @param inventoryName the name of inventory
	 * @return the inventory if exists
	 */
	@GET
	@Path("{inventoryName}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Inventory GetInventory(@PathParam("inventoryName") String inventoryName){
		System.out.println(inventoryName);
		return repo.getInventory(inventoryName);
		
	}
	
	/**
	 * Function to delete an inventory by name if it exists
	 * @param inventoryName the name of the inventory
	 * @return the inventory that has been deleted
	 */
	@DELETE
	@Path("{inventoryName}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Inventory deleteInventory(@PathParam("inventoryName") String inventoryName){
		System.out.println(inventoryName);
		return repo.deleteInventory(inventoryName);
		
	}
	
	/**
	 * Function to update an inventory by name
	 * @param inventoryName the name of the inventory
	 * @param inv the data required for update
	 * @return the inventory after update
	 */
	@PUT
	@Path("{inventoryName}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Inventory updateInventory(@PathParam("inventoryName") String inventoryName, Inventory inv) {
		return repo.updateInventory(inventoryName, inv);
	}
	
	/**
	 * Function to update the repository of inventories
	 * @param inventories the new list of inventories
	 * @return the new inventories
	 */
	@PUT
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Inventory> updateInventories(List<Inventory> inventories) {
		return repo.updateInventories(inventories);
	}
	
}
