package counselling;

/**
 *	Class to implement Queue of Students
 *
 */
public class StudentQueue {
	private final int size;
	private Student[] storage;
	private int front;
	private int rear;

	/**
	 * Default constructor to initialize storage, front and rear indices
	 */
	public StudentQueue(int size) {
		this.size = size;
		this.storage = new Student[this.size];
		this.front = -1;
		this.rear = -1;
	}

	/**
	 * Helper function that increases index by 1 within mod this.size
	 * @param index
	 * @return (index + 1) mod this.size
	 */
	private int increment(int index){
		return (index + 1) % this.size;
	}

	/**
	 * Function to enqueue item into queue
	 * @param item
	 * @throws Exception on Queue Overflow
	 */
	public void enQueue(Student item) throws Exception {
		if(this.isFull()){
			 throw new Exception("Queue Overflow");
		}
		if(this.isEmpty()){
			this.front = 0;
			this.rear = 0;
		} else {
			this.rear = increment(rear);
		}
		this.storage[this.rear] = item;
	}

	/**
	 * Function to dequeue from queue
	 * @return front item
	 * @throws Exception on Queue Underflow
	 */
	public Student deQueue() throws Exception {
		if(this.isEmpty()){
			 throw new Exception("Queue Underflow");
		}
		Student item = this.storage[this.front];
		if(this.front == this.rear){
			this.front = -1;
			this.rear = -1;
		} else {
			this.front = increment(this.front);
		}
		return item;
	}

	/**
	 * Function to return item in front
	 * @return front item
	 * @throws Exception on Queue Underflow
	 */
	public Student front() throws Exception {
		if(this.isEmpty()){
			throw new Exception("Queue Underflow");
		}
		return this.storage[this.front];
	}
	
	/**
	 * Function to check if queue is empty
	 * @return true if empty or false otherwise
	 */
	public boolean isEmpty() {
		return (this.front == -1 && this.rear == -1);
	}

	/**
	 * Function to check if queue is full
	 * @return true if full or false otherwise
	 */
	public boolean isFull() {
		return (increment(this.rear) == this.front);
	}

}
