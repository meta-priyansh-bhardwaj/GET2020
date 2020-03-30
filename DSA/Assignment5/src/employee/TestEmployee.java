package employee;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Class to test Employee class
 *
 */
class TestEmployee {

	@Test
	void testEmplyee1() {
		try {
			LinkedList linkedList = new LinkedList();
			
			List<Employee> expectedOrder = new ArrayList<Employee>();
			
			expectedOrder.add(new Employee("Jyoti", 17, 800));
			expectedOrder.add(new Employee("Shyam", 18, 600));
			expectedOrder.add(new Employee("Ram", 19, 500));
			
			linkedList.insert(expectedOrder.get(2));
			linkedList.insert(expectedOrder.get(1));
			linkedList.insert(expectedOrder.get(0));
			linkedList.sort();
			
			List<Employee> resultingOrder = linkedList.returnAsList();
			
			assertTrue(expectedOrder.equals(resultingOrder));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test
	void testEmplyee2() {
		try {
			LinkedList linkedList = new LinkedList();
			
			List<Employee> expectedOrder = new ArrayList<Employee>();
			
			expectedOrder.add(new Employee("Jyoti", 17, 800));
			expectedOrder.add(new Employee("Shyam", 18, 500));
			expectedOrder.add(new Employee("Ram", 19, 500));
			
			linkedList.insert(expectedOrder.get(2));
			linkedList.insert(expectedOrder.get(1));
			linkedList.insert(expectedOrder.get(0));
			linkedList.sort();
			
			List<Employee> resultingOrder = linkedList.returnAsList();
						
			assertTrue(expectedOrder.equals(resultingOrder));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			fail();
		}
	}
	
	@Test
	void testEmplyee3() {
		try {
			LinkedList linkedList = new LinkedList();
			
			List<Employee> expectedOrder = new ArrayList<Employee>();
			
			expectedOrder.add(new Employee("Jyoti", 17, 800));
			expectedOrder.add(new Employee("Shyam", 18, 800));
			expectedOrder.add(new Employee("Ram", 19, 800));
			
			linkedList.insert(expectedOrder.get(2));
			linkedList.insert(expectedOrder.get(1));
			linkedList.insert(expectedOrder.get(0));
			linkedList.sort();
			
			List<Employee> resultingOrder = linkedList.returnAsList();
			
			assertTrue(expectedOrder.equals(resultingOrder));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			fail();
		}
	}
}
