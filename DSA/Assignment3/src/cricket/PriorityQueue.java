package cricket;

/**
 * mj 
 *
 */
public interface PriorityQueue {
	
	/**
	 * Function to push item to queue
	 * @param item
	 * @throws Exception on Queue Overflow
	 */
	public void push(Bowler item) throws Exception;
	
	/**
	 * Function to access top element
	 * @return top element
	 * @throws Exception on Queue Underflow
	 */
	public Bowler top() throws Exception;
	
	/**
	 * Function to pop top element from queue
	 * @return top element
	 * @throws Exception on Queue Underflow
	 */
	public Bowler pop() throws Exception;
	
	/**
	 * Function to check if Queue is empty
	 * @return true if queue is Empty of false otherwise
	 */
	public boolean isEmpty();
	
	/**
	 * Function to check if Queue is full
	 * @return true if queue is Full of false otherwise
	 */
	public boolean isFull();
}
