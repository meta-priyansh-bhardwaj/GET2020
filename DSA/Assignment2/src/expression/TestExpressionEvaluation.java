package expression;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Class to test ExpressionEvaluation
 *
 */
public class TestExpressionEvaluation {

	@Test
	public void testExpression1() {
		try {
			int answer = ExpressionEvaluation.evaluateExpression("2 * 6");
			int expectedAnswer = 12;
			assertEquals(answer, expectedAnswer);
		} catch (Exception e) {
			if(e.getMessage() == null){
				System.out.println("Unknows exception occured");
			} else {
				System.out.println(e.getMessage());
			}
		}
	}

	@Test
	public void testExpression2() {
		try {
			int answer = ExpressionEvaluation.evaluateExpression("( 7 * 8 ) - 7 * ( 10 / 2 )");
			int expectedAnswer = 21;
			assertEquals(answer, expectedAnswer);
		} catch (Exception e) {
			if(e.getMessage() == null){
				System.out.println("Unknows exception occured");
			} else {
				System.out.println(e.getMessage());
			}
		}
	}
	
	@Test
	public void testExpression3() {
		try {
			int answer = ExpressionEvaluation.evaluateExpression("100 * ( 2 + 12 )");
			int expectedAnswer = 1400;
			assertEquals(answer, expectedAnswer);
		} catch (Exception e) {
			if(e.getMessage() == null){
				System.out.println("Unknows exception occured");
			} else {
				System.out.println(e.getMessage());
			}
		}
	}

	@Test
	public void testExpression4() {
		try {
			int answer = ExpressionEvaluation.evaluateExpression(" ( 2 > 12 ) ");
			int expectedAnswer = 0;
			assertEquals(answer, expectedAnswer);
		} catch (Exception e) {
			if(e.getMessage() == null){
				System.out.println("Unknows exception occured");
			} else {
				System.out.println(e.getMessage());
			}
		}
	}
	
	@Test
	public void testExpression5() {
		try {
			int answer = ExpressionEvaluation.evaluateExpression(" 100 * ( 2 + 12 ) / 14");
			int expectedAnswer = 100;
			assertEquals(answer, expectedAnswer);
		} catch (Exception e) {
			if(e.getMessage() == null){
				System.out.println("Unknows exception occured");
			} else {
				System.out.println(e.getMessage());
			}
		}
	}
	
	@Test
	public void testExpression6() {
		try {
			int answer = ExpressionEvaluation.evaluateExpression("  ( 2 < 12 ) ");
			int expectedAnswer = 1;
			assertEquals(answer, expectedAnswer);
		} catch (Exception e) {
			if(e.getMessage() == null){
				System.out.println("Unknows exception occured");
			} else {
				System.out.println(e.getMessage());
			}
		}
	}
	
	@Test
	public void testExpression7() {
		try {
			int answer = ExpressionEvaluation.evaluateExpression("! 0");
			int expectedAnswer = 1;
			assertEquals(answer, expectedAnswer);
		} catch (Exception e) {
			if(e.getMessage() == null){
				System.out.println("Unknows exception occured");
			} else {
				System.out.println(e.getMessage());
			}
		}
	}
	
	@Test
	public void testExpression8() {
		try {
			int answer = ExpressionEvaluation.evaluateExpression("! 65");
			int expectedAnswer = 0;
			assertEquals(answer, expectedAnswer);
		} catch (Exception e) {
			if(e.getMessage() == null){
				System.out.println("Unknows exception occured");
			} else {
				System.out.println(e.getMessage());
			}
		}
	}
	
	@Test
	public void testExpression9() {
		try {
			int answer = ExpressionEvaluation.evaluateExpression("0 && 12");
			int expectedAnswer = 0;
			assertEquals(answer, expectedAnswer);
		} catch (Exception e) {
			if(e.getMessage() == null){
				System.out.println("Unknows exception occured");
			} else {
				System.out.println(e.getMessage());
			}
		}
	}
	
	@Test
	public void testExpression10() {
		try {
			int answer = ExpressionEvaluation.evaluateExpression("12 || 0");
			int expectedAnswer = 1;
			assertEquals(answer, expectedAnswer);
		} catch (Exception e) {
			if(e.getMessage() == null){
				System.out.println("Unknows exception occured");
			} else {
				System.out.println(e.getMessage());
			}
		}
	}
}
