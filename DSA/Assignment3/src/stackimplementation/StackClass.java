package stackimplementation;

public class StackClass implements StackInterface{
	
	//size of stack
	private static final int SIZE_OF_STACK = 100;
	private String[] stack = new String[SIZE_OF_STACK];
	
	//pointing to the latest added element of stack
	private int top = -1;
	
	/*
	 * function to push element into stack
	 * @param element is the element to be pushed to stack
	 */
	@Override
	public void push(String element) {
		top = top+1;
		stack[top] = element;
	}

	/*
	 * function to remove element from stack
	 * @return popped element
	 * @throws exception if stack is empty
	 */
	@Override
	public String pop() throws Exception {
		
		if (top==-1){
			throw new Exception ("Stack is empty");
		}
		String poppedElement = stack[top];
		top = top-1;
		return poppedElement;
	}
	
	/*
	 * function to check whether stack is empty
	 * @return true if stack is empty, false otherwise
	 */
	@Override
	public Boolean isEmpty(){
		if (top==-1){
			return true;
		}
		return false;
	}
	
	/*
	 * function to return the topmost element of stack.
	 */
	@Override
	public String peek() throws Exception{
		if (top==-1){
			throw new Exception ("Stack is empty");
		}
		
		return stack[top];
	}
}
