package dictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.json.simple.JSONObject;

/**
 * Class to implement Dictionary using Binary Search Tree(BST)
 *
 */
public class DictionaryImplementaton implements Dictionary {
	private Node root;
	
	/**
	 * Constructor to add all key-value pairs from JSON data
	 * @param data inJSON format
	 * @throws Exception data is found null or if any key found null
	 */
	public DictionaryImplementaton(JSONObject data) throws Exception {
		if(data == null) {
			throw new Exception("Data found null!");
		}
		for(Object entry: data.entrySet()) {
			String key = (String)((Entry<?,?>)entry).getKey();
			String value = (String)((Entry<?,?>)entry).getValue();
			this.add(key, value);
		}
	}

	/**
	 * Function to add key-value pair to the dictionary
	 * @param key is a non-null String
	 * @param value
	 * @throws Exception if key is null
	 */
	@Override
	public void add(String key, String value) throws Exception {
		Node node = new Node(key, value);
		if(this.root == null) {
			this.root = node;
			return;
		}
		this.root.addNode(node);
	}

	/**
	 * Function to delete key-value pair with reference of key
	 * @param key is a non-null String
	 * @return true if found and deleted or false otherwise
	 */
	@Override
	public boolean delete(String key) {
		if(this.root==null) {
			return false;
		}
		if(this.root.getKey().equals(key) && this.root.getLeftChild()==null && this.root.getRightChild()==null) {
			this.root = null;
			return true;
		}
		return this.root.deleteNode(key);
	}

	/**
	 * Function to get value with reference of key
	 * @param key is a non-null String
	 * @return value if found or null otherwise
	 */
	@Override
	public String get(String key) {
		if(this.root==null) {
			return null;
		}
		Node keyNode = this.root.searchKey(key);
		if(keyNode == null) {
			return null;
		}
		return keyNode.getValue();
	}

	/**
	 * Function to get all key-value pairs in ascending order
	 * @return List of all pairs
	 */
	@Override
	public List<Pair> getAllPairs() {
		List<Pair> sortedArray= new ArrayList<Pair>();
		if(this.root!=null) {
			this.root.infixTraversal(sortedArray);
		}
		return sortedArray;
	}

	/**
	 * Function to get key-value pairs within range in ascending order
	 * @param leftKey non-null String of start of range
	 * @param rightKey non-null String of end of range
	 * @return List of pairs within range
	 */
	@Override
	public List<Pair> getPairsInRange(String leftKey, String rightKey) {
		List<Pair> sortedArray= new ArrayList<Pair>();
		this.root.infixTraversalWithRange(sortedArray, leftKey, rightKey);
		return sortedArray;
	}
}
