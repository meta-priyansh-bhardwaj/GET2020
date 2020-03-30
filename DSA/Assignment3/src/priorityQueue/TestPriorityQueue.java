package priorityQueue;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Class to test PriorityQueue
 *
 */
public class TestPriorityQueue {

	@Test
	public void testPriorityQueue1() {
		try{
			PriorityQueue priorityQueue = new PriorityQueueImplementation(5);
			priorityQueue.push(5);
			assertFalse(priorityQueue.isEmpty());
			priorityQueue.pop();
			assertTrue(priorityQueue.isEmpty());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testPriorityQueue2() {
		try{
			PriorityQueue priorityQueue = new PriorityQueueImplementation(5);
			for(int i=0;i<5;i++){
				priorityQueue.push(i);
			}
			assertTrue(priorityQueue.isFull());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testPriorityQueue3() {
		try{
			PriorityQueue priorityQueue = new PriorityQueueImplementation(5);
			for(int i=1;i<=5;i++){
				priorityQueue.push(i);
				assertEquals(i, priorityQueue.top());
			}
			for(int i=5;i<=1;i--){
				assertEquals(i, priorityQueue.pop());
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
