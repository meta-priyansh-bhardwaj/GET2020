package triangle;

public class Triangle {

	/**
	 * Function to calculate area of triangle using Heron's Formulae
	 * @param firstSide
	 * @param secondSide
	 * @param thirdSide
	 * @return area of triangle
	 */
	public String area(int firstSide,int secondSide,int thirdSide)
	{
		double semiPerimeter=(firstSide+secondSide+thirdSide)/2.0;
		double areaSquare=semiPerimeter*(semiPerimeter-firstSide)*(semiPerimeter-secondSide)*(semiPerimeter-thirdSide);
		double area=Math.sqrt(areaSquare);
		return String.valueOf((double)area);
	}

}