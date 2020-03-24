package queue;

/**
 * Interface to visualise queue 
 *
 */
public interface Queue {
	
	/**
	 * Function to enqueue item into queue
	 * @param item
	 * @throws Exception on Queue Overflow
	 */
	public void enQueue(int item) throws Exception;
	
	/**
	 * Function to dequeue from queue
	 * @return front item
	 * @throws Exception on Queue Underflow
	 */
	public int deQueue() throws Exception;
	
	/**
	 * Function to return item in front
	 * @return front item
	 * @throws Exception on Queue Underflow
	 */
	public int front() throws Exception;
	
	/**
	 * Function to check if queue is empty
	 * @return true if empty or false otherwise
	 */
	public boolean isEmpty();
	
	/**
	 * Function to check if queue is full
	 * @return true if full or false otherwise
	 */
	public boolean isFull();
}
