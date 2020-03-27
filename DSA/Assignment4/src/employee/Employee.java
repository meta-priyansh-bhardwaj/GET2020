package employee;

/**
 * Abstract class to visualise an Employee 
 *
 */
public class Employee {
	private Integer empId;
	private String name;
	private String address;
	
	/**
	 * Constructor to initialize empId, name and address
	 * @param empId should be non-negative
	 * @param name should be a non-null and non-empty String
	 * @param address
	 * @throws Exception if name is null or empty
	 */
	public Employee(int empId, String name, String address) throws Exception {
		if(name == null || name.length() == 0) {
			throw new Exception("Null or empty name not allowed!");
		}
		this.empId = empId;
		this.name = name;
		this.address = address;
	}
	
	/**
	 * Function to get empId
	 * @return empId
	 */
	public int getEmpId() {
		return this.empId;
	}
	
	/**
	 * Function to get name
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Function to get address
	 * @return address
	 */
	public String getAddress() {
		return this.address;
	}
	
	/**
	 * Function that returns its hashCode from its empId
	 */
	@Override
	public int hashCode() {
		return this.empId.hashCode();
	}
	
	/**
	 * Function to check equility from its empId
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Employee employee = (Employee)obj;
		return this.empId.equals(employee.empId);
	}
}
