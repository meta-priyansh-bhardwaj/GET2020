import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class SetTest {

	// test of Set values out of range
	@Test
	public void testSet_Out_Range() {
		 try {
			 Set SetArray= new Set( new int[]{-1,1002});
		 }
		 catch (Exception e) {
			 assertEquals("Value out of range", e.getMessage());
		 }
	}

	// positive test case for determining size of Set 
	@Test
	public void testLength()throws Exception  {

			 Set SetArray= new Set( new int[]{6,7,8,10});
			 int returnedValue =SetArray.size(); 
			 int expectedValue = 4;
			 Assert.assertEquals( expectedValue, returnedValue );
	}

	// positive test case to check if the number is member of Set 
	@Test
	public void testFind_Value_Positive() throws Exception {
			 Set SetArray= new Set( new int[]{1,2,3,4,5});
			 assertTrue(SetArray.isMember(4) );	 
	}

	// negative test case to check if the number is member of Set
	@Test
	public void testFind_Value_Negative() throws Exception {
			 Set SetArray= new Set( new int[]{1,2,3,4,5});
			 assertFalse(SetArray.isMember(8) );	 
	}

	//positive test to check if given array is a subSet 
	 @Test
	   public void test_Is_SubSet_Positive() throws Exception{	
		 Set SetArray= new Set( new int[]{1,2,3,4,5});
		 Set subSetArray= new Set( new int[]{1,2,3});
		 assertTrue(SetArray.isSubSet(subSetArray));	   
	   }

	//negative test to check if given array is a subSet 	 
	 @Test
	   public void test_Is_SubSet_Negative() throws Exception{	
		 Set SetArray= new Set( new int[]{1,2,3,4,5});
		 Set subSetArray= new Set( new int[]{7,8});
		 assertFalse(SetArray.isSubSet(subSetArray));	   
	   }

	

	//positive test for union operation of Sets
	 @Test
	   public void test_Union_Set_Same() throws Exception{
		 int[] SetArray1=  new int[]{1,2,3};
		 int[] SetArray2=  new int[]{1,2,3};
		 Set set = new Set(SetArray1);
		 Set returnedSet = set.union(new Set(SetArray2)); 
		 Set expectedSet = new Set(new int[] {1,2,3});
		 assertTrue( expectedSet.equals(returnedSet) );
	   }

	 @Test
	   public void test_Union_Set_Diff() throws Exception{
		 int[] SetArray1=  new int[]{1,2,3};
		 int[] SetArray2= new int[]{4,5,6};
		 Set set = new Set(SetArray1);
		 Set returnedSet = set.union(new Set(SetArray2)); 
		 Set expectedSet = new Set(new int[] {1,2,3,4,5,6});
		 assertTrue( expectedSet.equals(returnedSet) );
	   }

	 @Test
	   public void test_Union_Set_Mix() throws Exception{
		 int[] SetArray1=  new int[]{1,2,3};
		 int[] SetArray2=  new int[]{2,3,5,6};
		 Set set = new Set(SetArray1);
		 Set returnedSet = set.union(new Set(SetArray2)); 
		 Set expectedSet = new Set(new int[] {1,2,3,4,5,6});
		 assertFalse( expectedSet.equals(returnedSet) );
	   }

	 @Test
	   public void test_Union_Set_Null() throws Exception{
		
		 int[] SetArray1=  new int[]{1,2,3};
		 int[] SetArray2=  new int[]{};
		 Set set = new Set(SetArray1);
		 Set returnedSet = set.union(new Set(SetArray2)); 
		 Set expectedSet = new Set(new int[] {1,2,3,4,5,6});
		 assertFalse( expectedSet.equals(returnedSet) );
	   }
}