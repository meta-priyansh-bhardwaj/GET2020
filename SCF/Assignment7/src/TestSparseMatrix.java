import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
public class TestSparseMatrix {

	//test for null value as input
	@Test
	public void testMatrixNullArray() {
		 try {
			 new SparseMatrix(null);
		 }
		 catch (Exception e) {
			 assertEquals("No matrix found", e.getMessage());
		 }
	}

	//test for Empty Array input
	@Test
	public void testMatrixEmptyArray() {
		 try {
			 new SparseMatrix(new int[][]{});
		 }
		 catch (Exception e) {
			 assertEquals("Empty matrix", e.getMessage());
		 }
	}

	//Addition operation of two matrix of different size
	@Test
	public void testMatrixAdditionDifferentSizedMatrices() {
		 try {
			 	SparseMatrix mo=new SparseMatrix(new int[][]{{2, 3}, {5, 6}, {6, 9}});
				SparseMatrix mo1=new SparseMatrix(new int[][]{{2, 2, 2, 2}, {2, 2, 2, 2}});
				mo.addMatrix(mo1);
		 }
		 catch (Exception e) {
			 assertEquals("Unmatched dimensions Exception", e.getMessage());
		 }
	}

	//Addition operation when input is null value
	@Test
	public void testMatrixNullValuePassedForAddition() {
		 try {
			 	new SparseMatrix(new int[][]{{1, 2}, {2, 1}}).addMatrix(null);
		 }
		 catch (Exception e) {
			 assertEquals("Null Sparse Matrix passed", e.getMessage());
		 }
	}

	//positive test case for addition operation
	@Test
	   public void test_addMatrix() throws Exception{	
			SparseMatrix mo = new SparseMatrix(new int[][]{{2, 3}, {5, 6}, {6, 9}});
			SparseMatrix mo1 = new SparseMatrix(new int[][]{{2, 2}, {2, 2}, {2, 2}});
			SparseMatrix returnedArrOperation = mo.addMatrix(mo1);
			SparseMatrix expectedMatrix = new SparseMatrix(new int[][]{{4, 5}, {7, 8}, {8, 11}});
			assertTrue( expectedMatrix.equals(returnedArrOperation) );
	   }

	//test for multiplication of two matrices with n x m and p x q size
	@Test
	public void testMatrixMultiplicationDifferentSizedMatrices() {
		 try {
			 	SparseMatrix mo = new SparseMatrix(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
				SparseMatrix mo1 = new SparseMatrix(new int[][]{{2, 2, 2, 2},{2, 2, 2, 2}});
				mo.multiplyMatrix(mo1);
		 }
		 catch (Exception e) {
			 assertEquals("Multiplication cannot be performed", e.getMessage());
		 }
	}

	// positive test case for matrix multiplication
	@Test
	   public void test_multiplyMatrix() throws Exception{	
			SparseMatrix mo = new SparseMatrix(new int[][]{{2, 3}, {5, 6}, {6, 9}});
			SparseMatrix mo1 = new SparseMatrix(new int[][]{{2, 2, 2, 2}, {2, 2, 2, 2}});
			SparseMatrix returnedArrOperation = mo.multiplyMatrix(mo1);
		    SparseMatrix expectedMatrix = new SparseMatrix(new int[][]{{10, 10, 10, 10}, {22, 22, 22, 22}, {30, 30, 30, 30}});
		    assertTrue( expectedMatrix.equals(returnedArrOperation) );
	   }

	// test for null value inputs in matrix multiplication
	@Test
	public void testMatrixNullValuePassedForMultiplication() {
		 try {
			 	new SparseMatrix(new int[][]{{1, 2}, {2, 1}}).multiplyMatrix(null);
		 }
		 catch (Exception e) {
			 assertEquals("Null Sparse Matrix passed", e.getMessage());
		 }
	}

	// test for transpose of matrix
	@Test
	   public void testTransposeMatrix() throws Exception{	
			SparseMatrix mo = new SparseMatrix(new int[][]{{2, 3}, {5, 6}, {6, 9}});
			SparseMatrix returnedArrOperation = mo.transpose();
			SparseMatrix expectedMatrix = new SparseMatrix(new int[][]{{2, 5, 6}, {3, 6, 9}});
			assertTrue( expectedMatrix.equals(returnedArrOperation) );
	   }

	//positive test case for symmetric matrix
	@Test
	   public void testSymmetricMatrix_positive() throws Exception{	
			SparseMatrix mo = new SparseMatrix(new int[][]{{1, 2, 3}, {2, 5, 4}, {3, 4, 9}});
			 assertTrue(mo.isSymmetric() );
	   }

	//negative test case for symmetric matrix where matrix is of n x m size 
	@Test
	   public void testSymmetricMatrix_Negative_Row_Column_Not_Same() throws Exception{	
			SparseMatrix mo = new SparseMatrix(new int[][]{{2, 3}, {5, 4}, {4, 9}});
			 assertFalse(mo.isSymmetric());
	   }

	// negative test case for symmetric matric where matrix is of n x n size
	@Test
	   public void testSymmetricMatrix_Negative() throws Exception{	
			SparseMatrix mo = new SparseMatrix(new int[][]{{2, 3, 1} ,{5, 4, 6}, {7, 8, 9}});
			 assertFalse(mo.isSymmetric());
	   }
}