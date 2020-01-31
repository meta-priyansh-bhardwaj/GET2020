/**
 * Class to implement a 2D coordinate point
 *
 */
public class Point {
	private final double x, y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Method to return x coordinate.
	 * @return x
	 */
	public double getX() {
		return x;
	}

	/**
	 * Method to return y coordinate.
	 * @return y
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * Method that calculates and returns distance to another coordinate
	 * @param p another point
	 * @return distance
	 */
	public double getDistance(Point p){
		double distance = Math.sqrt( Math.pow(x-p.x, 2) + Math.pow(y-p.y, 2) );
		return distance;
	}
}
