package dictionary;

import java.util.List;

/**
 * Interface to represent a Dictionary
 *
 */
public interface Dictionary {
	
	/**
	 * Function to add key-value pair to the dictionary
	 * @param key is a non-null String
	 * @param value
	 * @throws Exception if key is null
	 */
	public void add(String key, String value) throws Exception;
	
	/**
	 * Function to delete key-value pair with reference of key
	 * @param key is a non-null String
	 * @return true if found and deleted or false otherwise
	 */
	public boolean delete(String key);
	
	/**
	 * Function to get value with reference of key
	 * @param key is a non-null String
	 * @return value if found or null otherwise
	 */
	public String get(String key);
	
	/**
	 * Function to get all key-value pairs in ascending order
	 * @return List of all pairs
	 */
	public List<Pair> getAllPairs();
	
	/**
	 * Function to get key-value pairs within range in ascending order
	 * @param leftKey non-null String of start of range
	 * @param rightKey non-null String of end of range
	 * @return List of pairs within range
	 */
	public List<Pair> getPairsInRange(String leftKey, String rightKey);
}
