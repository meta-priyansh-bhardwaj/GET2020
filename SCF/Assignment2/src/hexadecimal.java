import java.util.*;
class conversion
{
	/**
	 * Converts given hexadecimal number to decimal.
	 * @param str : hexadecimal number.
	 * @return decimal equivalent of given hexadecimal number.
	 */
	public double Hex_to_dec(String str)
	{
		double number=0;
		int number1=16;
		String def="0123456789ABCDE";
		int d=str.length();
		for(int i=0;i<str.length();i++)
		{
		     char c = str.charAt(i);  
		     number1 = def.indexOf(c);
		     	if(0<=number1&&number1>=15)
		     		{
		    	 		d--;
		    	 		number = Math.pow(16,d)*number1+number;
		     		}
		     
		}
				return number; 
	}
	/**
	 * Addition Function
	 * @param d Number
	 * @param d1 Number
	 */
	public void add(double d,double d1)
	{
		int d2 = (int) (d + d1);
		System.out.println(d2);
		Dec_to_hex(d2);
	}
	
	public void sub(double d,double d1)
	{
		int d3 = (int) (d-d1);
		Dec_to_hex(d3);
	}
	/**
	 * Multiplication function
	 * @param d Number
	 * @param d1 Number
	 */
	public void mul(double d,double d1)
	{
		int d3 = (int) (d*d1);
		Dec_to_hex(d3);
	}
	/**
	 * Division Function
	 * @param d Number
	 * @param d1 Number
	 */
	public void div(double d,double d1)
	{
		int d3 = (int) (d/d1);
		Dec_to_hex(d3);
	}
	/**
	 * convert hexadecimal to decimal number
	 * @param d decimal number
	 */
	public void Dec_to_hex(int d)
	{ 
	   	 int rem;
	     String str2="";
	     char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	     while(d>0)
	     {
	       rem = d%16; 
	       str2 = hex[rem]+str2; 
	       d = d/16;
	     }
	     System.out.println(str2);
	  } 	
     /**
      * Equal function
      * @param Hex1 Hexadecimal String 
      * @param Hex2 Hexadecimal String
      * @return Boolean value
      */
	public boolean isequal(String Hex1,String Hex2) {
		if(Hex1.compareTo(Hex2)==0) {
		return true;
		}
		return false;
	}
	/**
	 * greater function
	 * @param Hex1 Hexadecimal String
	 * @param Hex2 Hexadecimal String
	 * @return Boolean value
	 */
	public boolean isgreater(String Hex1,String Hex2) {
		if(Hex1.compareTo(Hex2) > 0) {
			return true;
		}
		return false;
	}
	/**
	 * smaller function
	 * @param Hex1 Hexadecimal String
	 * @param Hex2 Hexadecimal String
	 * @return Boolean value
	 */
	public boolean issmaller(String Hex1,String Hex2) {
		if(Hex1.compareTo(Hex2) < 0) {
			return true;
		}
		return false;
	}
	
}
	public class hexadecimal
	{
		public static void main(String args[])
		{
			Scanner input=new Scanner(System.in);
		    System.out.println("enter the hexadecimal no1");
		    String str=input.next();
		    System.out.println("enter the hexadecimal no2");
		    String str1=input.next();
		    conversion c = new conversion();
		    double d = c.Hex_to_dec(str);
		    double d1 = c.Hex_to_dec(str1);
		    int t=1;
			while(t!=0){
				System.out.println("press 1 for addition");
				System.out.println("press 2 for subtraction");
				System.out.println("press 3 for multiplication");
				System.out.println("press 4 for division");
				System.out.println("press 5 for check Hexadecimal are equal or not");
				System.out.println("press 6 for check Hexadecimal1 is greater");
				System.out.println("press 7 for check Hexadecimal1 is smaller");
				System.out.println("Press 8 for exit");
				int x=input.nextInt();
					switch(x)
						{
						case 1:
							{
								c.add(d,d1);
								break;
							}
						case 2:
							{
								c.sub(d,d1);
								break;
							}		
						case 3:
							{
								c.mul(d,d1);
								break;
							}		
						case 4:
							{
								c.div(d,d1);
								break;
							}
						case 5:
							{
								System.out.println(c.isequal(str,str1));
								break;
							}
						case 6:
							{
								System.out.println(c.isgreater(str,str1));
								break;
							}
						case 7:
							{
								System.out.println(c.issmaller(str,str1));
								break;
							}
						case 8:
							{
								t=0;
								break;
							}
						default:
							{
								System.out.println("enter valid choice");
								continue;
							}

				}
			}
		}
}
