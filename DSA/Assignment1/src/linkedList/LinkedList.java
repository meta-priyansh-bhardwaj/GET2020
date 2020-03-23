package linkedList;
/**
 * Class to implement a linked list
 *
 */
public class LinkedList {
	private Node head;

	/**
	 * Default constructor
	 */
	public LinkedList() { }
	
	/**
	 * Constructor that makes linked list from an array
	 * @param items an array of integers
	 */
	public LinkedList(int[] items){
		if(items == null){
			return;
		}
		for(int item: items){
			this.insertNode(item);
		}
	}
	
	/**
	 * Function to insert a node at end of the linked list takes integer value
	 * as parameter
	 * 
	 * @param value
	 */
	public void insertNode(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
			return;
		}
		Node last = head;
		while (last.getNext() != null) {
			last = last.getNext();
		}
		last.setNext(newNode);
	}

	/**
	 * Function to print the linked list on console
	 */
	public void display() {
		if (head == null) {
			System.out.println("null");
			return;
		}

		for (Node currentNode = head; currentNode != null; currentNode = currentNode
				.getNext()) {
			System.out.print(currentNode.getValue());
			if (currentNode.getNext() != null) {
				System.out.print(" -> ");
			} else {
				System.out.println();
			}
		}
	}

	/**
	 * Function to rotate sublist in clockwise direction by given number of
	 * steps
	 * 
	 * @param leftPosition
	 *            a positive value in range of size of the linked list
	 * @param rightPosition
	 *            a positive value in range of size of the linked list and not
	 *            less than leftPosition
	 * @param steps
	 *            a not-negative integer
	 * @return true if rotated successfully or false otherwise
	 */
	public boolean rotateSubList(int leftPosition, int rightPosition, int steps) {
		if (leftPosition > rightPosition) {
			System.out.println("Invalid values of left and right");
			return false;
		}
		Node leftNode = this.head;
		Node prevOfLeftNode = null;
		for (int i = 1; i <= leftPosition; i++) {
			if (leftNode == null) {
				System.out.println("No node found at position " + leftPosition);
				return false;
			}
			if (i < leftPosition) {
				prevOfLeftNode = leftNode;
				leftNode = leftNode.getNext();
			}
		}

		Node rightNode = leftNode;
		for (int i = leftPosition; i <= rightPosition; i++) {
			if (rightNode == null) {
				System.out.println("No node found at position " + rightPosition);
				return false;
			}
			if (i < rightPosition) {
				rightNode = rightNode.getNext();
			}
		}

		int subListLength = rightPosition - leftPosition + 1;
		steps %= subListLength;
		
		if(steps == 0){
			return true;
		}
		
		Node breakNode = leftNode;
		for (int i = 1; i < steps; i++) {
			breakNode = breakNode.getNext();
		}
		if(prevOfLeftNode != null){
			prevOfLeftNode.setNext(breakNode.getNext());
		} else {
			this.head = breakNode.getNext();
		}
		breakNode.setNext(rightNode.getNext());
		rightNode.setNext(leftNode);
		return true;
	}

	/**
	 * Function to detect loop in the linked list if present
	 * 
	 * @return true if loop is present or false otherwise
	 */
	public boolean detectLoop() {
		if (this.head == null) {
			return false;
		}
		Node slowIterator = this.head;
		Node fastIterator = this.head.getNext();
		while (fastIterator != null) {
			if (slowIterator == fastIterator) {
				return true;
			}
			slowIterator = slowIterator.getNext();
			fastIterator = fastIterator.getNext();
			if (fastIterator == null) {
				break;
			}
			fastIterator = fastIterator.getNext();
		}
		return false;
	}

	/**
	 * Function that connects last node to given position
	 * 
	 * @param position
	 *            a positive value in range of size of the linked list
	 */
	public void createLoop(int position) {
		if (this.head == null) {
			return;
		}
		Node currentNode = null, lastNode = this.head;
		for (int i = 0;; i++, lastNode = lastNode.getNext()) {
			if (i + 1 == position) {
				currentNode = lastNode;
			}
			if (lastNode.getNext() == null) {
				break;
			}
		}
		if (currentNode == null) {
			return;
		}
		lastNode.setNext(currentNode);
	}

	/**
	 * Checks if two linked list are equal
	 * 
	 * @param linkedList
	 * @return true if equal or false otherwise
	 */
	public boolean equals(LinkedList linkedList) {
		if (linkedList == null) {
			return false;
		}
		Node currentNode1 = this.head;
		Node currentNode2 = linkedList.head;
		while (currentNode1 != null && currentNode2 != null) {
			if (currentNode1.getValue() != currentNode2.getValue()) {
				return false;
			}
			currentNode1 = currentNode1.getNext();
			currentNode2 = currentNode2.getNext();
		}
		return currentNode1 == currentNode2;
	}
}
