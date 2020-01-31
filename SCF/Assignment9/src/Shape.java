import java.util.Date;

/**
 * This interface is made for Shapes Properties
 *
 */
public interface Shape {
	/**
	 * @return area
	 */
	double getArea();
	/**
	 * @return perimeter
	 */
	double getPerimeter();
	/**
	 * @return origin
	 */
	Point getOrigin();
	/**
	 * @param point
	 * @return point is inclosed or not
	 */
	boolean isPointEnclosed(Point point) throws Exception;
	/**
	 * @return type
	 */
	ShapeTypeEnum getType();
	/**
	 * @return date and time
	 */
	Date getTimeStamp();
}