/*
 * Design a class to implement following mathematical problems.
 * L.C.M. of two numbers x and y. Receive x and y as method parameters and
 * return computed value.
 * H.C.F of two numbers x and y using Euclid’s algorithm. Receive x and y as
 * method parameters and return computed value.
 * Assume x and y as positive integers.
 * @author Priyansh
 */
public class Recursion {
	/*
	 * @param x and @param y are two positive integers whose hcf is to be calculated
	 * @return returns hcf of x and y
	 */
	public static int HCF(int x, int y) throws Exception {
		if (x == 0) {
			return y;
		} else if (y == 0) {
			return x;
		} else if (x > y) {
			return HCF(y, x % y);
		} else {
			return HCF(x, y % x);
		}
	}

	/*
	 * @param x and @param y are two positive integers whose lcm is to be calculated
	 * @return returns lcm of x and y
	 */
	public static int LCM(int x, int y) throws Exception {
		int hcf = HCF(x, y);
		if (hcf == 0) {
			throw new Exception("Divide By Zero");
		}
		return (x * y) / HCF(x, y);
	}
};