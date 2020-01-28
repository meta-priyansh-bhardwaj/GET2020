import java.util.Date;

/**
 * Rectangle class implements Shape interface
 *
 */
public class Rectangle implements Shape {
	private double length;
	private double breadth;
	private Point origin;
	private Date timeStamp;

	/**
	 * Constructor for initialization of values
	 * @param length
	 * @param breadth
	 * @param origin
	 * @throws Exception
	 */
	public Rectangle(double length, double breadth, Point origin) throws Exception {
		if(length <=0 || breadth <=0){
			throw new Exception("Length or breadth found non-positive");
		}
		this.length = length;
		this.breadth = breadth;
		this.origin = origin;
		this.timeStamp = new Date();
	}

	/**
	 * Method to return area of shape
	 */
	@Override
	public double getArea() {
		return length * breadth;
	}

	/**
	 * Method to return perimeter of shape.
	 */
	@Override
	public double getPerimeter() {
		return 2 * (length + breadth);
	}

	/**
	 * Method to return origin of shape.
	 */
	@Override
	public Point getOrigin() {
		return origin;
	}

	/**
	 *  Method to check if a point is enclosed in a shape.
	 * @param point specifies the x and y coordinate.
	 * @return true if point lies within the shape and false otherwise.
	 */
	@Override
	public boolean isPointEnclosed(Point point) {
		boolean enclosedX = point.getX() >= origin.getX()
				&& point.getX() <= origin.getX() + length;
		boolean enclosedY = point.getX() >= origin.getX()
				&& point.getY() <= origin.getY() + breadth;
		return enclosedX && enclosedY;
	}

	/**
	 *  Method to return type of shape
	 * return Shapetype
	 */
	@Override
	public ShapeTypeEnum getType() {
		return ShapeTypeEnum.RECTANGLE;
	}
	
	/**
	 * Method to return timestamp of shape.
	 */
	@Override
	public Date getTimeStamp(){
		return timeStamp;
	}
	
}
