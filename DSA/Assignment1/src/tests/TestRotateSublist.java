package tests;
import static org.junit.Assert.*;
import linkedList.LinkedList;

import org.junit.Test;

/**
 * Class to test RotateSublist of LinkedList
 *
 */
public class TestRotateSublist {
	
	@Test
	public void testRotateSublist1(){
		try{
			LinkedList linkedList = new LinkedList(new int[]{2,3,4,5,6,7});
			linkedList.rotateSubList(2, 5, 2);
			
			LinkedList expectedList = new LinkedList(new int[]{2,5,6,3,4,7});
	
			assertTrue(expectedList.equals(linkedList));
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testRotateSublist2(){
		try{
			LinkedList linkedList = new LinkedList(new int[]{2,3,4,5,6,7});
			linkedList.rotateSubList(1, 5, 3);
			
			LinkedList expectedList = new LinkedList(new int[]{5,6,2,3,4,7});
	
			assertTrue(expectedList.equals(linkedList));
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testRotateSublist3(){
		try{
			LinkedList linkedList = new LinkedList(new int[]{2,3,4,5,6,7});
			linkedList.rotateSubList(2, 6, 3);
			
			LinkedList expectedList = new LinkedList(new int[]{2,6,7,3,4,5});
	
			assertTrue(expectedList.equals(linkedList));
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void TestRotateSublist4(){
		try{
			LinkedList linkedList = new LinkedList(new int[]{2,3,4,5,6,7});
			linkedList.rotateSubList(1, 6, 3);
			
			LinkedList expectedList = new LinkedList(new int[]{5,6,7,2,3,4});
	
			assertTrue(expectedList.equals(linkedList));
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
