import java.util.List;

/**
 * Class to create objects of different shapes at one place
 *
 */
public class ShapeFactory {
	static Shape shape;

	/** Method to create objects of different shapes.
	 * @param type is of enum type created in shape class to define the type of shape for which object is to be created.
	 * @param point represents the coordinates.
	 * @param dimensionsOfShape contains the dimensions of the shape.
	 * @return shape object.
	 */
	public static Shape createShape(ShapeTypeEnum shapeType, Point point,
			List<Double> shapeProperties) throws Exception {
		ShapeTypeEnum shapeTypeEnum = shapeType;
		switch (shapeTypeEnum) {
		case CIRCLE:
			shape = new Circle(shapeProperties.get(0), point);
			return shape;

		case RECTANGLE:
			shape = new Rectangle(shapeProperties.get(0),
					shapeProperties.get(1), point);
			return shape;
		case SQUARE:
			shape = new Square(shapeProperties.get(0), point);
			return shape;
		case TRIANGLE:
			shape = new Triangle(shapeProperties.get(0),
					shapeProperties.get(1), shapeProperties.get(2), point);
			return shape;
		default:
			break;

		}
		return null;
	}
}