package tests;

import org.junit.Assert;
import org.junit.Test;

import polynomial.MultivariatePolynomial;

/**
 * Class to test Multivariate Polynomial findDegree method
 *
 */
public class TestMultivariatePolynomial {

	@Test
	public void testMultivariatePolynomial1() {
		try{
			MultivariatePolynomial polynomial = new MultivariatePolynomial(new double[]{4.6,3.5,6.0,5.4},
					new char[][]{{'x','y'}, {'x','z'},{'w','y'}, {}},
					new int[][]{{1,1}, {4,1}, {3,4}, {}});
			int expectedDegree = 7;
			Assert.assertEquals(expectedDegree, polynomial.findDegree());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testMultivariatePolynomil2() {
		try{
			MultivariatePolynomial polynomial = new MultivariatePolynomial(new double[]{4.6,3.5,6.0,5.4},
					new char[][]{{'x','y'}, {'x','z'},{'w','y'}, {}},
					new int[][]{{1,2}, {6,1}, {4,4}, {}});
			int expectedDegree = 8;
			Assert.assertEquals(expectedDegree, polynomial.findDegree());
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
