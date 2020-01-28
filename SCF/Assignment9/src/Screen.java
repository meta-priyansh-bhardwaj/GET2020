import java.util.ArrayList;
import java.util.List;

/**
 * This class implements various methods based on Shapes and performs various
 * operations on Shapes
 * 
 *
 */
public class Screen {
	private List<Shape> shapesList;;

	public Screen() {
		shapesList = new ArrayList<Shape>();
	}
	
	public List<Shape> getShapes(){
		return new ArrayList<Shape>(shapesList);
	}
	
	public int getNumberOfShapes(){
		return shapesList.size();
	}

	/**
	 * Add Shape to Shape List
	 * 
	 * @param shapeType
	 * @param point
	 * @param parameters
	 * @return size of list
	 */
	public void addShape(ShapeTypeEnum shapeType, Point point,
			List<Double> parameters) {
		try {
			shapesList.add(ShapeFactory.createShape(shapeType, point, parameters));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Delete Shape from Shape List
	 * 
	 * @param shapeType
	 * @param point
	 * @return true if shape is delete in the list
	 */
	boolean deleteShape(ShapeTypeEnum shapeType, Point point) {
		if (shapeType == null || point == null) {
			throw new AssertionError("Arguments in deleteShape can't be Null");
		}

		for (int i = 0; i < shapesList.size(); i++) {
			if (shapesList.get(i).getType() == shapeType
					&& shapesList.get(i).getOrigin().getX() == point
							.getX()
					&& shapesList.get(i).getOrigin().getY() == point
							.getY()) {
				shapesList.remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * Delete all Shapes of Specific Shape type
	 * 
	 * @param shapeType
	 * @return true if shape of specific type is delete in the list
	 */
	boolean deleteShapesOfSpecificType(ShapeTypeEnum shapeType) {
		if (shapeType == null) {
			throw new AssertionError(
					"ShapeType can't be Null in deleteShapesOfSpecificType");
		}
		for (int i = 0; i < shapesList.size(); i++) {
			if (shapesList.get(i).getType() == shapeType) {
				shapesList.remove(i);
				i--;
			}
		}
		return true;
	}

	/**
	 * Arranges Shapes in ascending order on the basis of Area
	 * 
	 * @return sortedShapes object of list shape
	 */
	List<Shape> ascendingInArea() {
		List<Shape> sortedShapes = new ArrayList<Shape>(shapesList);
		for (int i = 0; i < sortedShapes.size() - 1; i++) {
			for (int j = 0; j < sortedShapes.size() - i - 1; j++) {
				if (sortedShapes.get(j).getArea() > sortedShapes.get(j + 1)
						.getArea()) {
					Shape temporary = sortedShapes.get(j + 1);
					sortedShapes.set(j + 1, sortedShapes.get(j));
					sortedShapes.set(j, temporary);
				}
			}
		}
		return sortedShapes;
	}

	/**
	 * Arranges Shapes in ascending order on the basis of Parameter
	 * 
	 * @return sortedShapes object of list shape
	 */
	List<Shape> ascendingInPerimeter() {
		List<Shape> sortedShapes = new ArrayList<Shape>(shapesList);
		for (int i = 0; i < sortedShapes.size() - 1; i++) {
			for (int j = 0; j < sortedShapes.size() - 1 - i; j++) {
				if (sortedShapes.get(j).getPerimeter() > sortedShapes
						.get(j + 1).getPerimeter()) {
					Shape temporary = sortedShapes.get(j + 1);
					sortedShapes.set(j + 1, sortedShapes.get(j));
					sortedShapes.set(j, temporary);
				}
			}
		}
		return sortedShapes;
	}

	/**
	 * Arranges Shapes in ascending order on the basis of Time Stamp
	 * 
	 * @return sortedShapes object of list shape
	 */
	List<Shape> ascendingInTimeStamp() {
		List<Shape> sortedShapes = new ArrayList<>(shapesList);
		for (int i = 0; i < sortedShapes.size() - 1; i++) {
			for (int j = 0; j < sortedShapes.size() - i - 1; j++) {
				if (sortedShapes.get(j).getTimeStamp()
						.after(sortedShapes.get(j + 1).getTimeStamp())) {
					Shape temporary = sortedShapes.get(j + 1);
					sortedShapes.set(j + 1, sortedShapes.get(j));
					sortedShapes.set(j, temporary);
				}
			}
		}
		return sortedShapes;
	}

	/**
	 * Arranges Shapes in ascending order on the basis of Origin Distance
	 * 
	 * @return sortedShapes object of list shape
	 */
	List<Shape> ascendingInOriginDistance() {
		List<Shape> sortedShapes = new ArrayList<>(shapesList);
		for (int i = 0; i < sortedShapes.size() - 1; i++) {
			for (int j = 0; j < sortedShapes.size() - 1 - i; j++) {
				double originDistance1 = sortedShapes.get(j).getOrigin().getDistance(new Point(0d,0d));
				double originDistance2 = sortedShapes.get(j+1).getOrigin().getDistance(new Point(0d,0d));
				if (originDistance1 > originDistance2) {
					Shape temp = sortedShapes.get(j + 1);
					sortedShapes.set(j + 1, sortedShapes.get(j));
					sortedShapes.set(j, temp);
				}
			}
		}
		return sortedShapes;
	}

	/**
	 * Returns all the Shapes that Enclose the given Point
	 * 
	 * @param point
	 * @return
	 */
	List<Shape> isPointEnclosed(Point point) throws Exception {
		if (point == null) {
			throw new AssertionError("Point can't be Null in isPointEnclosed");
		}
		List<Shape> pointEnclosedShapes = new ArrayList<>();
		for (int i = 0; i < shapesList.size(); i++) {
			if (shapesList.get(i).isPointEnclosed(point)) {
				pointEnclosedShapes.add(shapesList.get(i));
			}
		}
		return pointEnclosedShapes;
	}
}