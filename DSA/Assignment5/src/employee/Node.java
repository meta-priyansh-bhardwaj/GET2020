package employee;

/**
 * Class to represent node of a Linked List
 *
 */
public class Node {
	private Employee employee;
	private Node next;

	/**
	 * Constructor to initialize employee
	 * @param employee is a non-null Employee
	 * @throws Exception if employee is null
	 */
	public Node(Employee employee) throws Exception {
		if(employee == null) {
			throw new Exception("Employee can't be null");
		}
		this.employee = employee;
	}
	
	/**
	 * Function to get employee
	 * @return employee
	 */
	public Employee getEmployee() {
		return this.employee;
	}
	
	/**
	 * Function to get next node of the linked list
	 * @return next
	 */
	public Node getNext() {
		return this.next;
	}
	
	/**
	 * Function to set next node
	 * @param node
	 */
	public void setNext(Node node) {
		this.next = node;
	}
}
