import java.util.*;

/**
 * Design a class Area to calculate areas for different shapes
 * @author Murtaza
 *
 */
class Area{
	
	/**
	 * @param base
	 * @param height
	 * @return area of triangle
	 * @throws Exception
	 */
	public double triangle(double base, double height) throws Exception{
		if(base<0||height<0){
			throw (new Exception("negative dimension not allowed"));
		}
		return (base*height)/2;
	}
	
	/**
	 * @param length
	 * @param breadth
	 * @return area of rectangular
	 * @throws Exception
	 */
	public double rectangle(double length, double breadth) throws Exception{
		if(length<0||breadth<0){
			throw (new Exception("negative dimension not allowed"));
		}
		return length*breadth;
	}
	
	/**
	 * @param side
	 * @return area of square
	 * @throws Exception
	 */
	public double square(double side) throws Exception{
		if(side<0){
			throw (new Exception("negative dimension not allowed"));
		}
		return side*side;
	}
	
	/**
	 * @param radius
	 * @return area of circle
	 * @throws Exception
	 */
	public double circle(double radius) throws Exception{
		if(radius<0){
			throw (new Exception("negative dimension not allowed"));
		}
		return 2*Math.PI*radius;
	}
};

public class Part3 {
	public static void main(String args[]){
		Area a = new Area();
		Scanner input = new Scanner(System.in);
		
		Boolean active = true;
		while(active){
			System.out.println("Enter Your Choice:");
			System.out.println("1. Triangle");
			System.out.println("2. Reactangle");
			System.out.println("3. Square");
			System.out.println("4. Circle");
			System.out.println("5. Exit");
			
			int choice = input.nextInt();
			input.nextLine();
			
			try{
				switch(choice){
					case 1:{
						System.out.println("Base: ");
						double base = input.nextDouble();
						System.out.println("Height: ");
						double height = input.nextDouble();
						double area = a.triangle(base, height);
						System.out.println("Area: "+area);
						break;
					}
					case 2:{
						System.out.println("Length: ");
						double length = input.nextDouble();
						System.out.println("Breadth: ");
						double breadth = input.nextDouble();
						double area = a.rectangle(length, breadth);
						System.out.println("Area: "+area);
						break;
					}
					case 3:{
						System.out.println("Side: ");
						double side = input.nextDouble();
						double area = a.square(side);
						System.out.println("Area: "+area);
						break;
					}
					case 4:{
						System.out.println("Radius: ");
						double radius = input.nextDouble();
						double area = a.circle(radius);
						System.out.println("Area: "+area);
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
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
