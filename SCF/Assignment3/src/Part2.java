import java.util.*;

/**
 * Design a class Marksheet, which reads in grades of n no of students. Assume n
 * as a positive integer and grades will be between 0 and 100 both inclusive.
 * 
 * @author Priyansh
 *
 */

class Marksheet{
	private int count, passed;
	private int grades[];
	private float maximum,total,minimum;
	
	private static final int passingMark = 40;
	
	/**
	 * Takes input grades of n students
	 * @param count of students in class
	 */
	public Marksheet(int count, Scanner input){
		this.count = count;
		maximum = 0;
		minimum = 100;
		total = 0;
		passed = 0;
		grades = new int[count];
		System.out.println("Enter grade of student no.:");
		for(int i=0;i<count;i++){
			System.out.print((i+1)+". ");
			grades[i] = input.nextInt();
			input.nextLine();
			if(maximum<grades[i]){
				maximum = grades[i];
			}
			if(minimum>grades[i]){
				minimum = grades[i];
			}
			if(grades[i]>=passingMark){
				passed++;
			}
			total += grades[i];
		}
	}
	
	/**
	 * @return average of the student
	 * @throws Exception
	 */
	public float getAverage() throws Exception{
		if (count == 0) {
			throw (new Exception("divide by zero"));
		}
		return total/count;
	}
	
	/**
	 * @return max_grade
	 */
	public float getMaximum(){
		return maximum;
	}
	
	/**
	 * @return min grade
	 */
	public float getMinimum(){
		return minimum;
	}
	
	/**
	 * @return percentage of the students
	 */
	public float getPassedPercentage(){
		return ((float)passed*100)/count;
	}
};

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
