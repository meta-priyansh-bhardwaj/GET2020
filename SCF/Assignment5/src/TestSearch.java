import static org.junit.Assert.*;
import org.junit.Test;
public class TestSearch {

	@Test
	public void testLinearSearchEmptyArray() {
		 try {
			 Search.LinearSearch(new int[]{}, 5);
		 }
		 catch (Exception e) {
			 assertEquals("Empty Array", e.getMessage());
		 }
	}

	

	@Test
	public void testLinearSearchPositiveInput() throws Exception {
		 assertEquals(-1,Search.LinearSearch(new int[]{1,2,3,4,5},0));  
	}

	@Test
	public void testLinearSearchNegativeInput() throws Exception {
		 assertEquals(-1,Search.LinearSearch(new int[]{1,2,3,4,5},9));  
	}

	@Test
	public void testBinarySearchEmptyArray() {
		 try {
			 Search.BinarySearch(new int[]{},8);
		 }
		 catch (Exception e) {
			 assertEquals("Empty Array", e.getMessage());
		 }
	}

	@Test
	public void testBinarySearchIndexOutOfBound() {
		 try {
			 Search.BinarySearch(new int[]{1,2,3}, 8);
		 }
		 catch (Exception e) {
			 assertEquals("Array Index Out Of Bound", e.getMessage());
		}
	}

	@Test
	public void testBinarySearchPositiveInput() throws Exception {
		 assertEquals(2,Search.BinarySearch(new int[]{1,2,3,4,5},3));  
	}

	@Test
	public void testBinarySearchNegativeInput() throws Exception {
		 assertEquals(-1,Search.BinarySearch(new int[]{1,2,3,4,5},9));  
	}
}

