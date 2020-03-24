package queue;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Class to Test Queue 
 *
 */
public class TestQueue {
	
	@Test
	public void testQueue1(){
		try{
			Queue queue = new QueueImplementation(5);
			queue.enQueue(4);
			queue.enQueue(26);
			assertEquals(queue.front(), 4);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testQueue2(){
		try{
			Queue queue = new QueueImplementation(5);
			queue.enQueue(4);
			queue.enQueue(26);
			queue.deQueue();
			assertEquals(queue.front(), 26);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testQueue3(){
		try{
			Queue queue = new QueueImplementation(5);
			queue.deQueue();
			fail();
		} catch (Exception e) {
			assertTrue("Queue Underflow".equals(e.getMessage()));
		}
	}
	
	@Test
	public void testQueue4(){
		try{
			Queue queue = new QueueImplementation(5);
			for(int i=0;i<6;i++){
				queue.enQueue(i);
			}
			fail();
		} catch (Exception e) {
			assertTrue("Queue Overflow".equals(e.getMessage()));
		}
	}
	
	@Test
	public void testQueue5(){
		try{
			Queue queue = new QueueImplementation(5);
			for(int i=0;i<5;i++){
				queue.enQueue(i);
			}
			queue.deQueue();
			queue.deQueue();
			queue.enQueue(32);
			queue.enQueue(26);
			for(int i=0;i<4;i++){
				queue.deQueue();
			}
			assertEquals(queue.front(), 26);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
