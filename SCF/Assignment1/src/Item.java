/**
 * Item class that stores id, name and price of the item
 * 
 * @author Priyansh
 *
 */
public class Item {

	public final int id;
	public String name;
	public double price;

	// keeps track of total number of items
	private static int totalItems = 0;

	/**
	 * Contructor for item
	 * 
	 * @param name
	 * @param price
	 */
	public Item(String name, double price) {
		this.id = Item.totalItems;
		this.name = name;
		this.price = price;
		Item.totalItems++;
	}

	/**
	 * Prints details of the item
	 */
	public void showDetails() {
		System.out.print("Name: " + name + "\tPrice: " + price);
	}
}