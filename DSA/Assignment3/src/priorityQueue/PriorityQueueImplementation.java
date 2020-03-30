package priorityQueue;

/**
 * Class to implement Priority Queue
 * The implementation is using an array
 * and visualising heap
 *
 */
public class PriorityQueueImplementation implements PriorityQueue {
	private final int capacity;
	private int size;
	private int[] storage;

	/**
	 * Constructor to initialize storage
	 * @param capacity of the Priority Queue
	 */
	public PriorityQueueImplementation(int capacity) {
		this.capacity = capacity;
		this.storage = new int[this.capacity];
		this.size = 0;
	}

	/**
	 * Function to return parent of index
	 * @param index
	 * @return parent of index
	 */
	private static int parent(int index) {
		return (index - 1) / 2;
	}

	/**
	 * Function to return left child of index
	 * @param index
	 * @return left child index
	 */
	private static int leftChild(int index) {
		return index * 2 + 1;
	}

	/**
	 * Function to return right child of index
	 * @param index
	 * @return right child index
	 */
	private static int rightChild(int index) {
		return index * 2 + 2;
	}

	/**
	 * Function to swap items on given indices
	 * @param index1
	 * @param index2
	 */
	private void swap(int index1, int index2) {
		int temp = this.storage[index1];
		this.storage[index1] = this.storage[index2];
		this.storage[index2] = temp;
	}

	/**
	 * Function to shift item on index up the heap
	 * @param index
	 */
	private void shiftUp(int index) {
		int parentIndex = parent(index);
		while (index > 0 && this.storage[index] > this.storage[parentIndex]) {
			this.swap(index, parentIndex);
			index = parentIndex;
			parentIndex = parent(index);
		}
	}

	/**
	 * Function to shift item on index down the heap
	 * @param index
	 */
	private void shiftDown(int index) {
		int leftChildIndex = leftChild(index);
		int rightChildIndex = rightChild(index);
		while (index < this.size) {
			int shiftIndex = index;
			if(rightChildIndex < this.size) {
				if(this.storage[leftChildIndex] >= this.storage[rightChildIndex]){
					shiftIndex = leftChildIndex;
				} else {
					shiftIndex = rightChildIndex;
				}
			} else if(leftChildIndex < this.size) {
				shiftIndex = leftChildIndex;
			}
			if(this.storage[index] < this.storage[shiftIndex]) {
				this.swap(index, shiftIndex);
				index = shiftIndex;
				leftChildIndex = leftChild(index);
				rightChildIndex = rightChild(index);
			} else {
				break;
			}
		}
	}
	
	/**
	 * Function to push item to queue
	 * @param item
	 * @throws Exception on Queue Overflow
	 */
	@Override
	public void push(int item) throws Exception {
		if(this.isFull()) {
			throw new Exception("Queue Ovarflow");
		}
		this.storage[this.size++] = item;
		this.shiftUp(this.size - 1);
	}
	
	/**
	 * Function to access top element
	 * @return top element
	 * @throws Exception on Queue Underflow
	 */
	@Override
	public int top() throws Exception {
		if(this.isEmpty()){
			throw new Exception("Queue Underflow");
		}
		return this.storage[0];
	}
	
	/**
	 * Function to pop top element from queue
	 * @return top element
	 * @throws Exception on Queue Underflow
	 */
	@Override
	public int pop() throws Exception {
		if(this.isEmpty()){
			throw new Exception("Queue Underflow");
		}
		int item = this.storage[0];
		this.storage[0] = this.storage[--this.size];
		this.shiftDown(0);
		return item;
	}

	/**
	 * Function to check if Queue is empty
	 * @return true if queue is Empty of false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	/**
	 * Function to check if Queue is full
	 * @return true if queue is Full of false otherwise
	 */
	@Override
	public boolean isFull() {
		return this.size == this.capacity;
	}
}
