import java.util.Date;

/**
 * Class to represent a square
 *
 */
public class Square implements Shape {
	private double side;
	private Point origin;
	private Date timeStamp;

	/**
	 * Instantiates a new square.
	 * @param side of the square
	 * @param origin left-down corner point of square
	 * @throws Exception
	 */
	public Square(double side, Point origin) throws Exception {
		if(side <=0){
			throw new Exception("Side found non-positive");
		}
		this.side = side;
		this.origin = origin;
		this.timeStamp = new Date();
	}

	/**
	 * Method to return area of the shape.
	 */
	@Override
	public double getArea() {
		return side * side;
	}

	/**
	 * Method to return time stamp of the shape.
	 */
	@Override
	public double getPerimeter() {
		return 4 * side;
	}

	/**
	 * Method to return origin of the shape.
	 */
	@Override
	public Point getOrigin() {
		return origin;
	}

	/**
	 * Method to check if a point is enclosed in a shape.
	 * @param point specifies the x and y coordinate.
	 * @return true if point lies within the shape and false otherwise.
	 */
	@Override
	public boolean isPointEnclosed(Point point) {
		boolean enclosedX = point.getX() >= origin.getX()
				&& point.getX() <= origin.getX() + side;
		boolean enclosedY = point.getX() >= origin.getX()
				&& point.getY() <= origin.getY() + side;
		return enclosedX && enclosedY;
	}

	/**
	 * Method to return type of the shape.
	 */
	@Override
	public ShapeTypeEnum getType() {
		return ShapeTypeEnum.SQUARE;
	}
	
	/**
	 * Method to return time stamp of the shape.
	 */
	@Override
	public Date getTimeStamp(){
		return timeStamp;
	}
}
