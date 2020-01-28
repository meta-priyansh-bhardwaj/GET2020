import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestScreen {

	@Test(expected = AssertionError.class)
	public void assertErrorTest() {
		try{
			Screen screen = new Screen();
			screen.isPointEnclosed(null);
		} catch(Exception e) {
			assertEquals("Point can't be Null in isPointEnclosed", e.getMessage());
		}
	}

	@Test
	public void testAddShape() {
		Screen screen = new Screen();
		
		screen.addShape(ShapeTypeEnum.CIRCLE, new Point(200, 200), new ArrayList<>(
				Arrays.asList(50d)));
		screen.addShape(ShapeTypeEnum.RECTANGLE, new Point(1, 23), new ArrayList<>(
				Arrays.asList(12d, 23d)));
		screen.addShape(ShapeTypeEnum.SQUARE, new Point(300, 100), new ArrayList<>(
				Arrays.asList(120d)));
		screen.addShape(ShapeTypeEnum.TRIANGLE, new Point(40, 200), new ArrayList<>(
				Arrays.asList(120d, 200d, 200d)));
		screen.addShape(ShapeTypeEnum.CIRCLE, new Point(20, 35),
				new ArrayList<>(Arrays.asList(5d)));
		int size = screen.getNumberOfShapes();
		assertEquals(5, size);
	}

	@Test
	public void testDeleteShape() {
		Screen screen = new Screen();
		
		screen.addShape(ShapeTypeEnum.CIRCLE, new Point(200, 200), new ArrayList<>(
				Arrays.asList(50d)));
		screen.addShape(ShapeTypeEnum.RECTANGLE, new Point(1, 23), new ArrayList<>(
				Arrays.asList(12d, 23d)));
		screen.addShape(ShapeTypeEnum.SQUARE, new Point(300, 100), new ArrayList<>(
				Arrays.asList(120d)));
		screen.addShape(ShapeTypeEnum.TRIANGLE, new Point(40, 200), new ArrayList<>(
				Arrays.asList(120d, 200d, 200d)));
		assertTrue(screen.deleteShape(ShapeTypeEnum.SQUARE, new Point(300,
				100)));
	}

	@Test
	public void testAllDeleteShape() {
		Screen screen = new Screen();
		screen.deleteShapesOfSpecificType(ShapeTypeEnum.CIRCLE);
	}

	@Test
	public void testAscendingInArea() {
		Screen screen = new Screen();
		
		screen.addShape(ShapeTypeEnum.CIRCLE, new Point(200, 200), new ArrayList<>(
				Arrays.asList(50d)));
		screen.addShape(ShapeTypeEnum.RECTANGLE, new Point(1, 23), new ArrayList<>(
				Arrays.asList(12d, 23d)));
		screen.addShape(ShapeTypeEnum.SQUARE, new Point(300, 100), new ArrayList<>(
				Arrays.asList(120d)));
		screen.addShape(ShapeTypeEnum.TRIANGLE, new Point(40, 200), new ArrayList<>(
				Arrays.asList(120d, 200d, 200d)));
		
		List<Shape> sortedShape = new ArrayList<Shape>();
		List<Shape> shapesList = screen.getShapes();
		sortedShape.add(shapesList.get(1));
		sortedShape.add(shapesList.get(0));
		sortedShape.add(shapesList.get(3));
		sortedShape.add(shapesList.get(2));
		assertEquals(sortedShape, screen.ascendingInArea());
	}

	@Test
	public void testAscendingInPerimeter() {
		Screen screen = new Screen();

		screen.addShape(ShapeTypeEnum.CIRCLE, new Point(200, 200), new ArrayList<>(
				Arrays.asList(50d)));
		screen.addShape(ShapeTypeEnum.RECTANGLE, new Point(1, 23), new ArrayList<>(
				Arrays.asList(12d, 23d)));
		screen.addShape(ShapeTypeEnum.SQUARE, new Point(300, 100), new ArrayList<>(
				Arrays.asList(120d)));
		screen.addShape(ShapeTypeEnum.TRIANGLE, new Point(40, 200), new ArrayList<>(
				Arrays.asList(120d, 200d, 200d)));
		
		List<Shape> sortedShape = new ArrayList<Shape>();
		List<Shape> shapesList = screen.getShapes();
		sortedShape.add(shapesList.get(1));
		sortedShape.add(shapesList.get(0));
		sortedShape.add(shapesList.get(2));
		sortedShape.add(shapesList.get(3));
		assertEquals(sortedShape, screen.ascendingInPerimeter());
	}

	@Test
	public void testAscendingInOriginDistance() {
		Screen screen = new Screen();

		screen.addShape(ShapeTypeEnum.CIRCLE, new Point(200, 200), new ArrayList<>(
				Arrays.asList(50d)));
		screen.addShape(ShapeTypeEnum.RECTANGLE, new Point(1, 23), new ArrayList<>(
				Arrays.asList(12d, 23d)));
		screen.addShape(ShapeTypeEnum.SQUARE, new Point(300, 100), new ArrayList<>(
				Arrays.asList(120d)));
		screen.addShape(ShapeTypeEnum.TRIANGLE, new Point(40, 200), new ArrayList<>(
				Arrays.asList(120d, 200d, 200d)));
		
		List<Shape> sortedShape = new ArrayList<Shape>();
		List<Shape> shapesList = screen.getShapes();
		sortedShape.add(shapesList.get(1));
		sortedShape.add(shapesList.get(3));
		sortedShape.add(shapesList.get(0));
		sortedShape.add(shapesList.get(2));
		assertEquals(sortedShape, screen.ascendingInOriginDistance());
	}

	@Test
	public void testIsPointEnclosed() throws Exception {
		Screen screen = new Screen();

		screen.addShape(ShapeTypeEnum.CIRCLE, new Point(200, 200), new ArrayList<>(
				Arrays.asList(50d)));
		screen.addShape(ShapeTypeEnum.RECTANGLE, new Point(1, 23), new ArrayList<>(
				Arrays.asList(12d, 23d)));
		screen.addShape(ShapeTypeEnum.SQUARE, new Point(300, 100), new ArrayList<>(
				Arrays.asList(120d)));
		screen.addShape(ShapeTypeEnum.TRIANGLE, new Point(40, 200), new ArrayList<>(
				Arrays.asList(120d, 200d, 200d)));
		
		List<Shape> shapesList = screen.getShapes();
		assertEquals(false, shapesList.get(0).isPointEnclosed(new Point(45, 203)));
	}

	@Test
	public void testPointOutOfScreenException() {
		Screen screen = new Screen();
		try {
			screen.addShape(ShapeTypeEnum.CIRCLE, new Point(20, 35),
					new ArrayList<>(Arrays.asList(5d)));
			screen.addShape(ShapeTypeEnum.RECTANGLE, new Point(20, 35),
					new ArrayList<>(Arrays.asList(5d, 6d)));
		} catch (Exception ex) {
			assertEquals("Shape is Out of Screen", ex.getMessage());
		}
	}
}
