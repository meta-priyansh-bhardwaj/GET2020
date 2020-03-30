package dictionary;

import java.util.List;

/**
 * Class to represent a node of a BST
 *
 */
public class Node {
	private Pair pair;
	private Node parent;
	private Node leftChild;
	private Node rightChild;
	
	/**
	 * Constructor to initialize key-value pair
	 * @param key a non-null string
	 * @param value
	 * @throws Exception if key is null
	 */
	public Node(String key, String value) throws Exception {
		this.pair = new Pair(key, value);
	}
	
	/**
	 * Function to get key
	 * @return key
	 */
	public String getKey() {
		return this.pair.getKey();
	}
	
	/**
	 * Function to get value
	 * @return value
	 */
	public String getValue() {
		return this.pair.getValue();
	}
	
	/**
	 * Function to set value
	 * @param value
	 */
	public void setValue(String value) {
		this.pair.setValue(value);;
	}
	
	/**
	 * Function to get parent
	 * @return parent
	 */
	public Node getParent() {
		return this.parent;
	}
	
	/**
	 * Function to set parent
	 * @param parent
	 */
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	/**
	 * Function to get leftChild
	 * @return leftChild
	 */
	public Node getLeftChild() {
		return this.leftChild;
	}
	
	/**
	 * Function to set leftChild
	 * @param leftChild
	 */
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	/**
	 * Function to get rightChld
	 * @return rightChild
	 */
	public Node getRightChild() {
		return this.rightChild;
	}
	
	/**
	 * Function to set rightChild
	 * @param rightChild
	 */
	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	
	/**
	 * Helper function to replace current node with another
	 * @param node
	 */
	private void replaceChild(Node node) {
		if(node != null) {
			node.setParent(this.parent);
		}
		if(this.parent != null) {
			if(this.parent.getLeftChild() == this) {
				this.parent.setLeftChild(node);
			} else {
				this.parent.setRightChild(node);
			}
		}
	}
	
	/**
	 * Function to get left most or minimum node of the BST
	 * @return leftMost node
	 */
	private Node getLeftMostNode() {
		if(this.leftChild == null) {
			return this;
		}
		return this.leftChild.getLeftMostNode();
	}
	
	/**
	 * Function to add node to the BST
	 * @param node
	 */
	public void addNode(Node node) {
		if(this.getKey().compareTo(node.getKey()) > 0) {
			if(this.getLeftChild() == null) {
				node.setParent(this);
				this.setLeftChild(node);
				return;
			}
			this.getLeftChild().addNode(node);
		} else if(this.getKey().compareTo(node.getKey()) < 0) {
			if(this.getRightChild() == null) {
				node.setParent(this);
				this.setRightChild(node);
				return;
			}
			this.getRightChild().addNode(node);
		} else {
			this.setValue(node.getValue());
		}
	}
	
	/**
	 * Function to delete node from the BST with the reference of key
	 * @param key
	 * @return is a non-null string
	 */
	public boolean deleteNode(String key) {
		Node keyNode = this.searchKey(key);
		if(keyNode == null) {
			return false;
		}
		if(keyNode.leftChild == null) {
			keyNode.replaceChild(keyNode.rightChild);
			return true;
		} else if(this.rightChild == null) {
			keyNode.replaceChild(keyNode.leftChild);
			return true;
		}
		Node successor = keyNode.rightChild.getLeftMostNode();
		keyNode.pair = successor.pair;
		successor.deleteNode(keyNode.getKey());
		return true;
	}
	
	/**
	 * Function to search key in the BST
	 * @param key is a non-null string
	 * @return value if key present or null otherwise
	 */
	public Node searchKey(String key) {
		if(this.getKey().compareTo(key) == 0) {
			return this;
		} else if(this.getKey().compareTo(key) < 0) {
			if(this.rightChild == null) {
				return null;
			}
			return this.rightChild.searchKey(key);
		} else {
			if(this.leftChild == null) {
				return null;
			}
			return this.leftChild.searchKey(key);
		}
	}
	
	/**
	 * Function to traverse BST in Infix order and adds Pairs to the List
	 * @param sortedArray a list to collect all Pairs
	 */
	public void infixTraversal(List<Pair> sortedArray) {
		if(this.leftChild != null) {
			this.leftChild.infixTraversal(sortedArray);
		}
		sortedArray.add(this.pair);
		if(this.rightChild != null) {
			this.rightChild.infixTraversal(sortedArray);
		}
	}

	/**
	 * Function to traverse BST in Infix order within range and adds Pairs to the List
	 * @param sortedArray a list to collect all Pairs
	 * @param leftKey is non-null String of start of range
	 * @param rightKey is non-null String of end of range
	 */
	public void infixTraversalWithRange(List<Pair> sortedArray, String leftKey, String rightKey) {
		if(this.leftChild != null && this.getKey().compareTo(leftKey) >= 0) {
			this.leftChild.infixTraversalWithRange(sortedArray, leftKey, rightKey);
		}
		if(this.getKey().compareTo(leftKey) >= 0 && this.getKey().compareTo(rightKey) <= 0) {
			sortedArray.add(this.pair);
		}
		if(this.rightChild != null && this.getKey().compareTo(rightKey) <= 0) {
			this.rightChild.infixTraversalWithRange(sortedArray, leftKey, rightKey);
		}
	}
}