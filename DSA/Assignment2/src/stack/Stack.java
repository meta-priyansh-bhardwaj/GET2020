package stack;

/**
 * Interface to visualise stack 
 *
 */
public interface Stack {
	
	/**
	 * Function to push item into stack
	 * @param item
	 * @throws Exception on Stack Overflow
	 */
	public void push(String item) throws Exception;
	
	/**
	 * Function to pop from stack
	 * @return top item
	 * @throws Exception on Stack Underflow
	 */
	public String pop() throws Exception;
	
	/**
	 * Function to access item on top of stack
	 * @return top item
	 * @throws Exception on Stack Underflow
	 */
	public String top() throws Exception;
	
	/**
	 * Function to check if stack is empty
	 * @return true if empty or false otherwise
	 */
	public boolean isEmpty();
	
	/**
	 * Function to check if stack is full
	 * @return true if full or false otherwise
	 */
	public boolean isFull();
}
