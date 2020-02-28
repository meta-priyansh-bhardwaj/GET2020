package metaparking.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Class to represent a user
 *
 */
@Entity
@Table(name="User")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;

	@Pattern(regexp = "^[a-zA-Z]{2,}\\s?[a-zA-Z]{2,}$", message = "Please enter valid Name")
	private String fullName;

	@NotNull
	private String gender;

	@NotBlank(message = "Please enter email id")
	@Email(message = "Please enter valid email")
	private String emailId;

	@Pattern(regexp = "^[a-zA-Z0-9!@#$%^&*_-]{8,}$", message = "Please enter valid password")
	private String password;

	@Pattern(regexp = "^[a-zA-Z0-9!@#$%^&*_-]{8,}$", message = "Please enter valid confirm password")
	private String confirmPassword;

	@Pattern(regexp = "^[0-9]{10,15}", message = "Please enter valid contact number")
	private String contactNumber;

	@Pattern(regexp = "^[a-zA-Z0-9]{2,}$", message = "Please enter valid Org. Name")
	private String orgName;
		
	private String profilePicture;

	/**
	 * Getter function to get empId
	 * @return empId
	 */
	@Column(name="empId")
	public int getEmpId() {
		return empId;
	}

	/**
	 * Setter function to set emaId
	 * @param empId
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	/**
	 * Getter function to get fullName
	 * @return fullName
	 */
	@Column(name="fullName")
	public String getFullName() {
		return fullName;
	}

	/**
	 * Setter function to set fullName
	 * @param fullName
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * Getter function to get gender
	 * @return gender
	 */
	@Column(name="gender")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Getter function to get emailId
	 * @return emailId
	 */
	@Column(name="emailId")
	public String getEmailId() {
		return emailId;
	}

	/**
	 * Setter function to set emailId
	 * @param emailId
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * Getter function to get password
	 * @return password
	 */
	@Column(name="password")
	public String getPassword() {
		return password;
	}

	/**
	 * Setter function to set password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter function to get confirmPassword
	 * @return confirmPassword
	 */
	@Column(name="confirmPassword")
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * Setter function to set confirmPassword
	 * @param confirmPassword
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * Getter function to get contactNumber
	 * @return contactNumber
	 */
	@Column(name="contactNumber")
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * Setter function to set contactNumber
	 * @param contactNumber
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * Getter function to get orgName
	 * @return orgName
	 */
	@Column(name="orgName")
	public String getOrgName() {
		return orgName;
	}

	/**
	 * Setter function to set orgName
	 * @param orgName
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	/**
	 * Setter function to set profilePicture
	 * @param profilePicture
	 */
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	
	/**
	 * Getter function to get profilePicture
	 * @return profilePicture
	 */
	@Column(name="profilePicture")
	public String getProfilePicture() {
		return profilePicture;
	}

	/**
	 * Function to return user in string form
	 */
	@Override
	public String toString() {
		return "User [empId=" + empId + ", fullName=" + fullName + ", gender=" + gender + ", emailId=" + emailId
				+ ", password=" + password + ", confirmPassword=" + confirmPassword + ", contactNumber=" + contactNumber
				+ ", orgName=" + orgName + ", profilePicture=" + profilePicture + "]";
	}
}