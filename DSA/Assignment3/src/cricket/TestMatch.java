package cricket;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Class to test plan strategy of Match
 *
 */
public class TestMatch {

	@Test
	public void testMatch1() {
		try {
			Bowler[] bowlers = new Bowler[3];
			bowlers[0] = new Bowler("Steyn", 6);
			bowlers[1] = new Bowler("Bumrah", 4);
			bowlers[2] = new Bowler("Starc", 8);
			Match match = new Match(10, bowlers);

			List<String> expectedResult = Arrays.asList("Starc", "Steyn",
					"Starc", "Steyn", "Bumrah");
			List<String> actualResult = match.planStrategy();

			assertTrue(expectedResult.equals(actualResult));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testMatch2() {
		try {
			Bowler[] bowlers = new Bowler[3];
			bowlers[0] = new Bowler("Boult", 5);
			bowlers[1] = new Bowler("Ferguson", 4);
			bowlers[2] = new Bowler("Rabada", 3);
			Match match = new Match(5, bowlers);

			List<String> expectedResult = Arrays.asList("Boult", "Ferguson", "Boult");
			List<String> actualResult = match.planStrategy();

			assertTrue(expectedResult.equals(actualResult));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
