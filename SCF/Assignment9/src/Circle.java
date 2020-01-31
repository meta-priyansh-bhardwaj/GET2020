import java.util.Date;

/**
 * Class that represent a Circle implements Shape
 *
 */
public class Circle implements Shape {
	Point center;
	double radius;
	Date timeStamp;
	
	/**
	 * Instantiates a new circle.
	 * @param radius is the radius of circle.
	 * @param center the center of circle
	 */
	public Circle(double radius, Point center) throws Exception {
		if (radius <= 0) {
			throw new Exception("Radius found non-positive");
		}
		this.radius = radius;
		this.center = center;
		this.timeStamp = new Date();
	}

	/**
	 * Method to return the area of shape.
	 */
	@Override
	public double getArea() {
		double area = Math.PI * radius * radius;
		return area;
	}

	/**
	 * Method to return the perimeter of shape.
	 */
	@Override
	public double getPerimeter() {
		double perimeter = Math.PI * 2 * radius;
		return perimeter;
	}

	/**
	 * Method to return the origin of shape.
	 */
	@Override
	public Point getOrigin() {
		return center;
	}

	/** Method to check if a point is enclosed in a shape.
	 * @param point specifies the x and y coordinate.
	 * @return true if point lies within the shape and false otherwise.
	 */
	@Override
	public boolean isPointEnclosed(Point point) {
		double distance = center.getDistance(point);
		if (distance <= radius) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method to return the type of shape.
	 */
	@Override
	public ShapeTypeEnum getType() {
		return ShapeTypeEnum.CIRCLE;
	}
	
	/**
	 * Method to return the time stamp of shape.
	 */
	@Override
	public Date getTimeStamp(){
		return timeStamp;
	}
}