package linkedList;
/**
 * Class to implement a node of a linked list
 *
 */
public class Node {
	private int value;
	private Node next;
	
	/**
	 * Constructor takes integer value as parameter
	 * sets value of the node initially
	 * @param value
	 */
	public Node(int value){
		this.value = value;
		this.next = null;
	}
	
	/**
	 * Function to get the value of the node
	 * @return value
	 */
	public int getValue(){
		return this.value;
	}
	
	/**
	 * Function to get the next node
	 * @return next node
	 */
	public Node getNext(){
		return this.next;
	} 
	
	/**
	 * Function to set next node
	 * @param next
	 */
	public void setNext(Node next){
		this.next = next;
	}
}
