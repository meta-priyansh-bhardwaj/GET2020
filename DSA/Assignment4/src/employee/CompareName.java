package employee;

import java.util.Comparator;

/**
 * Comparator class to compare employees based on name
 *
 */
public class CompareName implements Comparator<Employee> {

	/**
	 * Compare name
	 */
	@Override
	public int compare(Employee employee1, Employee employee2) {
		return employee1.getName().compareTo(employee2.getName());
	}
}
