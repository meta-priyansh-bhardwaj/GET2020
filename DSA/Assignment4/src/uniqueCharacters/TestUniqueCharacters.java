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
		assertEquals(2, UniqueCharacters.countUniqueCharacters("mmmmmmmmmn"));
		assertEquals(4, UniqueCharacters.countUniqueCharacters("hello"));
		assertEquals(4, UniqueCharacters.countUniqueCharacters("malyalam"));
		assertEquals(9, UniqueCharacters.countUniqueCharacters("asdfgghjkl"));
	}

	@Test
	public void testUniqueCharacters2() {
		assertEquals(0, UniqueCharacters.countUniqueCharacters(""));
		assertEquals(1, UniqueCharacters.countUniqueCharacters(" "));
		assertEquals(1, UniqueCharacters.countUniqueCharacters("  "));
	}
}
