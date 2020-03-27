package uniqueCharacters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
		
		Set<Character> uniqueCharacters = new HashSet<Character>();
		for(int i=0;i<string.length();i++) {
			uniqueCharacters.add(string.charAt(i));
		}
		uniqueCount = uniqueCharacters.size();
		return uniqueCount;
	}
}
