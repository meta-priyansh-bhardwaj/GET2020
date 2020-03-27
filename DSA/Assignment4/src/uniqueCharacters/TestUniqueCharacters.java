package uniqueCharacters;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Class to test Unique Characters Counting Function
 *
 */
class TestUniqueCharacters {

	@Test
	public void testUniqueCharacters1() {
		assertEquals(1, UniqueCharacters.countUniqueCharacters("mmmmmmmmmn"));
		assertEquals(3, UniqueCharacters.countUniqueCharacters("hello"));
		assertEquals(1, UniqueCharacters.countUniqueCharacters("malyalam"));
		assertEquals(8, UniqueCharacters.countUniqueCharacters("asdfgghjkl"));
	}

	@Test
	public void testUniqueCharacters2() {
		assertEquals(0, UniqueCharacters.countUniqueCharacters(""));
		assertEquals(1, UniqueCharacters.countUniqueCharacters(" "));
		assertEquals(0, UniqueCharacters.countUniqueCharacters("  "));
	}
}
