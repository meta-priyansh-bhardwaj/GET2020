import java.util.Date;

/**
 * Class that represents a Triangle implements Shape
 * @author Priyansh
 *
 */
public class Triangle implements Shape {
	private double[] sides;
	private Point origin;
	private Date timeStamp;

	/**
	 * Instantiates a new triangle.
	 * @param a first side of triangle
	 * @param b second side of triangle
	 * @param c third side of triangle
	 * @param origin left-down corner point of triangle (Point A)
	 * @throws Exception
	 */
	public Triangle(double a, double b, double c, Point origin)
			throws Exception {
		if (a <= 0 || b <= 0 || c <= 0) {
			throw new Exception("One of the sides found non-positive");
		}
		sides = new double[3];
		sides[0] = a;
		sides[1] = b;
		sides[2] = c;
		this.origin = origin;
		this.timeStamp = new Date();
	}

	/**
	 * Calculation of area using heron's formula and return it.
	 */
	@Override
	public double getArea() {
		double semiPerimeter = this.getPerimeter() / 2;
		double squaredArea = semiPerimeter * (semiPerimeter - sides[0])
				* (semiPerimeter - sides[1]) * (semiPerimeter - sides[2]);
		return Math.sqrt(squaredArea);
	}

	/**
	 * Method to return perimeter of the shape.
	 */
	@Override
	public double getPerimeter() {
		return sides[0] + sides[1] + sides[2];
	}

	/**
	 * Method to return distance from origin of the shape.
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
	public boolean isPointEnclosed(Point point) throws Exception {
		double AB = sides[0], BC = sides[1], CA = sides[2];
		Point A = origin;
		Point B = new Point(A.getX() + AB, A.getY());
		double xOfC = (BC * BC - CA * CA) / (2 * (A.getX() - B.getX()))
				+ A.getX() + B.getX();
		double yOfC = B.getY()
				+ Math.sqrt(BC * BC - Math.pow(xOfC - B.getX(), 2));
		Point C = new Point(xOfC, yOfC);

		double AP = A.getDistance(point);
		double BP = B.getDistance(point);
		double CP = C.getDistance(point);
	
		double areaAPB = new Triangle(AP, BP, AB, A).getArea();
		double areaAPC = new Triangle(AP, CP, CA, A).getArea();
		double areaBPC = new Triangle(BP, CP, BC, B).getArea();

		return Math.abs(this.getArea() - (areaAPB + areaAPC + areaBPC)) < 0.00001;
	}

	/**
	 * Method to return type of the shape.
	 */
	@Override
	public ShapeTypeEnum getType() {
		return ShapeTypeEnum.TRIANGLE;
	}
	
	/**
	 * Method to return timestamp of the shape.
	 */
	@Override
	public Date getTimeStamp(){
		return timeStamp;
	}
}
