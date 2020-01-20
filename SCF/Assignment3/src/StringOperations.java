/**
 * Design a class that perform following operations on Strings, without using
 * Java APIs. Assume strings to be not null and case sensitive.
 * 
 * @author Priyansh
 *
 */

public class StringOperations {
	/**
	 * @param A
	 * @param B
	 * @return return 1 if string are same else return 0
	 */
	public int Compare(String A, String B){
		if(A.length()!=B.length()){
			return 0;
		}
		for(int i=0;i<A.length();i++){
			if(A.charAt(i)!=B.charAt(i)){
				return 0;
			}
		}
		return 1;
	}
	
	/**
	 * @param str
	 * @return reverse of the string
	 */
	public String Reverse(String str){
		String reverse = new String();
		for(int i=str.length()-1;i>=0;i--){
			reverse += str.charAt(i);
		}
		return reverse;
	}
	
	/**
	 * @param str
	 * @return return toggle of a string
	 */
	public String Transform(String str){
		String transformed = new String();
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)>='a' && str.charAt(i)<='z'){
				transformed += (char)(str.charAt(i)-32);
			}
			else if(str.charAt(i)>='A' && str.charAt(i)<='Z'){
				transformed += (char)(str.charAt(i)+32);
			}
			else{
				transformed += str.charAt(i);
			}
		}
		return transformed;
	}
	
	/**
	 * @param s
	 * @return largest word of a string
	 */
	public String LargestWord(String str){
		String largest = new String();
		int length = 0;
	
		String localLargest = new String();
		int localLength = 0;
		
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)!=' ' && i+1<str.length()){
				localLength++;
				localLargest+=str.charAt(i);
			}
			else{
				if(str.charAt(i)!=' '){
					localLength++;
					localLargest += str.charAt(i);
				}
				if(length<=localLength){
					length = localLength;
					largest = localLargest;
				}
				localLength = 0;
				localLargest = "";
			}
		}
		return largest;
	}
};