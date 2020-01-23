import static org.junit.Assert.*;
import org.junit.Test;

public class TestNQueens {
	NQueens Queen = new NQueens(); 

	@Test
	public void testsolveNQ() {
	   try { 
		   NQueens.solveNQueens(0);
	   }
	   catch (Exception e) {
		   assertEquals("Zero no. of Queens", e.getMessage());
	   }
	}

	@Test
	   public void testsolveNQ_positive() throws Exception{	  
		   assertEquals(true, NQueens.solveNQueens(4) );
	 }

	 @Test
	   public void testsolveNQ_negative() throws Exception{	  
		   assertEquals(false, NQueens.solveNQueens(3) );
	 }
}
