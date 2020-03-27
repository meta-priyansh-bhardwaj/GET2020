package uniqueCharacters;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to solve counting of unique characters in a string
 *
 */
public class UniqueCharacters {
	
	private static Map<String, Integer> cache = new HashMap<String, Integer>();

	/**
	 * Function to count unique characters in a string
	 * @param string
	 * @return number of unique characters
	 */
	public static int countUniqueCharacters(String string) {
		if(string == null) {
			return 0;
		}
		
		Integer uniqueCount = cache.get(string);
		if(uniqueCount != null) {
			return uniqueCount;
		}
		
		uniqueCount = 0;
		Map<Character,Integer> charactersCount = new HashMap<Character, Integer>();
		for(int i=0;i<string.length();i++) {
			Integer count = charactersCount.get(string.charAt(i));
			if(count == null) {
				charactersCount.put(string.charAt(i), 1);
			} else {
				charactersCount.put(string.charAt(i), count+1);
			}
		}
		for(int count: charactersCount.values()) {
			if(count == 1) {
				uniqueCount++;
			}
		}
		return uniqueCount;
	}
}
