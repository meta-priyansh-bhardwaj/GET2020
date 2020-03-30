package dictionary;

/**
 * Class to represent a pair of key and value
 *
 */
public class Pair {
	private String key;
	private String value;

	/**
	 * Constructor to initialize key and value
	 * @param key is a non-null string
	 * @param value
	 * @throws Exception if key is non-null
	 */
	public Pair(String key, String value) throws Exception {
		if(key == null) {
			throw new Exception("Key cannot be null");
		}
		this.key = key;
		this.value = value;
	}
	
	/**
	 * Function to get key
	 * @return key
	 */
	public String getKey() {
		return this.key;
	}
	
	/**
	 * Function to get value
	 * @return
	 */
	public String getValue() {
		return this.value;
	}
	
	/**
	 * Function to set value
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * Checks equility of Pair based on key and value
	 */
	@Override
	public boolean equals(Object object) {
		if(object==null || this.getClass() != object.getClass()) {
			return false;
		}
		Pair pair = (Pair)object;
		return this.key.equals(pair.key) && (this.value==null && pair.value==null || this.value.equals(pair.value));
	}
}
