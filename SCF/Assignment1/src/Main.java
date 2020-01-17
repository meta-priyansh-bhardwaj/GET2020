import java.util.*;

public class Main {
	public static void main(String args[]) {
		Map<String, Item> stock = new HashMap<>();
		stock.put("Bag", new Item("Bag", 1000));
		stock.put("Bottle", new Item("Bottle", 200));
		stock.put("Shirt", new Item("Shirt", 600));
		stock.put("Jeans", new Item("Jeans", 2000));
		stock.put("Shoes", new Item("Shoes", 5000));
		stock.put("Hoodie", new Item("Hoodie", 10000));
		stock.put("Novel", new Item("Novel", 400));
		stock.put("Watch", new Item("Watch", 3000));

		Cart c = new Cart();
		c.addItem(stock.get("Bag"));
		c.addItem(stock.get("Bottle"));
		c.addItem(stock.get("Shoes"));
		c.updateQuantity(stock.get("Novel"), 3);

		c.showDetails();

		System.out.println("Total Price: " + c.getPrice());
	}
}
