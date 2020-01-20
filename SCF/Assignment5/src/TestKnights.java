import static org.junit.Assert.*;
import org.junit.Test;

public class TestKnights { 

	@Test
	public void testsolveNQ() {
	   try { 
		   Knights.solveKnights(3);
	   }
	   catch (Exception e) {
		   assertEquals("Too short dimension", e.getMessage());
	   }
	}

	@Test
	   public void testsolveNQ_positive() throws Exception{	  
		   assertEquals(false, Knights.solveKnights(4) );
	 }

	 @Test
	   public void testsolveNQ_negative() throws Exception{	  
		   assertEquals(true, Knights.solveKnights(7) );
	 }
}
