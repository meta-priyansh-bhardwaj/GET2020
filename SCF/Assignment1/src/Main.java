import java.util.*;

class Item {
	String name;
	float price;
	
	public Item(String name, float price){
		this.name=name;
		this.price=price;
	}
	
	public void showDetails(){
		System.out.print("Name: "+name+"\tPrice: "+price);
	}
}

class Cart {
	private Map<Item,Integer> list;
	private float totalPrice;
	
	public Cart(){
		list = new HashMap<>();
		totalPrice=0;
	}
	
	public void addItem(Item item){
		if(list.containsKey(item)){
			list.put(item, new Integer(list.get(item)+1));
		}else{
			list.put(item, new Integer(1));
		}
		totalPrice += item.price;
	}
	
	public void updateQuantity(Item item, int quantity){
		if(list.containsKey(item)){
			if(list.get(item)+quantity>=0){
				list.put(item, list.get(item)+quantity);
				totalPrice += quantity*item.price;
				if(list.get(item)==0){
					list.remove(item);
				}
			}
		}
		else if(quantity>0){
			list.put(item, quantity);
			totalPrice += quantity*item.price;
		}
	}
	
	public void removeItem(Item item){
		if(list.containsKey(item) && list.get(item)!=0){
			list.put(item, list.get(item)-1);
			totalPrice -= item.price;
			if(list.get(item)==0) list.remove(item);
		}
	}
	
	public float getPrice(){
		return totalPrice;
	}
	
	public void showDetails(){
		for(Map.Entry element: list.entrySet()){
			Item item = (Item)element.getKey();
			Integer quantity = (Integer)element.getValue();
			item.showDetails();
			System.out.println("\tQuantity: "+quantity);
		}
	}
	
}

public class Main {
	public static void main(String args[]){
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
		c.updateQuantity(stock.get("Novel"),3);
		
		c.showDetails();
		
		System.out.println("Total Price: "+c.getPrice());
	}
}
