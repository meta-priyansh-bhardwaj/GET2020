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
		MultivariatePolynomial polynomial = new MultivariatePolynomial(new double[]{4.6,3.5,6.0,5.4},
				new char[][]{{'x','y'}, {'x','z'},{'w','y'}, {}},
				new int[][]{{1,1}, {4,1}, {3,4}, {}});
		int expectedDegree = 7;
		Assert.assertEquals(expectedDegree, polynomial.findDegree());
	}
	
	@Test
	public void testMultivariatePolynomil2() {
		MultivariatePolynomial polynomial = new MultivariatePolynomial(new double[]{4.6,3.5,6.0,5.4},
				new char[][]{{'x','y'}, {'x','z'},{'w','y'}, {}},
				new int[][]{{1,2}, {6,1}, {4,4}, {}});
		int expectedDegree = 8;
		System.out.println(polynomial.findDegree());
		Assert.assertEquals(expectedDegree, polynomial.findDegree());
	}
}
