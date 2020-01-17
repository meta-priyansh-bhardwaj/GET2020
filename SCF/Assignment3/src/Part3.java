import java.util.*;

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
