package employee;

import java.util.Comparator;

/**
 * Comparator class to compare employees based on empId
 *
 */
public class CompareEmpId implements Comparator<Employee> {

	/**
	 * Compare empId
	 */
	@Override
	public int compare(Employee employee1, Employee employee2) {
		if(employee1.getEmpId() < employee2.getEmpId()) {
			return -1;
		} else if(employee1.getEmpId() > employee2.getEmpId()) {
			return 1;
		} else {
			return 0;
		}
	}
}
