package metaparking.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class that represents an EndUser 
 *
 */
@Entity
@Table(name = "EndUser")
public class EndUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private boolean active;
	private String roles;
	
	/**
	 * Function to get id
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Function to set id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Function to get username
	 * @return username
	 */
	@Column(name="username")
	public String getUsername() {
		return username;
	}
	
	/**
	 * Function to set username
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Function to get password
	 * @return password
	 */
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	
	/**
	 * Function to set password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Function to get if user is active
	 * @return active
	 */
	@Column(name="active")
	public boolean getActive() {
		return active;
	}
	
	/**
	 * Function to set active
	 * @param active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	
	/**
	 * Function to get roles of of the EndUser
	 * @return roles
	 */
	@Column(name="roles")
	public String getRoles() {
		return roles;
	}
	
	/**
	 * Function to set roles
	 * @param roles
	 */
	public void setRoles(String roles) {
		this.roles = roles;
	}

	/**
	 * Function to return EndUser as a string
	 */
	@Override
	public String toString() {
		return "EndUser [id=" + id + ", username=" + username + ", password=" + password + ", active=" + active
				+ ", roles=" + roles + "]";
	}

}