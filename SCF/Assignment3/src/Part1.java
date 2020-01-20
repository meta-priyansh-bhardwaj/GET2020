import java.util.*;

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
