package tests;
import static org.junit.Assert.*;
import linkedList.LinkedList;

import org.junit.Test;

/**
 * Class to test detectLoop method of LinkedList
 * @author Priyansh
 *
 */
public class TestDetectLoop {

	@Test
	public void testDetectLoop1() {
		LinkedList linkedList = new LinkedList(new int[]{2,3,4,5,6,7});
		linkedList.createLoop(3);
		assertTrue(linkedList.detectLoop());
	}

	@Test
	public void testDetectLoop2() {
		LinkedList linkedList = new LinkedList(new int[]{2,3,4,5,6,7});
		assertFalse(linkedList.detectLoop());
	}
}
