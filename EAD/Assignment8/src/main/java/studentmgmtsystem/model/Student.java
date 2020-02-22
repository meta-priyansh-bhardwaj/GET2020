package studentmgmtsystem.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Model to implement Student class 
 *
 */
public class Student {
	private int id;
	
	/**
	 * firstName cannot be null and length should be between 2 and 20
	 */
	@NotBlank(message="{emptyField}")
	@Size(min=2, max=20, message="{badLength}")
	private String firstName;
	
	/**
	 * lastName cannot be null and length should be between 2 and 20
	 */
	@NotBlank(message="{emptyField}")
	@Size(min=2, max=20, message="{badLength}")
	private String lastName;
	
	/**
	 * fatherName cannot be null and length should be between 2 and 20
	 */
	@NotBlank(message="{emptyField}")
	@Size(min=2, max=20, message="{badLength}")
	private String fatherName;
	
	/**
	 * email cannot be null and should be valid
	 */
	@NotBlank(message="{emptyField}")
	@Email(message="{badEmail}")
	private String email;
	
	/**
	 * standard(class) should be between 1 and 12 
	 */
	@Min(value=1, message="{badClass}")
	@Max(value=12, message="{badClass}")
	private int standard;
	
	/**
	 * age should be between 1 and 100
	 */
	@Min(value=1, message="{badAge}")
	@Max(value=100, message="{badAge}")
	private int age;
	
	/**
	 * Getter function
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Setter function to set id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Getter function to get firstName
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Setter function to set firstName
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Getter function to get lastName
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Setter function to set lastName
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Getter function to get fatherName
	 * @return fatherName
	 */
	public String getFatherName() {
		return fatherName;
	}
	
	/**
	 * Setter function to set fatherName
	 * @param fatherName
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	
	/**
	 * Getter function to get email
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Setter function to set email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Getter function to get standard
	 * @return standard
	 */
	public int getStandard() {
		return standard;
	}
	
	/**
	 * Seeter function to set standard
	 * @param standard
	 */
	public void setStandard(int standard) {
		this.standard = standard;
	}
	
	/**
	 * Getter function to get age
	 * @return age
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Setter function to set age
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * Function to show student to string form
	 */
	@Override
	public String toString() {
		return "Student [first_name=" + firstName + ", last_name=" + lastName + ", father_name=" + fatherName
				+ ", email=" + email + ", std=" + standard + ", age=" + age + "]";
	}
}
