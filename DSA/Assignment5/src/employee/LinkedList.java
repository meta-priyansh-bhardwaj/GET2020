package employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent a Linked List
 *
 */
public class LinkedList {
	private Node head;

	/**
	 * Function to insert node in the linked list
	 * 
	 * @param employee is a non-null Employee
	 * @throws Exception if employee is null
	 */
	public void insert(Employee employee) throws Exception {
		Node node = new Node(employee);
		if (this.head == null) {
			this.head = node;
			return;
		}
		Node currentNode = this.head;
		while (currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
		}
		currentNode.setNext(node);
	}

	/**
	 * Function to sort employees based on salary in descending order
	 * @throws Exception if any employee found null
	 */
	public void sort() throws Exception {
		List<Employee> employees = this.returnAsList();
		this.head = null;
		for(Employee employee: employees) {
			Node node = new Node(employee);
			if(this.head == null) {
				this.head = node;
				continue;
			}
			Node currentNode = this.head;
			Node previousNode = null;
			while(currentNode != null) {
				Employee currentEmployee = currentNode.getEmployee();
				if(employee.getSalary() > currentEmployee.getSalary()
						|| (employee.getSalary() == currentEmployee.getSalary()
							&& employee.getAge() < currentEmployee.getAge())) {
					node.setNext(currentNode);
					if(previousNode == null) {
						this.head = node;
					} else {
						previousNode.setNext(node);
					}
					break;
				}
				previousNode = currentNode;
				currentNode = currentNode.getNext();
			}
			if(currentNode == null) {
				previousNode.setNext(node);
			}
		}
	}

	/**
	 * Function to return all the nodes in an array list in same order
	 * 
	 * @return list of Employee
	 */
	public List<Employee> returnAsList() {
		List<Employee> employees = new ArrayList<Employee>();
		for (Node currentNode = this.head; currentNode != null; currentNode = currentNode.getNext()) {
			employees.add(currentNode.getEmployee());
		}
		return employees;
	}
}
