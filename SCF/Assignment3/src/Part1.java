import java.util.*;

/**
 * Design a class that perform following operations on Strings, without using
 * Java APIs. Assume strings to be not null and case sensitive.
 * 
 * @author Priyansh
 *
 */

class StringOperations {
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

public class Part1 {
	
	public static void main(String args[]){
		StringOperations s = new StringOperations();
		Scanner input = new Scanner(System.in);
		
		Boolean active = true;
		while(active){
			System.out.println("Enter Your Choice:");
			System.out.println("1. Compare two strings");
			System.out.println("2. Reverse a string");
			System.out.println("3. Transform a string");
			System.out.println("4. Find largest word in a string");
			System.out.println("5. Exit");
			
			int choice = input.nextInt();
			input.nextLine();
				
			switch(choice){
				case 1:{
					System.out.println("First String: ");
					String A = input.nextLine();
					System.out.println("Second String: ");
					String B = input.nextLine();
					int result = s.Compare(A, B);
					if(result==1){
						System.out.println("They are equal");
					}
					else{
						System.out.println("They are not equal");
					}
					break;
				}
				case 2:{
					System.out.println("Enter a String: ");
					String A = input.nextLine();
					System.out.println("Result: "+s.Reverse(A));
					break;
				}
				case 3:{
					System.out.println("Enter a String: ");
					String A = input.nextLine();
					System.out.println("Result: "+s.Transform(A));
					break;
				}
				case 4:{
					System.out.println("Enter a String: ");
					String A = input.nextLine();
					System.out.println("Result: "+s.LargestWord(A));
					break;
				}
				case 5:{
					active=false;
					break;
				}
				default:{
					System.out.println("Invalid Choice!");
				}
			}
		}
	}
}
