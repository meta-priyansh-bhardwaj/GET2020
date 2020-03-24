package stack;

/**
 *	Class to implement Stack 
 *
 */
public class StackImplementation implements Stack {
	private static final int CAPACITY = 10000;
	private String[] storage;
	private int top;

	/**
	 * Default constructor to initialize storage and top index 
	 */
	public StackImplementation() {
		this.storage = new String[CAPACITY];
		this.top = -1;
	}

	/**
	 * Function to push item into stack
	 * @param item
	 * @throws Exception on Stack Overflow
	 */
	@Override
	public void push(String item) throws Exception {
		if (this.isFull()) {
			throw new Exception("Stack Overflow");
		}
		this.storage[++this.top] = item;
	}

	/**
	 * Function to pop from stack
	 * @return top item
	 * @throws Exception on Stack Underflow
	 */
	@Override
	public String pop() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("Stack Underflow");
		}
		return this.storage[this.top--];
	}

	/**
	 * Function to access item on top of stack
	 * @return top item
	 * @throws Exception on Stack Underflow
	 */
	@Override
	public String top() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("Stack Underflow");
		}
		return this.storage[this.top];
	}

	/**
	 * Function to check if stack is empty
	 * @return true if empty or false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return (this.top == -1);
	}

	/**
	 * Function to check if stack is full
	 * @return true if full or false otherwise
	 */
	@Override
	public boolean isFull() {
		return (this.top + 1 == CAPACITY);
	}

}