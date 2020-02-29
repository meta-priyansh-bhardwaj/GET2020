package metaparking.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * Class to implement User Login Credentials
 *
 */
public class UserDto {

	@NotBlank(message = "Please enter email id")
	@Email(message = "Please enter valid email")
	private String emailId;

	@Pattern(regexp = "^[a-zA-Z0-9!@#$%^&*_-]{8,}$", message = "Please enter valid password")
	private String password;

	/**
	 * Getter function to get emailId
	 * @return emailId
	 */
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

	@Override
	public String toString() {
		return "UserDto [emailId=" + emailId + ", password=" + password + "]";
	}
}