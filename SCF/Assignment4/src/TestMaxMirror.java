import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestMaxMirror {
	private int input[];
	private int expectedOutput;
	
	public TestMaxMirror(int input[], int expectedOutput){
		this.input = input;
		this.expectedOutput = expectedOutput;
	}
	
	@Parameterized.Parameters
	public static Collection input() {
		return Arrays.asList(new Object[][]{
				{new int[]{},0},
				{new int[]{1, 2, 3, 8, 9, 3, 2, 1},3},
				{new int[]{7,1,4,9,7,4,1},2},
				{new int[]{1, 2, 1,4},3},
				{new int[]{1, 4, 5, 3, 5, 4, 1}, 7}
		});
	}
	
	@Test
	public void testMaxMirror(){
		try{
			assertEquals(expectedOutput, ArrayOperation.maxMirror(input));
		}
		catch(Exception e){
			if(input.length==0){
				assertEquals("Empty Array", e.getMessage());
			}
		}
	}
}