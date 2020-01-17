/**
 * Design a class Area to calculate areas for different shapes
 * @author Priyansh
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
		return Math.PI*radius*radius;
	}
};