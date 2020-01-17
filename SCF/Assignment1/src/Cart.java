import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Priyansh Cart item stores Item to its quantity map using HashMap
 */
public class Cart {
	private Map<Item, Integer> mapOfItems;
	private double totalPrice;

	/**
	 * Constructor
	 */
	public Cart() {
		mapOfItems = new HashMap<>();
		totalPrice = 0;
	}

	/**
	 * Method to add an item
	 * 
	 * @param item
	 */
	public void addItem(Item item) {
		if (mapOfItems.containsKey(item)) {
			mapOfItems.put(item, new Integer(mapOfItems.get(item) + 1));
		} else {
			mapOfItems.put(item, new Integer(1));
		}
		totalPrice += item.price;
	}

	/**
	 * Method to update quantity of an item
	 * 
	 * @param item
	 * @param updateQuantity
	 */
	public void updateQuantity(Item item, int updateQuantity) {
		Integer quantity = mapOfItems.get(item);
		if (quantity != null) {
			if (quantity + updateQuantity >= 0) {
				mapOfItems.put(item, quantity + updateQuantity);
				totalPrice += updateQuantity * item.price;
				if (mapOfItems.get(item) == 0) {
					mapOfItems.remove(item);
				}
			} else {
				totalPrice -= quantity * item.price;
				mapOfItems.remove(item);
			}
		} else if (updateQuantity > 0) {
			mapOfItems.put(item, updateQuantity);
			totalPrice += updateQuantity * item.price;
		}
	}

	/**
	 * Removes an item from the cart if present
	 * 
	 * @param item
	 */
	public void removeItem(Item item) {
		Integer quantity = mapOfItems.get(item);
		if (quantity != null) {
			totalPrice -= quantity * item.price;
			mapOfItems.remove(item);
		}
	}

	/**
	 * Method to get total price of the cart
	 * 
	 * @return
	 */
	public double getPrice() {
		return totalPrice;
	}

	/**
	 * Prints details of the cart
	 */
	public void showDetails() {
		for (Map.Entry<Item, Integer> itemQuantityPair : mapOfItems.entrySet()) {
			Item item = (Item) itemQuantityPair.getKey();
			Integer quantity = (Integer) itemQuantityPair.getValue();
			item.showDetails();
			System.out.println("\tQuantity: " + quantity);
		}
	}

}