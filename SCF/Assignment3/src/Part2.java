import java.util.*;

public class Part2 {
	public static void main(String args[]) throws Exception{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter no. of students:");
		int count = input.nextInt();
		input.nextLine();
		
		if (count == 0)
			throw (new Exception("Empty Class"));
		
		Marksheet m = new Marksheet(count, input);
		
		System.out.println("Average: "+m.getAverage());
		System.out.println("Maximum: "+m.getMaximum());
		System.out.println("Minimum: "+m.getMinimum());
		System.out.println("Percentage of passed students: "+m.getPassedPercentage());
	}
}
